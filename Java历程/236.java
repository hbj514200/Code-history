import java.awt.*;
import javax.swing.*;

class main extends JFrame {

public main(){
setTitle("舍长帅的程度群众调查");
Container c=getContentPane();                        //国际惯例，获取容器
setLayout(new BorderLayout());                       //指定系统使用边界布局管理器
c.add(BorderLayout.WEST, new JButton("右边说的对"));
c.add(BorderLayout.EAST, new JButton("左边说得对"));
c.add(BorderLayout.NORTH, new JButton("下面说的对"));
c.add(BorderLayout.CENTER, new JButton("舍长最帅"));
c.add(BorderLayout.SOUTH, new JButton("上面说的对"));
setSize(550,350);
setVisible(true);
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}

public static void main(String[] arg)  {    new main();    }

}
