package com.foodlogger.model;

import java.util.Calendar;
import java.util.Date;

public class UserCalendar
{
  public String months;
  public Date date;

  //gets the current date
  public void getCalendar(){
    Calendar calendar = Calendar.getInstance();
    Date now = calendar.getTime();
    System.out.println(now.toString());
  }

  public String getDay(Date date){
    String day = date.toString().substring(0,4);
    System.out.println(day);
    return day;
  }
}
