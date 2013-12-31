/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.service;

import com.mkmturizm.dao.ContentDAO;
import com.mkmturizm.entity.Content;
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
public class ContentService {

    @Inject
    ContentDAO contentDAO;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void persist(Content content) throws Exception
    {
        contentDAO.persist(content);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void merge(Content content) throws Exception
    {
        contentDAO.merge(content);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Content content) throws Exception
    {
        contentDAO.delete(content);
    }

    public List<Content> contents()
    {
        return contentDAO.getAllContents();
    }
    
    public Content findContentById(int id)
    {
        return contentDAO.findContentById(id);
    }
}
