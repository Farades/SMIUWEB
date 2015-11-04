package ru.entel.smiu.web.settings.service;

import ru.entel.smiu.web.settings.service.DeviceType;
import ru.entel.smiu.web.settings.service.ProtocolType;

import java.io.Serializable;

/**
 * Created by farades on 04.11.15.
 */
public abstract class DeviceBlank implements Serializable {
    protected String name;
    protected DeviceType deviceType;
    protected ProtocolType protocolType;

    public DeviceBlank(String name) {
        this.name = name;
    }

    public abstract String toJson();

    public String getName() {
        return name;
    }
}
