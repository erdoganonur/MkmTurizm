/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.bean;

import com.mkmturizm.entity.Content;
import com.mkmturizm.service.ContentService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author onurerdogan
 */
@Named
@SessionScoped
public class ContentAdminBean implements Serializable {

    @Inject
    ContentService contentService;

    private Content content = new Content();
    private Integer contentId;

    @PostConstruct
    private void init()
    {
        if (contentId == null)
        {
            this.findContentById(1);
        }
    }

    public String findContentById(int id)
    {
        content = contentService.findContentById(id);

        return content.getContentHtml();
    }

    public void updateContent()
    {
        try
        {
            contentService.merge(content);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt başarıyla gerçeklerşti", ""));

        } catch (Exception ex)
        {
            Logger.getLogger(ContentAdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Content getContent()
    {
        return content;
    }

    public void setContent(Content content)
    {
        this.content = content;
    }

    public Integer getContentId()
    {
        return contentId;
    }

    public void setContentId(Integer contentId)
    {
        this.contentId = contentId;
    }

}
