package ru.entel.smiu.web.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by farades on 02.11.15.
 */

@ManagedBean
@ViewScoped
public class PageController implements Serializable {
    private String page;

    @PostConstruct
    public void init() {
        page = "home"; //  Default include.
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
        System.out.println(this.page);
    }
}
