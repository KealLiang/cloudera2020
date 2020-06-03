package com.kealliang.laboratory.test;

import java.util.Date;
import java.util.TimeZone;

public class TimeTest {

    public static void main(String args[]) {
	long time = System.currentTimeMillis();
	String millis = Long.toString(time);
	Date date = new Date(time);
	System.out.println("Current time in milliseconds = " + millis + " => " + date.toString());
	System.out.println("Current time zone: " + TimeZone.getDefault().getID());
    }
}