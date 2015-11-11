package ru.entel.smiu.web.devices;

import ru.entel.smiu.datadealer.protocols.service.ProtocolSlave;
import ru.entel.smiu.web.db.entity.Device;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WebDevice implements Serializable {
    private Map<String, ProtocolSlave> channels = new HashMap<>();
    private Device device;

    public WebDevice(Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    public void addChannel(ProtocolSlave channel) {
        channels.put(channel.getName(), channel);
    }

    public Map<String, ProtocolSlave> getChannels() {
        return channels;
    }

    public String getName() {
        return device.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebDevice webDevice = (WebDevice) o;

        return !(device != null ? !device.equals(webDevice.device) : webDevice.device != null);

    }

    @Override
    public int hashCode() {
        return device != null ? device.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WebDevice{" +
                "channels=" + channels +
                '}';
    }
}
