import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class main extends JFrame {                          //继承JFrame类

public main() {                                        
JCheckBox jc1=new JCheckBox();                       //创建jc1复选框
JCheckBox jc2=new JCheckBox();                       //创建jc2复选框
JCheckBox jc3=new JCheckBox();                       //创建jc3复选框
JTextArea jt=new JTextArea();                        //创建一个名叫jt的文字编辑器
JPanel panel1=new JPanel();                          //创建一个JPanel的小面板panel1
JPanel panel2=new JPanel();                          //创建一个JPanel的小面板panel2
Container c=getContentPane();                        //获取一个界面容器
c.setLayout(new BorderLayout());                     //主窗口使用边界布局管理器管理
c.add(panel1,BorderLayout.CENTER);                    //把panel1的JPanel面板放在窗口上部
final JScrollPane scrollPane=new JScrollPane(jt);    //创建一个不允许编辑jt文字器的JS滚动小面板。
scrollPane.setVisible(true);
panel1.add(scrollPane);                              //把带文字编辑的JS滚动小面板加入JPanel面板。
c.add(panel2,BorderLayout.SOUTH);                          //把panel2的JPanel固定小面板放在窗口下部
panel2.add(jc1);		panel2.add(jc2);		panel2.add(jc3);      //把三个jc复选框加入panel2固定小面板
jc1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
jt.append("复选框1被你选中了\n");
}
});
jc2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
jt.append("复选框2被你选中了\n");
}
});
jc3.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
jt.append("复选框3被你选中了\n");
}
});
setVisible(true);
setSize(240,320);
}

public static void main(String[] arg)   {   new main();  }

}