package ru.entel.smiu.web.settings;

import com.google.gson.Gson;
import ru.entel.smiu.web.db.entity.Device;
import ru.entel.smiu.web.db.entity.Protocol;
import ru.entel.smiu.web.db.util.DataHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Configurator {
    private Map<String, Protocol> protocolMap = new HashMap<>();
    private Gson gson = new Gson();

    public Configurator() {

    }

    public void configure() {
        for (Protocol protocol : DataHelper.getInstance().getAllProtocols()) {
            protocolMap.put(protocol.getName(), protocol);
        }
    }

    public void configureProtocol() {
        for (Map.Entry<String, Protocol> entry : protocolMap.entrySet()) {
        }
    }

}
