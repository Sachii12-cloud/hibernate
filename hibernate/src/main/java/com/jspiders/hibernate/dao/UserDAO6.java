package com.jspiders.hibernate.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO6 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static  void main(String[] args) {
		openConnection();
		Query query = entityManager.createQuery("SELECT user FROM UserDTO user WHERE user.email = ?1 AND user.password = ?2");
		query.setParameter(1, "Sachin@gmail.com");
		query.setParameter(2, "Sachin@4321");
		try {
			@SuppressWarnings("unchecked")
			UserDTO user = (UserDTO) query.getSingleResult();
			System.out.println(user);
		}catch(NoResultException e){
			System.out.println("Invalid email and password ");
			
		}
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
	}

}
