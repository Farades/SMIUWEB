package ru.entel.smiu.web.controllers;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import ru.entel.smiu.web.model.DataDealerModel;
import ru.entel.smiu.web.msg.MqttService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by farades on 29.09.15.
 */


public class LoginController implements MqttCallback {
    private String test;

    /**
     * Основной объект для работы с MQTT
     */
    private MqttClient client;

    public LoginController() {
        mqttInit();
    }

    public String getTest() {
        return test;
    }

    public String login() {
        MqttService.getInstance().send("smiu/DD/engine/data", "modbus_in.slave1_2");
        System.out.println("smiu/DD/engine/data");
        return "TWDA";
    }

    private void mqttInit() {
        try {
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            client = new MqttClient(MqttService.BROKER_URL, "SmiuClient", new MemoryPersistence());

            client.setCallback(this);
            client.connect(connectOptions);
            client.subscribe("smiu/DD/engine/out", 0);
            System.out.println("mqttInit");
        } catch (MqttException e) {
//            logger.error("Ошибка в функции mqttInit(): " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("connectionLost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(s + " - " + mqttMessage.toString());
        this.test = mqttMessage.toString();
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete");
    }
}
