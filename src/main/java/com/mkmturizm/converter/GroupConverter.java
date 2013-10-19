/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.converter;

import com.mkmturizm.entity.Groups;
import com.mkmturizm.service.GroupService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author onurerdogan
 */
@ManagedBean
public class GroupConverter implements Converter {

    @EJB
    GroupService groupService;
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        return groupService.findGroupById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return ((Groups) value).getGroupId().toString();
    }

    
}
