package com.example;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Earth extends JLabel implements ActionListener {
    private JLabel moon, moon2;
    private double pointX[] = new double[360], pointY[] = new double[360];
    private int i = 0, i2 = 180;

    Earth() {
        setLayout(new FlowLayout());
        int w = 200, h = 200;
        setPreferredSize(new Dimension(w, h));
        Timer timer = new Timer(16, this);
        setIcon(new ImageIcon("d:/earth.jpg"));
        setHorizontalAlignment(SwingConstants.CENTER);
        moon = new JLabel(new ImageIcon("d:/moon.png"), SwingConstants.CENTER);
        moon2 = new JLabel(new ImageIcon("d:/moon.png"), SwingConstants.CENTER);
        add(moon);
        add(moon2);
        moon.setPreferredSize(new Dimension(60, 60));
        moon2.setPreferredSize(new Dimension(60, 60));
        pointX[0] = 0;
        pointY[0] = h / 2;
        double angle = 1 * Math.PI / 180;   //刻度为 1 度
        for (int i = 0; i < 359; i++) {      //计算出数组中各个元素的值
            pointX[i + 1] = pointX[i] * Math.cos(angle) - Math.sin(angle) * pointY[i];
            pointY[i + 1] = pointY[i] * Math.cos(angle) + pointX[i] * Math.sin(angle);
        }
        for (int i = 0; i < 360; i++) {
            pointX[i] = 0.8 * pointX[i] + w / 2;    //坐标缩放、平移
            pointY[i] = 0.8 * pointY[i] + h / 2;
        }
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        i = (i + 1) % 360;
        i2 = (i2 + 1) % 360;
        moon.setLocation((int) pointX[i] - 30, (int) pointY[i] - 30);
        moon2.setLocation((int) pointX[i2] - 30, (int) pointY[i2] - 30);
    }
}
