import javax.swing.*;
import java.awt.*;
import java.net.URL;

class main extends JFrame {
private Image img=Toolkit.getDefaultToolkit().getImage(main.class.getResource("img.jpg"));
private MyCanvas canvasPanel=new MyCanvas();

public static void main(String[] args) {
   new main().setVisible(true);
}

public main(){
    setBounds(100,100,900,700);
    add(canvasPanel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("图片旋转");
}

class MyCanvas extends Canvas {
public void paint(Graphics g){
    Graphics2D g2=(Graphics2D) g;
    g2.rotate(Math.toRadians(10));
    g2.drawImage(img, 400, 20, 300, 200, this);
    g2.rotate(Math.toRadians(10));
    g2.drawImage(img, 400, 20, 300, 200, this);
    g2.rotate(Math.toRadians(10));
    g2.drawImage(img, 400, 20, 300, 200, this);
    g2.rotate(Math.toRadians(10));
    g2.drawImage(img, 400, 20, 300, 200, this);
    g2.rotate(Math.toRadians(10));
    g2.drawImage(img, 400, 20, 300, 200, this);
    g2.rotate(Math.toRadians(10));
    g2.drawImage(img, 400, 20, 300, 200, this);
}
}

}

//对于这个图片旋转的实例，  和其他大部分的绘图部分一样，但是……  它paint()中不在利用Graphics而是把它转为Graphics2D来提供更强大的功能，
//对于旋转而言，rotate()方法似乎是旋转整个面板（透明的），  即使绘制Image的参数坐标没有什么不同但是图片已经旋转了，  注意： 顺时针！！
//rotate()旋转方法是Graphics2D有的。  输入为弧度制！！！！    使用Math.toRadians()方法可以将角度转化为弧度