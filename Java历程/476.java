import java.awt.*;
import javax.swing.*;
import java.net.*;
class main extends JFrame {
Image img;

public main(){
    URL imgurl=main.class.getResource("img.jpg");
    img=Toolkit.getDefaultToolkit().getImage(imgurl);                           //����Ŀ�������Ҳ���������Image���󣬵���Image���󲻿�ֱ��ʵ��������  ����ǰʹ�õ���ImageIcon�������һ��
    setSize(1280,720);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CanvasPanel());
    setTitle("����ͼƬ");
}

    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public class CanvasPanel extends JPanel {
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D) g;
        g2.drawImage(img,0,0,this);                                             //����drawImage�������԰�ͼƬ����ȥ
        
    }
}
    
}

//����ǰ�����Ŀ¼��Ҫ��img.jpg��ͼƬ
//����ͼƬ�Ļ�ȡ�ƺ��ǣ�  ĳ������.class.getResource(�ļ���)