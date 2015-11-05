//package ru.entel.smiu.web.model;
//
//
//import org.eclipse.paho.client.mqttv3.*;
//import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
//import ru.entel.smiu.web.controllers.AppController;
//import ru.entel.smiu.web.msg.MqttService;
//
//import javax.faces.bean.ManagedProperty;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//@WebListener
//public class DataDealerModel implements MqttCallback, ServletContextListener {
//    private ScheduledExecutorService scheduler;
//
//    private final static String DD_OUT_TOPIC = "smiu/DD/engine/out";
//    /**
//     * Основной объект для работы с MQTT
//     */
//    private MqttClient client;
//
//    @ManagedProperty(value = "#{appController}")
//    private AppController appController;
//
//    public DataDealerModel() {
//        mqttInit();
//
//    }
//
//    private void mqttInit() {
//        try {
//            MqttConnectOptions connectOptions = new MqttConnectOptions();
//            connectOptions.setCleanSession(true);
//            client = new MqttClient(MqttService.BROKER_URL, "DDModel", new MemoryPersistence());
//
//            client.setCallback(this);
//            client.connect(connectOptions);
//            client.subscribe(DD_OUT_TOPIC, 0);
//        } catch (MqttException e) {
////            logger.error("Ошибка в функции mqttInit(): " + e.getMessage());
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void connectionLost(Throwable throwable) {
//
//    }
//
//    @Override
//    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
//        if (s.equals(DD_OUT_TOPIC)) {
//            appController.setLast(mqttMessage.toString());
//        }
//    }
//
//    @Override
//    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
//
//    }
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        scheduler = Executors.newSingleThreadScheduledExecutor();
//        scheduler.scheduleAtFixedRate(new MqttRequest(), 0, 1, TimeUnit.SECONDS);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        scheduler.shutdownNow();
//    }
//
//    public class MqttRequest implements Runnable {
//
//        @Override
//        public void run() {
////            System.out.println("DataDealerModel Scheduler");
//
//            MqttService.getInstance().send("smiu/DD/engine/data", "modbus_in.slave1_2");
//            MqttService.getInstance().send("smiu/DD/engine/data", "modbus_in.slave1_1");
//        }
//    }
//}
