package ru.entel.smiu.web.db.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "device_blank", schema = "", catalog = "smiu")
public class DeviceBlank {
    private int id;
    private String deviceType;
    private String protocolType;
    private Set<TagBlank> tagBlanks = new HashSet<>(0);
    private Set<Device> devices = new HashSet<>(0);

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "device_type")
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Basic
    @Column(name = "protocol_type")
    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "deviceBlank")
    public Set<TagBlank> getTagBlanks() {
        return tagBlanks;
    }

    public void setTagBlanks(Set<TagBlank> tagBlanks) {
        this.tagBlanks = tagBlanks;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "deviceBlank")
    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceBlank that = (DeviceBlank) o;

        if (id != that.id) return false;
        if (deviceType != null ? !deviceType.equals(that.deviceType) : that.deviceType != null) return false;
        if (protocolType != null ? !protocolType.equals(that.protocolType) : that.protocolType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + (protocolType != null ? protocolType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceBlank{" +
                "id=" + id +
                ", deviceType='" + deviceType + '\'' +
                ", protocolType='" + protocolType + '\'' +
                '}';
    }
}
