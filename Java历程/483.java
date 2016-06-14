import java.awt.*;
import javax.swing.*;
import java.net.URL;
class main extends JFrame {
private MyCanvas canvasPanel=new MyCanvas();
private Image img=Toolkit.getDefaultToolkit().getImage(main.class.getResource("img.jpg"));

public main(){
    setBounds(100,100,400,300);
    add(canvasPanel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("图片倾斜");
}

public static void main(String[] args) {
    new main().setVisible(true);
}
    
class MyCanvas extends Canvas {                                                 //自定义一个类继承Canvas绘图面板
    public void paint(Graphics g){                                              //必须重构的paint方法
        Graphics2D g2=(Graphics2D) g;                                           //Graphics类型向上转型！
        g2.shear(0.3, 1);
        g2.drawImage(img, 0, 0, 300, 200, this);
    }
}


}


//Graphics2D中的shear()方法可以实现面板的倾斜。 输入两个double，分别为水平和竖直方向的倾斜量，  是向左和向下的…………    应该可以使负值，使他们向右和向上