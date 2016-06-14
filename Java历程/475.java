import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
class main extends JFrame {
private Shape rect;
private Font font;                                                              //创建一个字体对象叫font
String time="2016年3月24日早上";

public main(){
    rect=new Rectangle2D.Double(10,10,200,80);                                   //把这个图形对象实例化为矩形
    font=new Font("宋体",Font.BOLD,16);
    setSize(230,140);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CanvasPanel());                                                     //把绘图面板加入界面容器
    setTitle("绘图文本");
    setVisible(true);
}
 
public static void main(String[] args) {             
    new main();
}
    
class CanvasPanel extends JPanel {                                              //继承JPanel的自定义绘图面板   
public void paint(Graphics g){                                                   //国际惯例重写了paint
    super.paint(g);                                                             //调用父类的paint()方法传入g
    Graphics2D g2=(Graphics2D) g;                                               //升级为Graphics2D对象 功能更强大
    g2.setColor(Color.CYAN);                                                    //为g2绘图对象设置前景色
    g2.fill(rect);                                                              //为图形填充颜色
    g2.setColor(Color.BLUE);                                                    //重设g2的当前绘图颜色
    g2.setFont(font);                                                           //为g2绘图对象设定字体
    g2.drawString("现在的时间是: ",20,30);                                        //显示文字
    g2.drawString(time,50,60);
}     
}
    
}

//好像界面容器不一定要getContentPanel方法，直接add()似乎也可以…………
//对于绘图面板，覆盖paint方法才可以绘图    super.paint(g);              Graphics2D g2=(Graphics2D) g;    也是必须的
//在否则显示窗口的那个方法里最好不要放setVisible显示窗口的方法，  由主函数main().setVisible()调用比较好，因为有时候并不一定要他立即显示