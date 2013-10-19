/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.service;

import com.mkmturizm.dao.UserDAO;
import com.mkmturizm.entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author onurerdogan
 */
@Dependent
@Stateful
public class UserService implements Serializable{
   
    @Inject UserDAO userDAO;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persist(Users user) throws Exception {
      System.out.println(user.getGroupsList().get(0).getGroupName());
      userDAO.persist(user);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void merge(Users user) throws Exception {
      userDAO.merge(user);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Users user) throws Exception {
      userDAO.delete(user);
    }
    
    public List<Users> users(){
        return userDAO.getAllUsers();
    }
}
