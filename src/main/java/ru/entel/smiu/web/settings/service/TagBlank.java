package ru.entel.smiu.web.settings.service;

/**
 * Created by farades on 04.11.15.
 */
public class TagBlank {
    private String nameId;
    private String name;
    private String id;
    private DeviceBlank deviceBlankOwner;

    public TagBlank(String nameId, String name, String id, DeviceBlank deviceBlankOwner) {
        this.nameId = nameId;
        this.name = name;
        this.id = id;
        this.deviceBlankOwner = deviceBlankOwner;
    }
}
