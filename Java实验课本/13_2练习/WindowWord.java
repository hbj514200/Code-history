package com.example;

import java.awt.*;
import javax.swing.*;

public class WindowWord extends JFrame {

    WindowWord() {
        setLayout(new FlowLayout());
        JTextField inputText = new JTextField(6);
        JTextField showText = new JTextField(6);
        add(inputText);
        add(showText);

        WordPolice police = new WordPolice();
        police.setJTextField(showText);
        inputText.addActionListener(police);
        setBounds(100, 100, 300, 180);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
