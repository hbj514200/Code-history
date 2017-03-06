package com.example;

/**
 * 这个例子比较有价值。可以好好研究下
 */

public class CalendarMainClass {
    public static void main(String args[]) {
        CalendarFrame frame = new CalendarFrame();
        frame.setBounds(100, 100, 360, 300);
        frame.setVisible(true);
        frame.setTitle("小祥日历");
        frame.setYearAndMonth(2015, 5);
    }
}