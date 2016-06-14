import java.util.*;                                                             //多用途包
import java.awt.*;                                                              //界面包
import javax.swing.*;                                                           //界面组件包
class main extends JFrame {                                                     //继承JFrame的主类
private Thread t;                                                               //创建空的Thread多线程大哥。
private static Color[] color={Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED, Color.pink, Color.lightGray};//创建一个颜色数组
private static final Random rand=new Random();                                  //创建了一个随机数获取对象

private static Color getC()     {   return color[rand.nextInt(color.length)];   } //定义了一个getC函数，随机返回颜色数组中的而一种颜色值。
private main(){                                                                   //主测试方法
t=new Thread(new Runnable() {                                                     //向Thread里面添加一个Runnable对象，使用的是匿名内部类
   int x=30, y=50;                                                                //在匿名内部类中的run方法外定义int整数值x和y
    public void run() {                                                           //多线程接口固定run方法
       while(true){                                                               //无限循环
           try {    Thread.sleep(100);     }     catch (Exception e)    {   e.printStackTrace();   }   //继承操作有风险try， 休眠100ms
           Graphics graphics=getGraphics();                                       //获取一个绘图组件
           graphics.setColor(getC());                                             //设定颜色， 颜色从getC返回
           graphics.drawLine(x,y,100,y++);                                        //描绘线条，设定了位置和大小
           if(y>=80)       y=50;                                                  //循环。
       }
     }
    
});
t.start();                                                                        //线程启动
}
    
public static void main(String[] args)      {        init(new main(), 100, 100);     }  

public static void init(JFrame frame, int width, int height){                     
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(width,height);
frame.setVisible(true);
}

}

//rand的netInt的方法在第九行使用的似乎挺奇怪的。