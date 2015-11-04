package ru.entel.smiu.web.entity;

import javax.persistence.*;

/**
 * Created by farades on 04.11.15.
 */
@Entity
@Table(name = "DeviceBlank", schema = "", catalog = "smiu")
public class DeviceBlankEntity {
    private long id;
    private String protocolType;
    private String deviceType;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "protocolType")
    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    @Basic
    @Column(name = "deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceBlankEntity that = (DeviceBlankEntity) o;

        if (id != that.id) return false;
        if (protocolType != null ? !protocolType.equals(that.protocolType) : that.protocolType != null) return false;
        return !(deviceType != null ? !deviceType.equals(that.deviceType) : that.deviceType != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (protocolType != null ? protocolType.hashCode() : 0);
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceBlankEntity{" +
                "deviceType='" + deviceType + '\'' +
                ", protocolType='" + protocolType + '\'' +
                ", id=" + id +
                '}';
    }
}
