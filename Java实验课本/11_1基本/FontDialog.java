package com.example;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FontDialog extends JDialog implements ItemListener, ActionListener {
    private int fontSize = 38;
    private String fontName;
    private JComboBox fontNameList, fontSizeList;
    private JLabel label;
    private Font font;
    private JButton yes, cancel;
    static int YES = 1, NO = 0;
    private int state = -1;

    FontDialog(JFrame f) {
        super(f);
        setTitle("字体对话框");
        font = new Font("宋体", Font.PLAIN, 12);
        FontFamilyNames fontFamilyNames = new FontFamilyNames();
        setModal(true);                 //当前对话框调用设置为有模式,阻塞后面
        yes = new JButton("Yes");
        cancel = new JButton("cancel");
        yes.addActionListener(this);
        cancel.addActionListener(this);
        label = new JLabel("hello,奥运", JLabel.CENTER);
        fontNameList = new JComboBox();
        fontSizeList = new JComboBox();
        String name[] = fontFamilyNames.getFontName();
        fontNameList.addItem("字体");
        for (String aName : name) fontNameList.addItem(aName);
        fontSizeList.addItem("大小");
        for (int k = 8; k < 72; k+=2) fontSizeList.addItem(k);
        fontNameList.addItemListener(this);
        fontSizeList.addItemListener(this);
        JPanel pNorth = new JPanel();
        pNorth.add(fontNameList);
        pNorth.add(fontSizeList);
        add(pNorth, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        JPanel pSouth = new JPanel();
        pSouth.add(yes);
        pSouth.add(cancel);
        add(pSouth, BorderLayout.SOUTH);
        setBounds(100, 100, 340, 170);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == fontNameList) {
            fontName = (String) fontNameList.getSelectedItem();
            font = new Font(fontName, Font.PLAIN, fontSize);
        } else if (e.getSource() == fontSizeList) {
            fontSize = (Integer) fontSizeList.getSelectedItem();;
            font = new Font(fontName, Font.PLAIN, fontSize);
        }
        label.setFont(font);
        label.repaint();
        validate();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yes) {
            state = YES;
            dispose();
        } else if (e.getSource() == cancel) {
            state = NO;
            dispose();
        }
    }

    public int getState() {
        return state;
    }

    public Font getFont() {
        return font;
    }

}