package com.example;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarFrame extends JFrame implements ActionListener {
    private JLabel labelDay[] = new JLabel[42];
    private JButton nextMonth, previousMonth;
    private CalendarBean calendar;
    private JLabel showMessage = new JLabel("", JLabel.CENTER);
    private int year = 2011, month = 2;
    private JTextField inputText;

    public CalendarFrame() {
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(7,7));
        String[] name = {"日", "一", "二", "三", "四", "五", "六"};
        for (int i = 0; i < 7; i++) {
            JButton[] titleName = new JButton[7];
            titleName[i] = new JButton(name[i]);
            titleName[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            pCenter.add(titleName[i]);
        }
        for (int i = 0; i < 42; i++) {
            labelDay[i] = new JLabel("", JLabel.CENTER);
            labelDay[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            pCenter.add(labelDay[i]);
        }
        calendar = new CalendarBean();
        previousMonth = new JButton("上月");
        nextMonth = new JButton("下月");
        previousMonth.addActionListener(this);
        nextMonth.addActionListener(this);
        JPanel pNorth = new JPanel(), pSouth = new JPanel(new FlowLayout());
        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        pSouth.add(showMessage);

        inputText = new JTextField(4);
        JButton changeYear = new JButton("修改年份");
        changeYear.addActionListener(this);
        pSouth.add(inputText);
        pSouth.add(changeYear);

        add(pCenter, BorderLayout.CENTER);
        add(pNorth, BorderLayout.NORTH);
        add(pSouth, BorderLayout.SOUTH);
        setYearAndMonth(year, month);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setYearAndMonth(int y, int m) {
        calendar.setYear(y);
        calendar.setMonth(m);
        String day[] = calendar.getCalendar();
        for (int i = 0; i < 42; i++) labelDay[i].setText(day[i]);
        showMessage.setText("日历：" + calendar.getYear() + "年" + calendar.getMonth() + "月");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextMonth) {
            month = month + 1;
            if (month > 12) month = 1;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) {
                labelDay[i].setText(day[i]);
            }
        } else if (e.getSource() == previousMonth) {
            month = month - 1;
            if (month < 1) month = 12;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) labelDay[i].setText(day[i]);
        } else if (e.getActionCommand().equals("修改年份")){
            calendar.setYear(Integer.valueOf(inputText.getText()));
            String day[] = calendar.getCalendar();
            for (int i = 0; i < 42; i++) labelDay[i].setText(day[i]);
        }
        showMessage.setText("日历：" + calendar.getYear() + "年" + calendar.getMonth() + "月");
    }
}