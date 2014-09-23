package com.json;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONDemo {

    public static void main(String[] args) {
        
        
        
        
        
        
        for(int i=1;i<59;i++){
            
            System.out.println(i+" ="+  ((i/10)+1)*10);
            
        }
        
        
        
        
        
        
        
        
        
        /*

        
        
        
        
        
        
        
        
        Appointment appointment = new Appointment();

        EventDate eventDate = new EventDate();
        eventDate.setDate(new Date());
        appointment.setActiveMonth(eventDate);

        appointment.setStartDate(eventDate);
        appointment.setEndDate(eventDate);

        for (int i = 0; i < 2; i++) {
            Event event = new Event();
            event.setContent("Event" + i);
            event.setEndDate(eventDate);
            event.setStartDate(eventDate);
            appointment.getEvents().add(event);
        }

        Gson gson = new GsonBuilder().create();

        System.out.println(gson.toJson(appointment));

    */}
}
