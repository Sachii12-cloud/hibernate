package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAO3 {
	
	private static EntityManagerFactory enfEntityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		UserDTO userToBeDeleted = entityManager.find(UserDTO.class, 3);
		if(userToBeDeleted != null)
		{
			entityTransaction.begin();
		    entityManager.remove(userToBeDeleted);
		    entityTransaction.commit();
		    System.out.println("user deleted");

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
