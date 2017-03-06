package com.example;

/**
 * Created by 黄兆祥 on 2017/3/3.
 */

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginFrame extends JFrame implements ActionListener {
    private JLabel userName = new JLabel("用户账号: ");
    private JLabel password = new JLabel("用户密码: ");
    private JTextField inputName = new JTextField();
    private JPasswordField inputPassword = new JPasswordField();
    private boolean root;       //是否为管理员登录

    public loginFrame(){
        setTitle("登录窗口");
        setSize(385,250);
        setLayout(null);
        userName.setBounds(new Rectangle(45,38,67,34));         inputName.setBounds(new Rectangle(115,39,210,33));
        password.setBounds(new Rectangle(43,86,66,26));         inputPassword.setBounds(new Rectangle(115,84,210,33));
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(new Rectangle(193,150,86,30));    loginButton.addActionListener(this);
        JButton switchButton = new JButton("切换类型");
        switchButton.setBounds(new Rectangle(78,150,86,30));    switchButton.addActionListener(this);
        this.add(userName);
        this.add(password);
        this.add(inputName);
        this.add(inputPassword);
        this.add(loginButton);
        this.add(switchButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals("登录")){ //点击登录按钮
            if(checkUser(inputName.getText(), inputPassword.getText())){ // 账号有效
                if(root)    adminFrame.work("siran");
                else        new userFrame("siran", inputName.getText());
                setVisible(false);
            }
            else JOptionPane.showMessageDialog(null, "登陆失败, 请检查用户名和密码。", "注意", JOptionPane.WARNING_MESSAGE);
        } else {
            if(!root){
                userName.setText("管理账号: ");
                password.setText("管理密码: ");
                root = true;
            } else {
                userName.setText("用户账号: ");
                password.setText("用户密码: ");
                root = false;
            }
        }
    }

    private boolean checkUser(String name, String password) {
        ResultSet set = MySQL.getInstance().cha("select * from usertable where Userid = '"+name+"' and Password = '"+password+"' and type = '" + ((root)?"ad":"us") + "'");
        try {
            if(set.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args){
        new loginFrame();
    }

}
