import java.awt.*;
import javax.swing.*;
import java.net.*;
class main extends JFrame {
Image img;

public main(){
    URL imgurl=main.class.getResource("img.jpg");
    img=Toolkit.getDefaultToolkit().getImage(imgurl);                           //具体的看不懂，也就是填充了Image对象，但是Image抽象不可直接实例化……  而以前使用的是ImageIcon和这个不一样
    setSize(1280,720);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CanvasPanel());
    setTitle("绘制图片");
}

    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public class CanvasPanel extends JPanel {
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D) g;
        g2.drawImage(img,0,0,this);                                             //利用drawImage方法可以把图片放上去
        
    }
}
    
}

//运行前程序的目录下要有img.jpg的图片
//还有图片的获取似乎是：  某个类名.class.getResource(文件名)