/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.dao;

import com.mkmturizm.entity.Groups;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author onurerdogan
 */
public class GroupsDAO extends GenericDAO<Groups> implements Serializable{
    
    public List<Groups> getAllGroups()
    {
        Query query = entityManager.createNamedQuery("Groups.findAll");
        List<Groups> allGroups = query.getResultList();
        return allGroups;
    }
    
    public Groups findGroupById(int id)
    {
        Query query = entityManager.createNamedQuery("Groups.findByGroupId").setParameter("groupId", id);
        Groups group = (Groups) query.getSingleResult();
        return group;
        
    }
}
