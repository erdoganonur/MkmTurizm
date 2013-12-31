/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mkmturizm.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author onurerdogan
 */
@Entity
@Table(name = "content")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c"),
    @NamedQuery(name = "Content.findByContentId", query = "SELECT c FROM Content c WHERE c.contentId = :contentId"),
    @NamedQuery(name = "Content.findByContentDescription", query = "SELECT c FROM Content c WHERE c.contentDescription = :contentDescription"),
    @NamedQuery(name = "Content.findByContentText", query = "SELECT c FROM Content c WHERE c.contentText = :contentText"),
    @NamedQuery(name = "Content.findByContentHtml", query = "SELECT c FROM Content c WHERE c.contentHtml = :contentHtml"),
    @NamedQuery(name = "Content.findByLastModifedDate", query = "SELECT c FROM Content c WHERE c.lastModifedDate = :lastModifedDate")
})
public class Content implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "content_id")
    private Integer contentId;
    @Size(max = 2147483647)
    @Column(name = "content_description")
    private String contentDescription;
    @Size(max = 2147483647)
    @Column(name = "content_text")
    private String contentText;
    @Size(max = 2147483647)
    @Column(name = "content_html")
    private String contentHtml;
    @Column(name = "last_modifed_date")
    @Temporal(TemporalType.TIME)
    private Date lastModifedDate;
    @JoinColumn(name = "modified_user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users modifiedUserId;

    public Content()
    {
    }

    public Content(Integer contentId)
    {
        this.contentId = contentId;
    }

    public Integer getContentId()
    {
        return contentId;
    }

    public void setContentId(Integer contentId)
    {
        this.contentId = contentId;
    }

    public String getContentDescription()
    {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription)
    {
        this.contentDescription = contentDescription;
    }

    public String getContentText()
    {
        return contentText;
    }

    public void setContentText(String contentText)
    {
        this.contentText = contentText;
    }

    public String getContentHtml()
    {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml)
    {
        this.contentHtml = contentHtml;
    }

    public Date getLastModifedDate()
    {
        return lastModifedDate;
    }

    public void setLastModifedDate(Date lastModifedDate)
    {
        this.lastModifedDate = lastModifedDate;
    }

    public Users getModifiedUserId()
    {
        return modifiedUserId;
    }

    public void setModifiedUserId(Users modifiedUserId)
    {
        this.modifiedUserId = modifiedUserId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (contentId != null ? contentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content))
        {
            return false;
        }
        Content other = (Content) object;
        if ((this.contentId == null && other.contentId != null) || (this.contentId != null && !this.contentId.equals(other.contentId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mkmturizm.entity.Content[ contentId=" + contentId + " ]";
    }
    
}
