import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class main extends JFrame {
JMenuBar menuBar=new JMenuBar();                                                //新建一个 菜单栏对象 JMenuBar （Bar单词： 条 栏  ）
JMenu menu=new JMenu("菜单栏名称");                                              //新建一个 菜单项对象 JMenu    （直接显示在菜单栏上）
JMenuItem menuItem=new JMenuItem("菜单项名称");                                  //新建一个 菜单子对象 MenuItem （用于加到二级菜单  ）
JMenuItem menuItem2=new JMenuItem("菜单项名称2");                                //新建一个 菜单子对象 MenuItem （用于加到二级菜单  ）

public static void main(String[] args) {                                        //主main测试方法
   new main().setVisible(true);
}

public main(){
    Container cp=getContentPane();                                              //以下四行，  基本窗口属性的设置
    setSize(320,240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("菜单栏窗口");
    
    setJMenuBar(menuBar);                                                       //使用 setJMenuBar() 方法为窗口设置菜单栏对象
    menuBar.add(menu);                                                          //把菜单项 JMenu 加入到菜单栏中
    menu.add(menuItem);                                                         //把菜单子对象 JMenuItem 加入到菜单项中
    menu.add(menuItem2);                                                        //把菜单子对象 JMenuItem 加入到 JMenu 中
    
    menuItem.addActionListener(new ActionListener() {                           //为 menuItem1 菜单子对象添加动作响应事件
        public void actionPerformed(ActionEvent e) {                                //固定响应动作方法，  和Button动作事件一样
            JMenuItem menuItem=(JMenuItem) e.getSource();                               //利用 getSource() 方法获取事件来源的JMenuItem对象
            System.out.println("您单击的是菜单项：  "+menuItem.getText());                //显示用户操作结果
        }
    });
    
     menuItem2.addActionListener(new ActionListener() {                           //为 menuItem1 菜单子对象添加动作响应事件
        public void actionPerformed(ActionEvent e) {                                //固定响应动作方法，  和Button动作事件一样
            JMenuItem menuItem=(JMenuItem) e.getSource();                               //利用 getSource() 方法获取事件来源的JMenuItem对象
            System.out.println("您单击的是菜单项：  "+menuItem.getText());                //显示用户操作结果
        }
    });
    
}
    
}