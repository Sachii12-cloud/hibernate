package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO2 {
	
	private static EntityManagerFactory emfEntityManagerFactory;
	private static EntityManager entityManager;
	
	
	public static void main(String[] args) {
		
		openConnection();
		UserDTO userDTO = entityManager.find(UserDTO.class, 2);
		if(userDTO != null)
			System.out.println(userDTO);
		
		else
			System.out.println("user not found. Invalid password..!!");
		openConnection();
		
		
	}


	private static void openConnection() {
		
		emfEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = emfEntityManagerFactory.createEntityManager();
		
	}
	
	private static void closeConnection() {
		if(emfEntityManagerFactory != null)
			emfEntityManagerFactory.close();
		if(entityManager != null)
			entityManager.close();
			
	}
	

}
