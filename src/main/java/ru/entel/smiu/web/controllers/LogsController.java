package ru.entel.smiu.web.controllers;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import ru.entel.smiu.web.db.entity.Device;
import ru.entel.smiu.web.db.entity.Tag;
import ru.entel.smiu.web.db.util.DataHelper;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.swing.event.ChangeEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean
@ApplicationScoped
public class LogsController {
    private Date logsDate;
    private Device logsDevice;
    private List<Device> devices;
    private LazyDataModel logsModel;

    public LogsController() {
        logsModel = new LazyDataModel() {
            @Override
            public List load(int first, int pageSize, String sortField, SortOrder sortOrder, Map filters) {
                this.setRowCount(getDataLogsSizeByDate().intValue());
                return getDataLogs(first, pageSize);
            }
        };
    }

    @PostConstruct
    public void init() {
        this.logsDate = new Date();
        this.devices = DataHelper.getInstance().getAllDevices();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public Device getLogsDevice() {
        return logsDevice;
    }



    public void setLogsDevice(Device logsDevice) {
        this.logsDevice = logsDevice;
    }

    public Date getLogsDate() {
        return logsDate;
    }

    public void deviceSelect() {
        System.out.println("Logs Device: " + logsDevice);
    }

    public void dateSelect(SelectEvent event) {
        System.out.println("onDateSelect");
        System.out.println(this.logsDate);
    }

    public void setLogsDate(Date logsDate) {
        System.out.println("setDataLogs");
        this.logsDate = logsDate;
    }

    public List<Tag> getDataLogs(int first, int pageSize) {
        System.out.println("getDataLogs size: " + DataHelper.getInstance().getTagsByDate(this.logsDate, first, pageSize).size());
        return DataHelper.getInstance().getTagsByDate(this.logsDate, first, pageSize);
    }

    public Long getDataLogsSizeByDate() {
        return DataHelper.getInstance().getLogsSizeByDate(logsDate);
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

    }
}