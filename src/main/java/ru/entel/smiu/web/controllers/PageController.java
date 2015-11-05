package ru.entel.smiu.web.controllers;

import ru.entel.smiu.web.db.entity.DeviceBlank;
import ru.entel.smiu.web.db.util.DataHelper;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import java.io.Serializable;
import java.util.List;

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

//            System.out.println(Factory.getInstance().getStudentDAO().getAllStudents());
            List<DeviceBlank> deviceBlanks = DataHelper.getInstance().getAllDeviceBlanks();
            System.out.println(deviceBlanks);
//            System.out.println(deviceBlanks.get(0).getTagList());

        System.out.println("TEEEEEEEST");
    }
}
