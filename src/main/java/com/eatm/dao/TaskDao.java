package com.eatm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Task;

@Repository
public class TaskDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public void saveTask(Task task) {
		entityManager.persist(task);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void updateTask(Task task) {
		entityManager.merge(task);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void deleteTask(Task task) {
		entityManager.remove(task);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public Task findTaskById(int taskId) {
		return entityManager.find(Task.class, taskId);
	}

	public List<Task> findAllTask() {
		return entityManager.createQuery("SELECT task FROM Task task").getResultList();
	}
	
}
