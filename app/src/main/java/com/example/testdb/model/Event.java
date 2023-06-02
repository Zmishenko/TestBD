package com.example.testdb.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Event {

    private Long id;
    private String type;
    private String reason;
    private String dateFrom;
    private String dateTo;
    private String grpupsNum;
    private String predmet;

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getGrpupsNum() {
        return grpupsNum;
    }

    public void setGrpupsNum(String grpupsNum) {
        this.grpupsNum = grpupsNum;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", grpupsNum='" + grpupsNum + '\'' +
                ", predmet='" + predmet + '\'' +
                '}';
    }
}
