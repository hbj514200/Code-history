import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class main extends JFrame {
    
public main()       {    super();    initialize();      }

public void initialize(){
    setSize(300,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CanvasPanel());                                                     //时至船体面板为绘图面板对象（在下面自定义的）
    setTitle("绘图实例2");
}
    
public static void main(String[] args)     {     new main().setVisible(true);      }

class CanvasPanel extends JPanel {                                              //绘图面板对象，继承JPanel
    public void paint(Graphics g){                                              //paint的老方法
        super.paint(g);                                                         //老办法，调用父类的paint方法，
        Graphics2D g2=(Graphics2D) g;                                           //把Graphics对象g转化为Graphics2D对象，获得功能升级
        Shape[] shapes=new Shape[4];                                            //创建图形数组
        shapes[0]=new Ellipse2D.Double(5,5,100,100);                            //数组一号位置： 创建矩形对象
        shapes[1]=new Rectangle2D.Double(110,5,100,100);                        //数组二号位置： 创建圆形对象
        shapes[2]=new Rectangle2D.Double(15,15,80,80);                          //数组三号位置： 创建圆形对象
        shapes[3]=new Ellipse2D.Double(120,15,80,80);                           //数组四号位置： 创建矩形对象
        for(Shape shape : shapes){                                              //遍历图形对象
            Rectangle2D bounds=shape.getBounds2D();                             //遍历图形数组
            if(bounds.getWidth()==80)       g2.fill(shape);                     //填充图形   (判断图形，因为图形高度不同)
            else                            g2.draw(shape);                     //绘制图形
        }
        
    }
}

}

//Shape是图形类型， 存放图形数据。   例如Shape[]就是图形数组
//利用利用shape对象的getBounds2D获取一个Rectangle2D对象…………