package com.example;

import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class Teacher implements ActionListener {
    private int numberOne, numberTwo;
    private String operator = "";
    private Random random;                              //用于给出随机数
    private JTextField textOne, textTwo, textResult;
    private JLabel operatorLabel, message;
    private int maxInteger;                             //题目中最大的整数

    Teacher()                 {     random = new Random();   }
    void setMaxInteger(int n) {     maxInteger = n;          }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("getProblem")) {
            numberOne = random.nextInt(maxInteger) + 1;     //1 至 maxInteger 之间的随机数;
            numberTwo = random.nextInt(maxInteger) + 1;
            double d = Math.random();                       // 获取(0,1)之间的随机数
            operator = (d>=0.5) ? "+" : "-";

            textOne.setText("" + numberOne);
            textTwo.setText("" + numberTwo);
            operatorLabel.setText(operator);
            message.setText("请回答");
            textResult.setText(null);

        } else if (str.equals("answer")) {
            String answer = textResult.getText();
            try {
                int result = Integer.parseInt(answer);
                if (operator.equals("+")) {
                    if (result == numberOne + numberTwo) message.setText("你回答正确");
                    else message.setText("你回答错误");
                } else if (operator.equals("-")) {
                    if (result == numberOne - numberTwo) message.setText("你回答正确");
                    else message.setText("你回答错误");
                }
            } catch (NumberFormatException ex) {
                message.setText("请输入数字字符！");
            }
        }
    }

    public void setJTextField(JTextField... t) {         //首次在这里见到这种参数形式的使用
        textOne = t[0];                                  //仅仅是回调。
        textTwo = t[1];
        textResult = t[2];
    }

    public void setJLabel(JLabel... label) {
        operatorLabel = label[0];
        message = label[1];
    }

}