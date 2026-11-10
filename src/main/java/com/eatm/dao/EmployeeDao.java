package com.eatm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;

	public void saveEmployee(Employee employee) {
		entityManager.persist(employee);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void deleteEmployee(Employee employee) {
		entityManager.remove(employee);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public Employee findEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}

	public List<Employee> findAllEmployee() {
		return entityManager.createQuery("SELECT employee FROM Employee employee").getResultList();
	}

	public Employee findEmployeeByEmailAndPassword(String email, String password) {
		Query loginQuery = entityManager
				.createQuery("SELECT employee FROM Employee employee WHERE email=?1 AND password=?2");
		loginQuery.setParameter(1, email);
		loginQuery.setParameter(2, password);
		try {
			return (Employee)loginQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public List<Employee> findAllDeveloper() {
		return entityManager.createQuery("SELECT employee FROM Employee employee WHERE role='developer'").getResultList();
	}
	
	public Employee findEmployeeByEmail(String email) {
		Query findQuery = entityManager
				.createQuery("SELECT employee FROM Employee employee WHERE email=?1");
		findQuery.setParameter(1, email);
		try {
			return (Employee)findQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}
