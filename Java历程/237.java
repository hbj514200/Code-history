import java.awt.*;
import javax.swing.*;

class main extends JFrame {

public main() {
Container c=getContentPane();                           //获取容器我就不说了
setLayout(new GridLayout(7,3,5,5));                     //7行3列的网格， 还有两个是间距。
for(int i=1; i<=20; i++)  {    c.add(new JButton("按钮 "+i));    }
setSize(450,450);
setTitle("网格布局管理器窗口实验");
setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

public static void main(String[] arg)   {   new main();  }

}