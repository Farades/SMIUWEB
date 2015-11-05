package ru.entel.smiu.web.db.entity;

import javax.persistence.*;

/**
 * Created by farades on 05.11.15.
 */
@Entity
@Table(name = "device", schema = "", catalog = "smiu")
public class Device {
    private int id;
    private String deviceSettings;
    private Protocol protocol;
    private DeviceBlank deviceBlank;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_settings")
    public String getDeviceSettings() {
        return deviceSettings;
    }

    public void setDeviceSettings(String deviceSettings) {
        this.deviceSettings = deviceSettings;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "protocol_id")
    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_blank_id")
    public DeviceBlank getDeviceBlank() {
        return deviceBlank;
    }

    public void setDeviceBlank(DeviceBlank deviceBlank) {
        this.deviceBlank = deviceBlank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (id != device.id) return false;
        if (deviceSettings != null ? !deviceSettings.equals(device.deviceSettings) : device.deviceSettings != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deviceSettings != null ? deviceSettings.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", deviceSettings='" + deviceSettings + '\'' +
                ", protocol=" + protocol +
                '}';
    }
}
