/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author onurerdogan
 */
@Entity
@Table(name = "groups")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByGroupId", query = "SELECT g FROM Groups g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "Groups.findByGroupName", query = "SELECT g FROM Groups g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "Groups.findByGroupDescription", query = "SELECT g FROM Groups g WHERE g.groupDescription = :groupDescription")
})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Size(max = 2147483647)
    @Column(name = "group_name")
    private String groupName;
    @Size(max = 2147483647)
    @Column(name = "group_description")
    private String groupDescription;
    @JoinTable(name = "user_group", joinColumns =
    {
        @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    })
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Users> usersList;

    public Groups()
    {
    }

    public Groups(Integer groupId)
    {
        this.groupId = groupId;
    }

    public Integer getGroupId()
    {
        return groupId;
    }

    public void setGroupId(Integer groupId)
    {
        this.groupId = groupId;
    }

    public String getGroupName()
    {
        return groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getGroupDescription()
    {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription)
    {
        this.groupDescription = groupDescription;
    }

    @XmlTransient
    public List<Users> getUsersList()
    {
        return usersList;
    }

    public void setUsersList(List<Users> usersList)
    {
        this.usersList = usersList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups))
        {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.mkmturizm.entity.Groups[ groupId=" + groupId + " ]";
    }
    
}
