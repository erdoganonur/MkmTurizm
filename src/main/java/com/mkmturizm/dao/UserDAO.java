/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.dao;

import com.mkmturizm.entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author onurerdogan
 */
public class UserDAO extends GenericDAO<Users> implements Serializable {

    public List<Users> getAllUsers()
    {
        Query query = entityManager.createNamedQuery("Users.findAll");
        List<Users> users = query.getResultList();
        return users;
    }
}
