import javax.swing.*;
import java.awt.*;
import java.net.*;
import javax.swing.event.ChangeEvent;
class main extends JFrame {
Image img;                                                                      //图片对象为Image
MyCanvas canvas;                                                                //自定义的类，继承Canvas
JSlider jSlider;                                                                //其实JSlider就是滑块

public static void main(String[] args) {
    new main().setVisible(true);
}

public main(){
    Container cp=getContentPane();
    cp.setLayout(new BorderLayout());
    URL imgurl=main.class.getResource("img.jpg");
    img=Toolkit.getDefaultToolkit().getImage(imgurl);
    canvas=new MyCanvas();                                                      //实例化MyCanvas， 似乎是绘图面板，因为在下一行被当做面板加入了容器
    cp.add(canvas);        
    jSlider=getJSlider();                                                       //实例化了JSlider滑块，使用的是自定义的获取方法
    cp.add(jSlider, BorderLayout.SOUTH);
    setBounds(100,100,800,600);                                                 //setbounds方法，除了设置窗口大小外，还设置了窗口的初始位置
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("图片缩放");
}
    
private JSlider getJSlider(){                                                   //自定义的获取滑块JSlider的方法
    if(jSlider==null){                                                          //如果全局变量JSlider滑块还没有创建，则进入创建模块
        jSlider=new JSlider();                                                  //创建一个新的滑块对象jSlider
        jSlider.setMaximum(100);                                                //设定滑块对象的最大值
        jSlider.setMinimum(1);                                                  //设定滑块对象的最小值
        jSlider.addChangeListener(new javax.swing.event.ChangeListener() {      //滑块对象的专属动作事件      （改变监听器）
            public void stateChanged(ChangeEvent e) {                           //专属动作方法stateChanged  （如果滑块的值被改变了）
                canvas.repaint();                                               //绘图面板Canvas重新绘制图片
            }
        });
    }
    return jSlider;                                                             //返回上面创建的JSlider滑块对象
}

public class MyCanvas extends Canvas {                                          //绘图部分，继承了Canvas类
    public void paint(Graphics g){                                              //国际惯例老方法，传入Graphics g
        int newW=0, newH=0, imgWidth=0, imgHeight=0;                            //几个长宽的变量先初始化
        imgWidth=img.getWidth(this);                                            //获取目前图片的宽度
        imgHeight=img.getHeight(this);                                          //获取目前图片的高度
        double value=jSlider.getValue();                                        //利用JSlider滑块对象的getValue方法返回目前滑块的位置
        newW=(int) (imgWidth*value/100);                                        //计算出新的宽度
        newH=(int) (imgHeight*value/100);                                       //计算出新的高度
        g.drawImage(img, 0, 0, newW, newH, this);                               //绘制图片
    }
}

}

//如果先自己定义了一个变量（但是并没有实例化），  它等于null，   实际上也反映了他只是一个有指向的遥控器
//对于滑块对象而言，利用setmaximum和setMinimum两个方法可以设定其最右端和最左端代表的值，其实有点像PhotoShop的渐变工具
//在Java的API文档中： Canvas类是用来绘图的面板， 必须重写paint()方法。

//对于滑块添加的动作事件是javax.swing.event.ChangeListener()     内部是stateChanged(ChangeEvent e)