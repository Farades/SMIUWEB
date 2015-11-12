package ru.entel.smiu.web.controllers;

import ru.entel.smiu.datadealer.engine.Alarm;
import ru.entel.smiu.web.db.entity.Device;
import ru.entel.smiu.web.devices.WebDevice;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ManagedBean
@ApplicationScoped
public class DeviceController {
    @ManagedProperty(value = "#{webEngine}")
    private WebEngine webEngine;

    private Map<Device, WebDevice> allDevices = new HashMap<>();
    private Map<String, WebDevice> allDevicesByName = new HashMap<>();

    private WebDevice currentDevice;

    public void setWebEngine(WebEngine webEngine) {
        this.webEngine = webEngine;
    }

    public DeviceController() {

    }

    @PostConstruct
    public void init () {
        this.allDevices = webEngine.getAllDevices();
        for (Map.Entry<Device, WebDevice> entry : allDevices.entrySet()) {
            allDevicesByName.put(entry.getKey().getName(), entry.getValue());
        }
    }

    public Map<Device, Set<Alarm>> getActiveAlarms() {
        return webEngine.getEngine().getAlarmsChecker().getActiveAlarms();
    }

    public String selectDevice() {
        String res = "";

        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        currentDevice = allDevicesByName.get(params.get("device"));

        res = currentDevice.getDevice().getDeviceBlank().getDeviceType();

        return res;
    }

    public WebDevice getCurrentDevice() {
        return currentDevice;
    }

    public String getCurrentDeviceValueByName(String name) {
        String res = "Null";
        if (currentDevice.getChannels().get(name) != null) {
            res = currentDevice.getChannels().get(name).getData().toString();
        }
        return res;
    }

    public void updateDevice() {

    }

    public WebDevice getDeviceByName() {
        return null;
    }

    public Map<Device, WebDevice> getAllDevices() {
        return allDevices;
    }

    public Map<String, WebDevice> getAllDevicesByName() {
        return allDevicesByName;
    }
}
