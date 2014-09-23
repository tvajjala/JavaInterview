package com.json.cal;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EventDemo {

    public static void main(String[] args) {

        Appointment appointment = new Appointment();

        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setDetails("details " + i);
            event.setStartDate(new Date());

            event.setEndDate(new Date());

            event.setId(String.valueOf(i));

            event.setText("text" + i);

            appointment.getData().add(event);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(appointment));

    }
}
