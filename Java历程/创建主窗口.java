import java.awt.*;
import javax.swing.*;
class main extends JFrame{

public void CreateJFrame(String title){
JFrame jf=new JFrame(title);                             //这个title字符串是这个窗口上的名字！
Container container=jf.getContentPane();                 //获取一个界面容器。
container.setBackground(Color.white);
jf.setVisible(true);
jf.setSize(1200,700);
jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}

public static void main(String[] arg){
new main().CreateJFrame("厚德D1-741宿舍 舍长专用系统");
}

}