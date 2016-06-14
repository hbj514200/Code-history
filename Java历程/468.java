import javax.swing.*;
import java.awt.*;

class main extends JFrame {
private int OVAL_WIDTH=80;                                                      //设定圆的宽度
private int OVAL_HEIGHT=80;                                                     //设定圆的高度

public main(){                                                                  //构造方法
    super();                                                                    //调用父类的构造方法
    initalize();                                                               //调用下面额自定义函数，  这是个单词是“初始化”
}

public static void main(String[] args)      {       new main();     }          

private void initalize(){                                                       //初始化方法
    setSize(300,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setContentPane(new DrawPanel());                                            //设置窗口面板为自定义的绘图面板。  重要
    setTitle("五环绘图");
    setVisible(true);
}
    
class DrawPanel extends JPanel {                                                //内部类继承JPanel实现绘图面板
    public void paint(Graphics g){                                              //重写了固定方法paint，传入未知
        super.paint(g);                                                         //利用父类构造方法传递了未知g
        g.drawOval(10 , 10, OVAL_WIDTH, OVAL_HEIGHT);                            //圆形绘图
        g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT);
        g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT);
        g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT);
        g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT);
    }
}

}