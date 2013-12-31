/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mkmturizm.dao;

import com.mkmturizm.entity.Content;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author onurerdogan
 */
public class ContentDAO extends GenericDAO<Content> implements Serializable{

    public List<Content> getAllContents()
    {
        Query query = entityManager.createNamedQuery("Content.findAll");
        List<Content> content = query.getResultList();
        return content;
    }
    
    public Content findContentById(int id)
    {
        Query query = entityManager.createNamedQuery("Content.findByContentId").setParameter("contentId", id);
        Content content = (Content) query.getSingleResult();
        return content;
    }
}
