package ru.entel.smiu.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by farades on 29.09.15.
 */

@ManagedBean
@SessionScoped
public class User {
    private String userName;
    private boolean admin;

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAdmin() {
        return admin;
    }
}
