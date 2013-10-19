/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.service;

import com.mkmturizm.dao.GroupsDAO;
import com.mkmturizm.entity.Groups;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author onurerdogan
 */
@Dependent
@Stateless
public class GroupService implements Serializable {

    @Inject
    GroupsDAO groupsDAO;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persist(Groups group) throws Exception
    {
        groupsDAO.persist(group);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void merge(Groups group) throws Exception
    {
        groupsDAO.merge(group);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Groups group) throws Exception
    {
        groupsDAO.delete(group);
    }

    public List<Groups> groupsList()
    {
        return groupsDAO.getAllGroups();
    }

    public Groups findGroupById(int id)
    {
        return groupsDAO.findGroupById(id);
    }
}
