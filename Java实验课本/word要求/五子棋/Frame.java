package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Frame extends JFrame implements ActionListener {
    private JRadioButton iFristButton;
    private JButton againButton, startButton;
    private ChessBoard mChessBoard = new ChessBoard();
    public static JLabel jiBuLable;
    public static int bushu;       //现在第几步了

    public Frame(){
        setTitle("五子棋_V1.0");
        setSize(800,640);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buju();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    private void buju(){
        setLayout(new BorderLayout());
        add(mChessBoard, BorderLayout.CENTER);

        GridLayout layout = new GridLayout(10,1);   layout.setVgap(10); layout.setHgap(70);
        JPanel you = new JPanel(layout);
        iFristButton = new JRadioButton("我是老大我先来", true);
        JRadioButton youFristButton = new JRadioButton("让让电脑也无妨");
        startButton = new JButton("人机对战，快冲啊");                 startButton.addActionListener(this);
        againButton = new JButton("不行了，那重来吧");                 againButton.addActionListener(this);
        jiBuLable = new JLabel("就不告诉你这是第几步", JLabel.CENTER);
        ButtonGroup group = new ButtonGroup();  group.add(iFristButton);    group.add(youFristButton);
        againButton.setEnabled(false);
        you.add(iFristButton);
        you.add(youFristButton);
        you.add(startButton);
        you.add(againButton);
        you.add(jiBuLable);
        add(you, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){
            case "人机对战，快冲啊" :
                if(!iFristButton.isSelected()){
                    ChessBoard.userColor = ChessBoard.BAI;
                    ChessBoard.control.work();
                }
                mChessBoard.working = true;
                againButton.setEnabled(true);
                startButton.setEnabled(false);
                break;
            case "不行了，那重来吧" :
                againButton.setEnabled(false);
                startButton.setEnabled(true);
                dispose();
                Main.main(null);
                break;
        }
    }

}