import java.awt.*;
import javax.swing.*;

class main extends JFrame {

public main(){
setTitle("我有两个萌萌哒的按钮");                     //设置窗口的标题
setLayout(null);                                    //取消布局管理器的管理
setBounds(0,0,500,250);                             //窗口的位置和大小
Container c=getContentPane();                       //获取一个容器
JButton b1=new JButton("按钮1");                    //创建一号按钮
JButton b2=new JButton("按钮2");                    //创建二号按钮
b1.setBounds(10,30,80,30);      b2.setBounds(60,70,100,20);      //调整按钮的位置和大小	                   
c.add(b1);                       c.add(b2);                      //把按钮加入容器
setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

public static void main(String[] arg){
new main();
}

}