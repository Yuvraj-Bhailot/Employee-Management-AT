package com.eatm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatm.dao.AttendanceDao;
import com.eatm.dao.EmployeeDao;
import com.eatm.dao.TaskDao;
import com.eatm.dto.AddressDto;
import com.eatm.dto.EmployeeDto;
import com.eatm.dto.TaskDto;
import com.eatm.entity.Address;
import com.eatm.entity.Attendance;
import com.eatm.entity.Employee;
import com.eatm.entity.Task;
import com.eatm.util.EntityMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EntityMapper entityMapper;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	AttendanceDao attendanceDao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ObjectProvider<Attendance> attendanceProvider;
	
	@Override
	public String registerManager(EmployeeDto employeeDto, AddressDto addressDto) {
		Employee employee = entityMapper.convertEmployeeDtoToEntity(employeeDto);
		Address address = entityMapper.convertAddressDtoToEntity(addressDto);
		
		employee.setAddress(address);
		employee.setRole("manager");
		
		employeeDao.saveEmployee(employee);
		
		return "success.jsp";
	}	
	
	@Override
	public String loginEmployee(String email, String password) {
		Integer employeeId = (Integer) session.getAttribute("employeeId");
		
		if (employeeId!=null) {
			String role = (String)session.getAttribute("role");
			if (role.equals("manager")) {
				return "manager.jsp";
			} else if (role.equals("developer")) {
				return "developer.jsp";
			}
			return "success.jsp";
		}
		
		Employee employee = employeeDao.findEmployeeByEmailAndPassword(email, password);
		
		if (employee!=null) {
			Attendance attendance = attendanceProvider.getObject();
			attendanceDao.saveAttendance(attendance);
			
			List<Attendance> list = employee.getAttendances();
			
			if (list==null) {
				list = new ArrayList<Attendance>();
			}
			
			list.add(attendance);
			
			employee.setAttendances(list);
			
			employeeDao.updateEmployee(employee);
			
			session.setAttribute("employeeId", employee.getEmployeeId());
		    session.setAttribute("attendanceId", attendance.getAttendanceId());
		    session.setAttribute("role", employee.getRole());
			
			if (employee.getRole().equals("manager")) {
				return "manager.jsp";
			} else if (employee.getRole().equals("developer")) {
				return "developer.jsp";
			}
			
			return "success.jsp";
		}
		
		request.setAttribute("message", "Invalid email or password.");
		return "login.jsp";
	}
	
	@Override
	public String addDeveloper(EmployeeDto employeeDto, AddressDto addressDto) {
		Employee employee = entityMapper.convertEmployeeDtoToEntity(employeeDto);
		Address address = entityMapper.convertAddressDtoToEntity(addressDto);
		
		employee.setAddress(address);
		employee.setRole("developer");
		
		employeeDao.saveEmployee(employee);
		
		return "success.jsp";
	}

	@Override
	public String createTask(TaskDto taskDto) {
		Task task = entityMapper.convertTaskDtoToEntity(taskDto);
		
		task.setStatus("created explicitly");
		
		taskDao.saveTask(task);
		
		return "success.jsp";
	}

	@Override
	public String assignTask(int taskId, int employeeId) {
		Task task = taskDao.findTaskById(taskId);
		Employee employee = employeeDao.findEmployeeById(employeeId);
		
		task.setStatus("assigned");
		
		List<Task> tasks = employee.getTasks();
		
		if (tasks==null) {
			tasks = new ArrayList<Task>();
		}
		
		tasks.add(task);
		employee.setTasks(tasks);
		
		employeeDao.updateEmployee(employee);
		
		return "success.jsp";
	}

	@Override
	public String deleteDeveloper(int employeeId) {
		Employee employee = employeeDao.findEmployeeById(employeeId);
		
		List<Task> tasks = employee.getTasks();
				
		for (Task task : tasks) {
			if (!task.getStatus().equals("completed")) {
				return "failure.jsp";
			}
		}
		
		employee.setTasks(null);
		
		employeeDao.deleteEmployee(employee);
		
		return "success.jsp";
	}
	
	@Override
	public String viewAllDeveloper() {
		List<Employee> allDeveloper = employeeDao.findAllDeveloper();
		session.setAttribute("developerList", allDeveloper);
		session.setAttribute("entityMapper", entityMapper);
		return "displayDeveloper.jsp";
	}

	@Override
	public String deleteTask(int taskId) {
		Task task = taskDao.findTaskById(taskId);
		
		if (task==null) {
			return "failure.jsp";
		}
		
		if (task.getStatus().equals("assigned") || task.getStatus().equals("completed")) {
			List<Employee> developerList = employeeDao.findAllDeveloper();
			
			for (Employee developer : developerList) {
				List<Task> tasks = developer.getTasks();
				if (tasks.contains(task)) {
					tasks.remove(task);
					developer.setTasks(tasks);
					employeeDao.updateEmployee(developer);
				}
			}
		}
		
		taskDao.deleteTask(task);
		
		return "success.jsp";
	}	

	@Override
	public String logoutEmployee() {

	    int attendanceId = (Integer) session.getAttribute("attendanceId");

	    Attendance attendance = attendanceDao.findAttendanceById(attendanceId);

	    if (attendance != null && attendance.getLogoutTime() == null) {
	        attendance.setLogoutTime(LocalDateTime.now());
	        attendanceDao.updateAttendance(attendance);
	    }

	    session.invalidate();

	    return "login.jsp";
	}

	@Override
	public String verifyEmail(String email) {
		Employee employee = employeeDao.findEmployeeByEmail(email);
		if (employee!=null) {
			session.setAttribute("verifyEmployee", employee);
			return "forgotpassword.jsp";
		}
		return "failure.jsp";
	}

	@Override
	public String forgotPassword(String password) {
		Employee employee = (Employee)session.getAttribute("verifyEmployee");
		employee.setPassword(password);
		employeeDao.updateEmployee(employee);
		return "success.jsp";
	}

	@Override
	public String updateDeveloperName(int id, String employeeName) {
		Employee employee = employeeDao.findEmployeeById(id);

		employee.setEmployeeName(employeeName);
		employeeDao.updateEmployee(employee);
		return "success.jsp";
	}
	
	@Override
	public String updateDeveloperEmail(int id, String email) {
		Employee employee = employeeDao.findEmployeeById(id);

		employee.setEmail(email);
		employeeDao.updateEmployee(employee);
		return "success.jsp";
	}
	
	@Override
	public String updateDeveloperAddress(int id, AddressDto addressDto) {
		Employee employee = employeeDao.findEmployeeById(id);

		Address address = entityMapper.convertAddressDtoToEntity(addressDto);
		employee.setAddress(address);
		employeeDao.updateEmployee(employee);
		return "success.jsp";

	}

	@Override
	public String changeTaskStatus(int taskId) {
		Task task = taskDao.findTaskById(taskId);
		task.setStatus("completed");
		taskDao.updateTask(task);
		return "success.jsp";
	}
	
	@Override
	public String viewAllTask() {
		int employeeId = (Integer) session.getAttribute("employeeId");
		
		Employee employee = employeeDao.findEmployeeById(employeeId);
		List<Task> tasks = employee.getTasks();
		request.setAttribute("taskList", tasks);
		request.setAttribute("entityMapper", entityMapper);
		
		return "displayTask.jsp";
	}
	
}
