package com.example;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {
    private JTextField inputText;
    private YunSuan mYunSuan= new YunSuan();

    public static void main(String[] args){
        new Frame();
    }

    public Frame(){
        inputText = new JTextField();
        inputText.setFont(new Font("黑体",Font.PLAIN,20));
        getContentPane().add(inputText, BorderLayout.NORTH);
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel panel = new JPanel(new GridLayout(4,5,10,10));
        String[] niuZi = {"1","2","3","+","^","4","5","6","-","%","7","8","9","*","√",".","0","=","/","lg"};
        for(String zi:niuZi){
            JButton button = new JButton(zi);
            button.addActionListener(this);
            panel.add(button);
        }
        getContentPane().add(panel, BorderLayout.CENTER);
        JPanel xia = new JPanel();
        JButton clear = new JButton("clear");
        clear.setSize(500,500);
        clear.addActionListener(this);
        xia.add(clear, CENTER_ALIGNMENT);
        getContentPane().add(xia, BorderLayout.SOUTH);

        setTitle("计算器");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!e.getActionCommand().equals("="))
            inputText.setText(inputText.getText() + e.getActionCommand());
        if(e.getActionCommand().equals("clear"))    inputText.setText("");
        if(e.getActionCommand().equals("="))        inputText.setText(mYunSuan.getResult(inputText.getText()));
        inputText.grabFocus();
    }

}
