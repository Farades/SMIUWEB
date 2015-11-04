package ru.entel.smiu.web.controllers;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@ApplicationScoped
public class AppController {
    public final static String FIRMWARE_VERSION = "0.5";
    public final static String HARDWARE_VERSION = "0.3";
    public final static String MOJARRA_VERSION = FacesContext.class.getPackage().getImplementationVersion();
    private String objName = "Тестовый объект";

    private String last = "";

    public String getObjName() {
        return objName;
    }

    public String getStrEngineStatus() {
        String res = "off.jpg";
        res = "on.jpg";
        return res;
    }

    public String getMojarraVersion() {
        return MOJARRA_VERSION;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
        System.out.println(last);
    }
}
