package ru.entel.smiu.web.entity;

public class Factory {

    private static DeviceBlankDAO deviceBlankDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public DeviceBlankDAO getStudentDAO(){
        if (deviceBlankDAO == null){
            deviceBlankDAO = new DeviceBlankDAO();
        }
        return deviceBlankDAO;
    }
}