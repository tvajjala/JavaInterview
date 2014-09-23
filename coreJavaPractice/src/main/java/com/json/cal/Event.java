package com.json.cal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    String id;
    String start_date;
    String end_date;
    String text;
    String details;

    transient Date startDate;
    transient Date endDate;

    transient SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        start_date = sdf.format(startDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        end_date = sdf.format(endDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
