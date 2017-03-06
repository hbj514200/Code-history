package com.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class userFrame extends JFrame implements ActionListener {
    private ArrayList<fangData> kongId = new ArrayList<>();   //提取加入购物车时的房间号
    private String name;            //当前的登录用户名
    private int flag = 1;           //当前哪个标签
    private JButton kongButton = new JButton("空闲房间");
    private JButton danButton = new JButton("我的订单");
    private JButton buyCarButton = new JButton("去购物车");
    private JButton dinButton = new JButton("加入购物车");
    private JList<String> listView = new JList<>(getKongFangData());
    private JScrollPane gundong = new JScrollPane(listView, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public userFrame(String code, String name) {
        this.name = name;
        setTitle("用户界面");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        if(!code.equals("siran"))       System.exit(0);
        setLayout(new BorderLayout());
        JPanel xia = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        kongButton.addActionListener(this);     xia.add(kongButton);
        danButton.addActionListener(this);      xia.add(danButton);
        buyCarButton.addActionListener(this);   xia.add(buyCarButton);
        dinButton.addActionListener(this);      xia.add(dinButton);
        listView.setFont(new Font("微软雅黑",Font.PLAIN,20));
        gundong.setSize(750,550);
        gundong.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        xia.setPreferredSize(new Dimension(800,40));
        add(gundong, BorderLayout.CENTER);
        add(xia, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    private String[] getKongFangData(){
        ResultSet set = MySQL.getInstance().cha("select * from fangtable where rstate='空'");
        ArrayList<String> data = new ArrayList<>();
        try {
            kongId.clear();
            while (set.next()){
                data.add(String.format("编号：%4s  地址：%10s   类型：%5s  价格：%5.2f", set.getString("rid"), set.getString("raddress"), set.getString("rtype"), set.getDouble("Rprice")));
                kongId.add(new fangData(set.getString("rid"),set.getDouble("Rprice")));
            }
            } catch (SQLException e) {   e.printStackTrace();    }
        return data.toArray(new String[data.size()]);
    }

    private String[] getMyDan(){
        ResultSet set = MySQL.getInstance().cha("SELECT * FROM usertable,dindantable,fangtable,danfangtable WHERE " +
                "usertable.Userid=dindantable.Userid AND dindantable.Soleld=danfangtable.Soleld AND " +
                "danfangtable.rid=fangtable.rid AND usertable.Userid='"+name+"' ORDER BY dindantable.Soleld");
        ArrayList<String> data = new ArrayList<>();
        kongId.clear();
        try {
            while (set.next()){
                data.add(String.format("订单号：%10s  地址：%10s   类型：%5s  房间单价：%5.2f", set.getString("Soleld"), set.getString("raddress"), set.getString("rtype"), set.getDouble("Rprice")));
                data.add("日期:" + set.getString("Soledate").substring(0,10) + "  房间号:"+set.getString("fangtable.rid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data.toArray(new String[data.size()]);
    }

    private String[] getGouDan(){
        ResultSet set = MySQL.getInstance().cha("select * from buycartable, fangtable where gukeId='" + name + "' and rid=fangId");
        ArrayList<String> data = new ArrayList<>();
        kongId.clear();
        try {
            while (set.next()){
                data.add(String.format("编号：%4s  地址：%10s   类型：%5s  价格：%5.2f", set.getString("rid"), set.getString("raddress"), set.getString("rtype"), set.getDouble("Rprice")));
                kongId.add(new fangData(set.getString("rid"),set.getDouble("Rprice")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data.toArray(new String[data.size()]);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()){
            case "空闲房间" :
                listView.setListData(getKongFangData());
                buyCarButton.setText("去购物车");
                dinButton.setText("加入购物车");
                flag = 1;
                break;
            case "我的订单" :
                listView.setListData(getMyDan());
                buyCarButton.setText("去购物车");
                dinButton.setText("加入购物车");
                flag = 2;
                break;
            case "去购物车" :
                listView.setListData(getGouDan());
                buyCarButton.setText("删除房间");
                dinButton.setText("提交订单");
                flag = 3;
                break;
            case "加入购物车" :
                if(flag!=1)   break;
                int[] selected = listView.getSelectedIndices();
                for(int index : selected)
                    MySQL.getInstance().cao("INSERT INTO buycarTable values('"+kongId.get(index).fangjianhao+"', '"+name+"')");
                if(selected.length==0) JOptionPane.showMessageDialog(this, "您没有选择任何房间","提示",JOptionPane.WARNING_MESSAGE);
                else                   JOptionPane.showMessageDialog(this, "成功加入购物车！","恭喜",JOptionPane.PLAIN_MESSAGE);
                break;
            case "删除房间" :
                if(flag!=3)   break;
                int[] selected2 = listView.getSelectedIndices();
                for(int index : selected2)
                    MySQL.getInstance().cao("DELETE FROM buycarTable WHERE fangId = '"+kongId.get(index).fangjianhao+"' and gukeId = '"+name+"'");
                if(selected2.length==0) JOptionPane.showMessageDialog(this, "您没有选择任何房间","提示",JOptionPane.WARNING_MESSAGE);
                else                    JOptionPane.showMessageDialog(this, "删除成功！","提示",JOptionPane.PLAIN_MESSAGE);
                listView.setListData(getGouDan());
                break;
            case "提交订单" :
                if(flag!=3)   break;
                int[] selected3 = listView.getSelectedIndices();
                String danhao= "";  for(int i=1; i<=10; i++)    danhao += Integer.toString((int)(Math.random()*10));
                double sum = 0;     for(int index0 : selected3)  sum+=kongId.get(index0).qian;
                Date now = new Date();    String date = (now.getYear()+1900)+"-"+(now.getMonth()+1)+"-"+now.getDay();
                    MySQL.getInstance().cao(String.format("INSERT dindantable values('%s','%s','%s','%s',%d,'%s',%f)",danhao,name,0,date,selected3.length,"已付",sum));
                for(int index : selected3){
                    MySQL.getInstance().cao(String.format("INSERT danfangtable values('%s','%s')",danhao,kongId.get(index).fangjianhao));
                    MySQL.getInstance().cao("UPDATE fangtable SET rstate = '满' WHERE rid = '"+ kongId.get(index).fangjianhao +"' ");
                    MySQL.getInstance().cao("DELETE FROM buycartable WHERE gukeId='"+name+"' AND fangId = '"+kongId.get(index).fangjianhao+"'");
                }
                if(selected3.length==0) JOptionPane.showMessageDialog(this, "您没有选择任何房间","提示",JOptionPane.WARNING_MESSAGE);
                else                    JOptionPane.showMessageDialog(this, "提交成功！ 共计"+sum+"元","提示",JOptionPane.PLAIN_MESSAGE);
                listView.setListData(getGouDan());
                break;
        }
    }

    class fangData {
        public fangData(String fangjianhao, double qian) {
            this.fangjianhao = fangjianhao;
            this.qian = qian;
        }
        public String fangjianhao;
        public double qian;
    }

}
