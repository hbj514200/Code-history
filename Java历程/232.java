import java.awt.*;
import javax.swing.*;
import java.net.*;                                              //这个包是URL可以使用的前提
import java.awt.event.*;

class MyJDialog extends JDialog {
public MyJDialog(main frame){
super(frame,"裸聊匹配失败",true);
Container container=getContentPane();
JLabel jl=new JLabel("舍长太帅，无法匹配到适合你的美女！");
jl.setHorizontalAlignment(SwingConstants.CENTER);
container.add(jl);
setBounds(600,400,400,250);
setVisible(true);
}
}


class main extends JFrame {

public main(){
Container container=getContentPane();                             //获取一个JFrame的容器
JLabel jl=new JLabel("这是我的壁纸",JLabel.CENTER);         //创建一个JL标签
URL url=main.class.getResource("imageButton.jpg");             //获取图片的URL
Icon icon=new ImageIcon(url);                                              //实例化Icon对象
jl.setIcon(icon);                                                     //为标签设置图片
jl.setHorizontalAlignment(SwingConstants.CENTER);                     //文字居中
jl.setOpaque(true);                                                   //设置标签不透明（即可见）
container.add(jl);
setSize(1280,720);
setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
JButton bl=new JButton("匹配美女立即裸聊");
bl.setBounds(400,300,250,100);
bl.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
new MyJDialog(main.this).setVisible(true);
}
});
container.add(bl);
}

public static void main(String[] arg)   {    new main();   }

}
