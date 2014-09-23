package com.json.cal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DnkyWork {

    public static void main(String[] args) throws ParseException {

        List<String> bookedStartSlotList = new ArrayList<String>(5);
        bookedStartSlotList.add("10:00");
        bookedStartSlotList.add("10:10");
        bookedStartSlotList.add("10:20");
        bookedStartSlotList.add("10:30");
        bookedStartSlotList.add("10:40");

        int slotTime = 10;
        Date doctorFromtime = getDateObject(new Date(), "10:00", bookedStartSlotList, slotTime);

        System.out.println(doctorFromtime);

    }

    public static Date getDateObject(Date date, String time, List<String> bookedStartSlotList, int slotTime) throws ParseException {

        Date firstTime = getFormattedDate(date, time);// calendar.getTime();

        Date fromTime = null;
        Date toTime = null;
        Calendar calendar = Calendar.getInstance();
        for (String bookedSlot : bookedStartSlotList) {

            toTime = getFormattedDate(date, bookedSlot);

            // Compare if first booking is at the 1st slot
            if (firstTime != null && toTime.after(firstTime)) {
                System.out.println("First slot available");
                return firstTime;
            } else {
                if (firstTime != null) {
                    fromTime = firstTime;
                    firstTime = null;
                }
                if (toTime.compareTo(fromTime) == 0) {
                    calendar.setTime(fromTime);
                    calendar.add(Calendar.MINUTE, slotTime);
                    fromTime = calendar.getTime();
                } else {
                    return fromTime;
                }
            }
        }
        // calendar.setTime(simpleDateFormat.parse(time));

        return calendar.getTime();

    }

    private static Date getFormattedDate(Date date, String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, sdf.parse(time).getHours());
        calendar.set(Calendar.MINUTE, sdf.parse(time).getMinutes());
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
}
