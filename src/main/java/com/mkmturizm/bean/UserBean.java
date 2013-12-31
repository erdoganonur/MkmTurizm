/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkmturizm.bean;

import com.mkmturizm.entity.Groups;
import com.mkmturizm.entity.Person;
import com.mkmturizm.entity.Users;
import com.mkmturizm.service.GroupService;
import com.mkmturizm.service.UserService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author onurerdogan
 */
@Named
@RequestScoped
public class UserBean implements Serializable {

    private Users user = new Users();
    private Person person = new Person();
    private List<Person> personList = new ArrayList<Person>();
    private List<Groups> groupList = new ArrayList<Groups>();
    private List<Users> userList = new ArrayList<Users>();

    
    @Inject
    UserService userService;
    @Inject
    GroupService groupService;

    public void persist() throws Exception
    {
        personList.add(person);
        user.setPersonList(personList);
        userService.persist(user);
        user = new Users();
        person = new Person();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Kayıt başarıyla gerçeklerşti", ""));
    }

    @PostConstruct
    public void init()
    {
        this.getAllGroups();
        this.getAllUsers();
    }
    
    public void getAllGroups()
    {
        groupList = groupService.groupsList();
    }
    
    public void getAllUsers()
    {
        userList = userService.users();
    }

    public List<Groups> getGroupList()
    {
        return groupList;
    }

    public void setGroupList(List<Groups> groupList)
    {
        this.groupList = groupList;
    }

    public Users getUser()
    {
        return user;
    }

    public void setUser(Users user)
    {
        this.user = user;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
    
    public List<Person> getPersonList()
    {
        return personList;
    }

    public void setPersonList(List<Person> personList)
    {
        this.personList = personList;
    }

    public List<Users> getUserList()
    {
        return userList;
    }

    public void setUserList(List<Users> userList)
    {
        this.userList = userList;
    }

    public UserService getUserService()
    {
        return userService;
    }

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    public GroupService getGroupService()
    {
        return groupService;
    }

    public void setGroupService(GroupService groupService)
    {
        this.groupService = groupService;
    }
}
