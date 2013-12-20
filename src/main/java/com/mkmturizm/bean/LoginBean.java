package com.mkmturizm.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author onurerdogan
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String username, password;
    private boolean rememberMe;
    private Subject currentUser;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isRememberMe()
    {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe)
    {
        this.rememberMe = rememberMe;
    }

    public String loginAsUser()
    {
        String returnPage = null;

        try
        {
            returnPage = "/login.xhtml?faces-redirect=true";

            currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token
                    = new UsernamePasswordToken(username, password);

            token.setRememberMe(rememberMe);

            System.out.println(username + " " + password);

            currentUser.login(token);

            System.out.println(currentUser.getPrincipals());

            if (currentUser.hasRole("user"))
            {
                returnPage = "#";
            } else
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Please check out your username and password"));
                System.out.println("What's happening ??");
                //return returnPage;
            }

        } catch (UnknownAccountException uae)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "kullanıcı adınız yanlış"));
            return null;
        } catch (IncorrectCredentialsException ice)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "parolanız yanlış"));
            return null;
        } catch (LockedAccountException lae)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "Bu kullanıcı adı kilitli"));
            return null;
        } catch (AuthenticationException aex)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", aex.toString()));
            return null;
        }

        return returnPage;
    }

    public String loginAsAdmin()
    {
        String returnPage = null;

        try
        {
            returnPage = "/login.xhtml?faces-redirect=true";

            currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token
                    = new UsernamePasswordToken(username, password);

            token.setRememberMe(rememberMe);

            System.out.println(username + " " + password);

            currentUser.login(token);

            System.out.println(currentUser.getPrincipals());

            if (currentUser.hasRole("admin"))
            {
                returnPage = "/admin/index.xhtml?faces-redirect=true";
            } else
            {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Error", "Please check out your username and password"));
                System.out.println("What's happening ??");
                //return returnPage;
            }

        } catch (UnknownAccountException uae)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "kullanıcı adınız yanlış"));
            return null;
        } catch (IncorrectCredentialsException ice)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "parolanız yanlış"));
            return null;
        } catch (LockedAccountException lae)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", "Bu kullanıcı adı kilitli"));
            return null;
        } catch (AuthenticationException aex)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız", aex.toString()));
            return null;
        }

        return returnPage;
    }

    public boolean isLoggedIn()
    {
        if (currentUser == null)
        {
            return false;
        } else
        {
            return currentUser.isAuthenticated();
        }
    }

    
}
