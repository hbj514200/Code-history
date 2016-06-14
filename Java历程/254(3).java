import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class main extends JFrame {
String zhanghao="hbj514200";    String password="514200";

public main() {
Container cp=getContentPane();      cp.setLayout(new GridLayout(2,1));
JPanel mianban1=new JPanel();       JPanel mianban2=new JPanel();     mianban1.setLayout(new GridLayout(1,2));   mianban2.setLayout(new GridLayout(1,2));
cp.add(mianban1);   cp.add(mianban2);

JLabel wenzi1=new JLabel("用户名:");   JLabel wenzi2=new JLabel(" 密  码:");   JPanel zuoshang=new JPanel(new GridLayout(2,1));
zuoshang.add(wenzi1);   zuoshang.add(wenzi2);    mianban1.add(zuoshang);
JPanel youshang=new JPanel(new GridLayout(2,1));   JTextField minzi=new JTextField();  JPasswordField mima=new JPasswordField();
youshang.add(minzi);       youshang.add(mima);   mianban1.add(youshang);

JButton jb1=new JButton("提交");   JButton jb2=new JButton("重置");   mianban2.add(jb1);   mianban2.add(jb2);
class dongzuo1 implements ActionListener {  public void actionPerformed(ActionEvent e){
if( zhanghao.equals(minzi.getText())&&password.equals(mima.getText()) )  JOptionPane.showMessageDialog(null,"登陆成功，顶级黑客");    else    JOptionPane.showMessageDialog(null,"账号或密码错误");
}
}
jb1.addActionListener(new dongzuo1());
class dongzuo2 implements ActionListener {  public void actionPerformed(ActionEvent e)  {   minzi.setText("");  mima.setText("");   }   }
jb2.addActionListener(new dongzuo2());

setSize(280,170);       setVisible(true);   setTitle("黑客登陆");   setResizable(false);
}
    
public static void main(String[] arg)    {    new main();   }

}