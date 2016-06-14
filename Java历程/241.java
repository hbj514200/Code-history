import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;                          //触发事件的包在awt里面。

class main extends JFrame {                       //继承JFrame

public main() {
URL url=main.class.getResource("anniu.jpg");      //获取按钮图片的url地址。
Icon icon=new ImageIcon(url);                     //创建一个按钮图片的Icon。
setLayout(new GridLayout(3,2,5,5));               //网格管理器，3行2列，间隔5.
Container c=getContentPane();                     //创建界面容器
setSize(480,640);                                 //设置这个主窗口初始大小
setTitle("舍长测试窗口");                         //设置窗口标题名字
setVisible(true);                                 //使这个主窗口可见化
for(int i=1; i<=5; i++)                           //添加按钮都是JButton，里面setEnabled管理按钮是否可用
{   JButton J=new JButton("舍长帅不帅"+i,icon);   if(i%2==0)   J.setEnabled(false);   c.add(J);   }
JButton jb=new JButton();                         //新建空白按钮JButton，可以传入字符串名字和icon图片。
jb.setMaximumSize(new Dimension(90,30));          
jb.setIcon(icon);                                 //利用JButton按钮的setIcon方法传入icon图片设置按钮图片
jb.setHideActionText(true);                       
jb.setToolTipText("图片按钮");                    //指定本图片按钮的显示的文字名字，但在实际界面不显示。
jb.setBorderPainted(true);                       //设置按钮边框要显示（默认就是要的）
jb.addActionListener(new ActionListener(){       //添加监听触发事件，大东西放入括号。
public void actionPerformed(ActionEvent e)       //应该是设定默认固定名字的触发方法actionPerformed，传入的是一个ActionEvent的事件传递对象e。
{  JOptionPane.showMessageDialog(null,"舍长最帅啦，知道了吧");   }  //弹出常见的提示消息框
});
c.add(jb);                                       //把jb加入界面容器。
}

public static void main(String[] arg)  {  new main();  }  

}