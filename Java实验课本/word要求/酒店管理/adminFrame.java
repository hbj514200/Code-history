package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class adminFrame extends JPanel implements ActionListener {
    private ArrayList<String> kongId = new ArrayList<>();
    private JList<String> listView2 = new JList<>(getAllUser());
    private JList<String> listView = new JList<>(getAllFang());
    private JButton zenButton = new JButton("增加房间");
    private JButton shanButton = new JButton("删除房间");
    private JButton chaButton = new JButton("查询房间");
    private JButton gaiButton = new JButton("修改房间");
    private JButton zenButton2 = new JButton("增加用户");
    private JButton shanButton2 = new JButton("删除用户");
    private JButton chaButton2 = new JButton("查询用户");
    private JButton gaiButton2 = new JButton("修改用户");
    private JScrollPane gundong = new JScrollPane(listView, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    private JScrollPane gundong2 = new JScrollPane(listView2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    private adminFrame() {
        super(new GridLayout(1, 1));
        final JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel(new BorderLayout());                      //房间标签页
        JPanel xia = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        zenButton.addActionListener(this);      xia.add(zenButton);
        shanButton.addActionListener(this);     xia.add(shanButton);
        chaButton.addActionListener(this);      xia.add(chaButton);
        gaiButton.addActionListener(this);      xia.add(gaiButton);
        listView.setFont(new Font("微软雅黑",Font.PLAIN,20));
        gundong.setSize(750,550);
        gundong.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        xia.setPreferredSize(new Dimension(800,40));
        panel1.add(gundong, BorderLayout.CENTER);
        panel1.add(xia, BorderLayout.SOUTH);

        JPanel panel2 = new JPanel(new BorderLayout());                                       //用户标签页
        JPanel xia2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        zenButton2.addActionListener(this);      xia2.add(zenButton2);
        shanButton2.addActionListener(this);     xia2.add(shanButton2);
        chaButton2.addActionListener(this);      xia2.add(chaButton2);
        gaiButton2.addActionListener(this);      xia2.add(gaiButton2);
        listView2.setFont(new Font("微软雅黑",Font.PLAIN,20));
        gundong2.setSize(750,550);
        gundong2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        xia2.setPreferredSize(new Dimension(800,40));
        panel2.add(gundong2, BorderLayout.CENTER);
        panel2.add(xia2, BorderLayout.SOUTH);

        tabbedPane.addTab("房间管理", null, panel1, "可以进行房间管理");
        tabbedPane.setSelectedIndex(0);
        tabbedPane.addTab("用户管理", null, panel2, "可以进行用户管理");
        add(tabbedPane);
        tabbedPane.addChangeListener(new ChangeListener(){                                //切换选项卡时候，kongId和列表刷新
            @Override public void stateChanged(ChangeEvent e){
                if (tabbedPane.getSelectedIndex()==0)   listView.setListData(getAllFang());
                else                                    listView2.setListData(getAllUser());
            }
        });
    }

    public static void work(String code) {
        if(!code.equals("siran"))   System.exit(0);
        JFrame frame = new JFrame("管理界面");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new adminFrame(), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(frame.getOwner());
        frame.setVisible(true);
    }

    private String[] getAllFang(){
        ResultSet set = MySQL.getInstance().cha("select * from fangtable");
        ArrayList<String> data = new ArrayList<>();
        try {
            kongId.clear();
            while (set.next()){
                data.add(String.format("编号：%4s  地址：%10s   类型：%5s  价格：%5.2f  状态: %s", set.getString("rid"), set.getString("raddress"), set.getString("rtype"), set.getDouble("Rprice"),set.getString("rstate")));
                kongId.add(set.getString("rid"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"加载数据库信息失败","提示",JOptionPane.WARNING_MESSAGE);
        }
        return data.toArray(new String[data.size()]);
    }

    private String[] getAllUser(){
        ResultSet set = MySQL.getInstance().cha("SELECT Userid,type FROM usertable");
        ArrayList<String> data = new ArrayList<>();
        try {
            kongId.clear();
            while (set.next()){
                data.add(String.format("用户名: %s      类型: %4s", set.getString("Userid"), set.getString("type")));
                kongId.add(set.getString("Userid"));
            }
        } catch (SQLException e) {   e.printStackTrace();    }
        return data.toArray(new String[data.size()]);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){
            case "增加房间" :
                new jiaFangDialog(1);
                listView.setListData(getAllFang());
                break;
            case "删除房间" :
                int[] selected = listView.getSelectedIndices();
                for(int index : selected){
                    MySQL.getInstance().cao("DELETE FROM fangtable WHERE rid = '"+kongId.get(index)+"'");
                    System.out.println("DELETE FROM fangtable WHERE rid = '"+kongId.get(index)+"'");
                }
                if(selected.length==0) JOptionPane.showMessageDialog(this, "您没有选择任何房间","提示",JOptionPane.WARNING_MESSAGE);
                else                    JOptionPane.showMessageDialog(this, "删除成功！","提示",JOptionPane.PLAIN_MESSAGE);
                listView.setListData(getAllFang());
                break;
            case "查询房间" :
                String mubaio1 = JOptionPane.showInputDialog(this,"请输入房间号","");
                if(mubaio1==null)    return;
                int j = 0;
                for(String st:kongId)
                    if(st.equals(mubaio1)){
                        listView.setSelectedIndex(j);
                        return;
                    }  else    j++;
                JOptionPane.showMessageDialog(this,"找不到该房间号","提示",JOptionPane.WARNING_MESSAGE);
                break;
            case "修改房间" :
                jiaFangDialog.fangjianId = kongId.get(listView.getSelectedIndex());
                new jiaFangDialog(2);
                listView.setListData(getAllFang());
                break;
            case "增加用户" :
                new jiaUserDialog(1);
                listView2.setListData(getAllUser());
                break;
            case "删除用户" :
                int[] selected2 = listView2.getSelectedIndices();
                for(int index2 : selected2)
                    MySQL.getInstance().cao("DELETE FROM usertable WHERE Userid = '"+kongId.get(index2)+"'");
                if(selected2.length==0) JOptionPane.showMessageDialog(this, "您没有选择任何用户","提示",JOptionPane.WARNING_MESSAGE);
                else                    JOptionPane.showMessageDialog(this, "删除成功！","提示",JOptionPane.PLAIN_MESSAGE);
                listView2.setListData(getAllUser());
                break;
            case "查询用户" :
                String mubaio = JOptionPane.showInputDialog(this,"请输入用户名","");
                if(mubaio==null)    return;
                int i = 0;
                for(String st:kongId)
                    if(st.equals(mubaio)){
                    listView2.setSelectedIndex(i);
                    return;
                }  else    i++;
                JOptionPane.showMessageDialog(this,"找不到该用户","提示",JOptionPane.WARNING_MESSAGE);
                break;
            case "修改用户" :
                jiaUserDialog.yonghumin = kongId.get(listView2.getSelectedIndex());
                new jiaUserDialog(2);
                System.out.println(kongId.get(listView2.getSelectedIndex()));
                listView2.setListData(getAllUser());
                break;
        }
    }

}

class jiaUserDialog extends JFrame implements ActionListener {
    private JTextField name = new JTextField(80);
    JTextField password = new JTextField(80);
    private JCheckBox box = new JCheckBox("管理员");
    private int flag = 1;      //区分新增还是修改用户信息
    public static String yonghumin;   //修改信息时候用的

    public jiaUserDialog(int flag) {
        this.flag = flag;
        JDialog jd = new JDialog();
        jd.setSize(385,250);
        jd.setLayout(null);
        jd.setTitle("信息变动");
        JLabel label1 = new JLabel("用户账号：");
        jd.add(label1);
        jd.add(name);
        label1.setBounds(new Rectangle(45,38,67,34));     name.setBounds(new Rectangle(115,39,210,33));
        JLabel label2 = new JLabel("用户密码：");
        label2.setBounds(new Rectangle(43,86,66,26));     password.setBounds(new Rectangle(115,84,210,33));
        jd.add(label2);
        jd.add(password);
        box.setBounds(new Rectangle(78,130,80,60));
        jd.add(box);
        JButton button = new JButton("确定");
        button.setBounds(new Rectangle(193,150,86,30));     button.addActionListener(this);
        jd.add(button);
        jd.setModal(true);
        jd.setLocationRelativeTo(getOwner());
        jd.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if(flag==1){//新增用户
            try {
                if(name.getText().equals("")||password.getText().equals(""))    throw new Exception();
                MySQL.getInstance().cao("INSERT usertable VALUES ('"+name.getText()+"','"+password.getText()+"','"+(box.isSelected()?"ad":"us")+"')");
                JOptionPane.showMessageDialog(this, "新建成功!","提示",JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "新建失败，请检查输入","提示",JOptionPane.PLAIN_MESSAGE);
            } finally {
                dispose();
            }
        }
        if(flag==2){//修改用户
            System.out.println(yonghumin);
            try {
                if(name.getText().equals("")||password.getText().equals(""))    throw new Exception();
                MySQL.getInstance().cao("UPDATE usertable SET Userid='"+name.getText()+"',Password='"+password.getText()+"',type='"+(box.isSelected()?"ad":"us")+"' WHERE Userid='"+yonghumin+"'");
                System.out.println("UPDATE usertable SET Userid='"+name.getText()+"',Password='"+password.getText()+"',type='"+(box.isSelected()?"ad":"us")+"' WHERE Userid='"+yonghumin+"'");
                JOptionPane.showMessageDialog(this, "处理成功!","提示",JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "处理失败，请检查输入","提示",JOptionPane.PLAIN_MESSAGE);
            } finally {
                dispose();
            }
        }

    }
}

class jiaFangDialog extends JDialog implements ActionListener {
    private JTextField input1 = new JTextField();
    private JTextField input2 = new JTextField();
    private JTextField input3 = new JTextField();
    private JTextField input4 = new JTextField();
    private JCheckBox box = new JCheckBox("现在已满");
    private int flag = 1;
    public static String fangjianId;

    public jiaFangDialog(int flag) {

        this.flag = flag;
        setTitle("房间信息编辑");
        setSize(320,250);
        GridLayout layout = new GridLayout(5,2);
        layout.setVgap(10);
        setLayout(layout);
        add(new JLabel("  房间编号："));             add(input1);
        add(new JLabel("  房间地址： "));            add(input2);
        add(new JLabel("  房间类型："));             add(input3);
        add(new JLabel("  房间价格："));             add(input4);
        JButton button =  new JButton("确定");    add(box);     add(button);  button.addActionListener(this);
        setResizable(false);
        setModal(true);
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(flag==1){
            try {
                if(input1.getText().equals("")||input2.getText().equals("")||input3.getText().equals("")||input4.getText().equals(""))
                    throw new RuntimeException();
                MySQL.getInstance().cao("INSERT INTO fangtable (rid, Rprice, raddress, rtype, rstate) VALUES ('"+input1.getText()+"', '"+input4.getText()+"', '"+input2.getText()+"', '"+input3.getText()+"', '"+((box.isSelected()?"ad":"us"))+"')");
                JOptionPane.showMessageDialog(this, "处理成功!","提示",JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "处理失败，请检查输入","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
        if(flag==2){
            try {
                if(input1.getText().equals("")||input2.getText().equals("")||input3.getText().equals("")||input4.getText().equals(""))
                    throw new RuntimeException();
                MySQL.getInstance().cao("UPDATE fangtable SET rid='"+input1.getText()+"', Rprice="+input4.getText()+", raddress='"+input2.getText()+"', rtype='"+input3.getText()+"', rstate='"+((box.isSelected()?"满":"空"))+"' WHERE rid='"+fangjianId+"' ");
                JOptionPane.showMessageDialog(this, "处理成功!","提示",JOptionPane.PLAIN_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "处理失败，请检查输入","提示",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}