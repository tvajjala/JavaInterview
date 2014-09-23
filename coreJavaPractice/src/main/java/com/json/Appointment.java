package com.json;

import java.util.ArrayList;
import java.util.List;

public class Appointment {

    EventDate startDate;
    EventDate endDate;

    EventDate activeMonth;

    List<Event> events = new ArrayList<Event>();

    public EventDate getStartDate() {
        return startDate;
    }

    public void setStartDate(EventDate startDate) {
        this.startDate = startDate;
    }

    public EventDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EventDate endDate) {
        this.endDate = endDate;
    }

    public EventDate getActiveMonth() {
        return activeMonth;
    }

    public void setActiveMonth(EventDate activeMonth) {
        this.activeMonth = activeMonth;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
