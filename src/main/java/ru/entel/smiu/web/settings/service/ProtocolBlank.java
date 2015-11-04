package ru.entel.smiu.web.settings.service;

import ru.entel.smiu.web.settings.service.ProtocolType;

import java.io.Serializable;

/**
 * Created by farades on 04.11.15.
 */
public class ProtocolBlank implements Serializable {
    private String name;
    private ProtocolType protocolType;

    private String port;
    private String baudrate;
    private String databits;
    private String stopbits;
    private String parity;
    private String timePause;

    public ProtocolBlank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
