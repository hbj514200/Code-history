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
    setTitle("ͼƬ��б");
}

public static void main(String[] args) {
    new main().setVisible(true);
}
    
class MyCanvas extends Canvas {                                                 //�Զ���һ����̳�Canvas��ͼ���
    public void paint(Graphics g){                                              //�����ع���paint����
        Graphics2D g2=(Graphics2D) g;                                           //Graphics��������ת�ͣ�
        g2.shear(0.3, 1);
        g2.drawImage(img, 0, 0, 300, 200, this);
    }
}


}


//Graphics2D�е�shear()��������ʵ��������б�� ��������double���ֱ�Ϊˮƽ����ֱ�������б����  ����������µġ�������    Ӧ�ÿ���ʹ��ֵ��ʹ�������Һ�����