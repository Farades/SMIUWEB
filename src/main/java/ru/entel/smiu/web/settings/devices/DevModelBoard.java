package ru.entel.smiu.web.settings.devices;

import ru.entel.smiu.web.settings.service.DeviceBlank;
import ru.entel.smiu.web.settings.service.DeviceType;
import ru.entel.smiu.web.settings.service.ProtocolType;

/**
 * Created by farades on 04.11.15.
 */
public class DevModelBoard extends DeviceBlank {

    public DevModelBoard(String name) {
        super(name);
        this.deviceType = DeviceType.ENTEL_MODELING_BOARD;
        this.protocolType = ProtocolType.MODBUS_MASTER;
    }

    @Override
    public String toJson() {
        return null;
    }
}
