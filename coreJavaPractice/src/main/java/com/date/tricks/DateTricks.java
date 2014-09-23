package com.date.tricks;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTricks {

    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

        Date date1 = sdf.parse("08/18/2014 8:30 AM");
        Date date2 = sdf.parse("09/18/2014 10:30 AM");
        
        SimpleDateFormat  sdf2 = new SimpleDateFormat("hh:mm a; dd MMM yyyy");
        sdf2.format(date1);
        sdf2.format(date2);
        
        
        System.out.println("=====  > "+ sdf2.format(date1));
        System.out.println("=====  > "+ sdf2.format(date2));
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date2.after(date1));

    }
}
