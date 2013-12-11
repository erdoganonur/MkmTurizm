/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author onurerdogan
 */
public abstract class GenericDAO<E> implements Serializable{

	@PersistenceContext
	EntityManager entityManager;
	
	public void persist(E object){
		entityManager.persist(object);
	}
	
	public void merge(E object){
		entityManager.merge(object);
	}
	
	public void delete(E object){
		object = entityManager.merge(object);
		entityManager.remove(object);
	}
        
        public void flush()
        {
            entityManager.flush();
        }
	
}
