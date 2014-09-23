package com.json;

public class Event {

    private String content;
    private EventDate startDate;
    private EventDate endDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

}
