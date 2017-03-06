package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Person extends JButton implements FocusListener {
    int number;
    private Color c = new Color(255, 245, 170);

    Person(int number, String name, String pic) {
        super(name);
        setIcon(new ImageIcon("d:/" + pic + ".jpg"));
        setBackground(c);
        setFont(new Font("宋体", Font.BOLD, 12));
        this.number = number;
        c = getBackground();
        addFocusListener(this);
    }

    public void focusGained(FocusEvent e) {
        setBackground(Color.red);
    }

    public void focusLost(FocusEvent e) {
        setBackground(c);
    }
}