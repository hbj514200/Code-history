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
    setTitle("ͼƬ��ת");
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

//�������ͼƬ��ת��ʵ����  �������󲿷ֵĻ�ͼ����һ�������ǡ���  ��paint()�в�������Graphics���ǰ���תΪGraphics2D���ṩ��ǿ��Ĺ��ܣ�
//������ת���ԣ�rotate()�����ƺ�����ת������壨͸���ģ���  ��ʹ����Image�Ĳ�������û��ʲô��ͬ����ͼƬ�Ѿ���ת�ˣ�  ע�⣺ ˳ʱ�룡��
//rotate()��ת������Graphics2D�еġ�  ����Ϊ�����ƣ�������    ʹ��Math.toRadians()�������Խ��Ƕ�ת��Ϊ����