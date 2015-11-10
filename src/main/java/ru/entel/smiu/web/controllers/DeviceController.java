package ru.entel.smiu.web.controllers;

import ru.entel.smiu.datadealer.protocols.service.ProtocolMaster;
import ru.entel.smiu.datadealer.protocols.service.ProtocolSlave;
import ru.entel.smiu.web.db.entity.Device;
import ru.entel.smiu.web.devices.WebDevice;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
@ApplicationScoped
public class DeviceController {
//    @ManagedProperty(value = "#{webEngine}")
//    private WebEngine webEngine;
//
//    private Map<Device, WebDevice> allDevices = new HashMap<>();
//
//    public void setWebEngine(WebEngine webEngine) {
//        this.webEngine = webEngine;
//    }
//
//    private String test = "dwadwa";
//
//    public String getTest() {
//        return test;
//    }
//
//    private Map<String, ProtocolMaster> protocolMasterMap;
//
//    public WebEngine getWebEngine() {
//        return webEngine;
//    }
//
//    public DeviceController() {
//
//    }
//
//    @PostConstruct
//    public void init () {
//
//    }
//
//    public Map<Device, WebDevice> getAllDevices() {
//        return allDevices;
//    }
//
//    public Map<String, ProtocolMaster> getProtocolMasterMap() {
//        return protocolMasterMap;
//    }
}
