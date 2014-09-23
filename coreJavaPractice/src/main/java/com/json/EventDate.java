package com.json;

import java.util.Calendar;
import java.util.Date;

public class EventDate {

    private int Y;
    private int M;
    private int D;
    private int H;

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    transient Date date;

    public void setDate(Date date) {
        this.date = date;

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR); // 2012
        int month = calendar.get(Calendar.MONTH); // 9 - October!!!
        int day = calendar.get(Calendar.DAY_OF_MONTH); // 5

        int hour = calendar.get(Calendar.HOUR_OF_DAY); // 15
        // int minute = calendar.get(Calendar.MINUTE); // 16
        // int second = calendar.get(Calendar.SECOND); //

        setY(year);
        setM(month);
        setD(day);

        setH(hour);

    }

}
