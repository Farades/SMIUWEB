package ru.entel.smiu.web.controllers;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class AppController {
    public final static String FIRMWARE_VERSION = "0.5";
    public final static String HARDWARE_VERSION = "0.3";
    private String objName = "Тестовый объект";

    public String getObjName() {
        return objName;
    }

    public String getStrEngineStatus() {
        String res = "off.jpg";
        res = "on.jpg";
        return res;
    }
}
