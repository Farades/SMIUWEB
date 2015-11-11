package ru.entel.smiu.web.controllers;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ru.entel.smiu.web.db.entity.Device;
import ru.entel.smiu.web.db.entity.Tag;
import ru.entel.smiu.web.db.entity.TagBlank;
import ru.entel.smiu.web.db.util.DataHelper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean (name = "logsController")
@ApplicationScoped
public class LogsController{
    private Date logsDate;
    private Device logsDevice;
    private TagBlank logsTag;

    private List<Device> devices;
    private List<TagBlank> tagBlanks;

    private LazyDataModel logsModel;

    public LogsController() {
        logsModel = new LazyDataModel() {
            @Override
            public List load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) {
                this.setRowCount(getDataLogsSize().intValue());
                return getDataLogs(first, pageSize);
            }
        };
    }

    @PostConstruct
    public void init() {
        this.logsDate = new Date();
        this.devices = DataHelper.getInstance().getAllDevices();

        //Необходимо для правильной работы OneSelectMenu
        for (int i = 0; i < devices.size(); i++) {
            Device device = devices.get(i);
            device.setSelectId(i);
        }

        this.logsDevice = devices.get(0);
        initTagBlanks();
        this.logsTag = tagBlanks.get(0);
    }

    public void initTagBlanks() {
        this.tagBlanks = new ArrayList<>();
        this.tagBlanks .addAll(logsDevice.getDeviceBlank().getTagBlanks());
        for (int i = 0; i < tagBlanks.size(); i++) {
            TagBlank tagBlank = tagBlanks.get(i);
            tagBlank.setSelectedId(i);
        }
    }

    public TagBlank getLogsTag() {
        return logsTag;
    }

    public void setLogsTag(TagBlank logsTag) {
        this.logsTag = logsTag;
    }

    public Device getLogsDevice() {
        return logsDevice;
    }

    public void setLogsDevice(Device logsDevice) {
        this.logsDevice = logsDevice;
        initTagBlanks();
        this.logsTag = tagBlanks.get(0);
    }

    public Date getLogsDate() {
        return logsDate;
    }

    public void setLogsDate(Date logsDate) {
        System.out.println("setDataLogs");
        this.logsDate = logsDate;
    }

    public List<TagBlank> getTagBlanks() {
        return tagBlanks;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void deviceSelect() {
        System.out.println("Logs Device: " + logsDevice);
    }

    public void dateSelect(SelectEvent event) {
        System.out.println("onDateSelect");
        System.out.println(this.logsDate);
    }

    public void tagSelect() {
        System.out.println("Tag select: " + logsTag);
    }



    public List<Tag> getDataLogs(int first, int pageSize) {
//        System.out.println("getDataLogs size: " + DataHelper.getInstance().getTagsByDate(this.logsDate, first, pageSize).size());
        return DataHelper.getInstance().getTagsByCriteria(this.logsDevice, this.logsTag, this.logsDate, first, pageSize);
    }

    public Long getDataLogsSize() {
        return DataHelper.getInstance().getLogsSizeByCriteria(this.logsDevice, this.logsTag, this.logsDate);
    }

    public String getDataLogsFileName() {
        SimpleDateFormat sf = new SimpleDateFormat("dd_MM_yyyy");
        String date = sf.format(this.logsDate);
        return "data_logs_" + date;
    }

    public LazyDataModel getLogsModel() {
        return logsModel;
    }

    public void destroyLogs() {
        DataHelper.getInstance().clearTags();
    }
}