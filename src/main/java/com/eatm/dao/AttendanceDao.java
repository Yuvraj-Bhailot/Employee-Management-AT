package com.eatm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Attendance;

@Repository
public class AttendanceDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public void saveAttendance(Attendance attendance) {
		entityManager.persist(attendance);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void updateAttendance(Attendance attendance) {
		entityManager.merge(attendance);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void deleteAttendance(Attendance attendance) {
		entityManager.remove(attendance);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public Attendance findAttendanceById(int attendanceId) {
		return entityManager.find(Attendance.class, attendanceId);
	}

	public List<Attendance> findAllAttendance() {
		return entityManager.createQuery("SELECT attendance FROM Attendance attendance").getResultList();
	}
	
}
