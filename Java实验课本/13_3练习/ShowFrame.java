package com.example;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import javax.swing.*;

import java.text.SimpleDateFormat;

public class ShowFrame extends JFrame implements ActionListener {
    private JTextArea showArea;
    private JTextField inputName, inputTime;
    private TreeSet<Program> treeSet;

    ShowFrame() {
        treeSet = new TreeSet<Program>();
        showArea = new JTextArea();
        showArea.setFont(new Font("", Font.BOLD, 20));
        inputName = new JTextField(5);
        inputTime = new JTextField(10);
        JButton button = new JButton("确定");
        JButton saveButton = new JButton("保存");
        button.addActionListener(this);
        saveButton.addActionListener(this);
        JPanel pNorth = new JPanel();
        pNorth.add(new JLabel("节目名称:"));
        pNorth.add(inputName);
        pNorth.add(new JLabel("时间(yyyy/mm/dd/hh:mm:ss)"));
        pNorth.add(inputTime);
        pNorth.add(button);
        add(saveButton, BorderLayout.SOUTH);
        add(pNorth, BorderLayout.NORTH);
        add(new JScrollPane(showArea), BorderLayout.CENTER);
        setSize(500, 320);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("确定")){
            String name = inputName.getText();
            String time = inputTime.getText();
            StringTokenizer jiexi = new StringTokenizer(time, "/:");
            int year = Integer.parseInt(jiexi.nextToken());
            int month = Integer.parseInt(jiexi.nextToken());
            int day = Integer.parseInt(jiexi.nextToken());
            int hour = Integer.parseInt(jiexi.nextToken());
            int minute = Integer.parseInt(jiexi.nextToken());
            int second = Integer.parseInt(jiexi.nextToken());
            Program program = new Program(name, year, month, day, hour, minute, second);
            treeSet.add(program);
            show(treeSet);
        } else {
            String message = showArea.getText();
            File file = new File("d:/newfile.txt");
            try {
                FileOutputStream fop = new FileOutputStream(file);
                if (!file.exists())     file.createNewFile();
                byte[] messageInBytes = message.getBytes();
                fop.write(messageInBytes);
                fop.flush();
                fop.close();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    public void show(TreeSet tree) {
        showArea.setText(null);
        for (Program pro : treeSet) {
            Date date = pro.getDate();
            SimpleDateFormat matter1 = new SimpleDateFormat(" yyyy/MM/dd/HH:mm:ss");
            String time = matter1.format(date);
            showArea.append(pro.getName() + "(演出时间):" + time + "\n");
        }
    }
}