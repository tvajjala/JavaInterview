package com.json.cal;

import java.util.ArrayList;
import java.util.List;

public class Appointment {

    List<Event> data = new ArrayList<Event>();

    public List<Event> getData() {
        return data;
    }

    public void setData(List<Event> data) {
        this.data = data;
    }

}
