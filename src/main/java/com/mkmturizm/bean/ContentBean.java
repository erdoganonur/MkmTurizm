/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mkmturizm.bean;

import com.mkmturizm.entity.Content;
import com.mkmturizm.service.ContentService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author onurerdogan
 */
@Named
@SessionScoped
public class ContentBean implements Serializable{
    
    
    @Inject ContentService contentService;
    
    private Content content = new Content();

    public String findContentById(int id)
    {
        content = contentService.findContentById(id);
        
        return content.getContentHtml();
    }
    public Content getContent()
    {
        return content;
    }

    public void setContent(Content content)
    {
        this.content = content;
    }
    
    
}
