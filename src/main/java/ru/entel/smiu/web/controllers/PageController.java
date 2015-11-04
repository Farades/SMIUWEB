package ru.entel.smiu.web.controllers;

import ru.entel.smiu.web.entity.DeviceBlankDAO;
import ru.entel.smiu.web.entity.Factory;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.view.*;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by farades on 02.11.15.
 */

@ManagedBean
@javax.faces.view.ViewScoped
public class PageController implements Serializable {
    private String page;


    @PostConstruct
    public void init() {
        page = "home";
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
        System.out.println(this.page);
    }

    public void test() {

        try {
            System.out.println(Factory.getInstance().getStudentDAO().getAllStudents());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("TEEEEEEEST");
    }
}
