package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO4 {
	private static EntityManagerFactory enfEntityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		UserDTO userToBeUpdated = entityManager.find(UserDTO.class, 2);
		if(userToBeUpdated != null)
		{
			userToBeUpdated.setPassword("Sachin@4321");
			entityTransaction.begin();
		    entityManager.persist(userToBeUpdated);
		    entityTransaction.commit();
		    System.out.println("user Updated");

		}else {
			System.out.println("user not found . Invalid password..!!");
		}
		
		closeConnection();
					
		
	}


	private static void openConnection() {
		
		enfEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = enfEntityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		
	
		
	}
	

	private static void closeConnection() {
		
		if(enfEntityManagerFactory != null)
			enfEntityManagerFactory.close();
	    if(entityManager != null)
	    	entityManager.close();
	    if(entityTransaction != null)
	    {
	    	if(entityTransaction.isActive())
	    		entityTransaction.rollback();
	    }
	    	
	    	
	
		
	}


}
