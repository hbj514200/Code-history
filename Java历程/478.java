import javax.swing.*;
import java.awt.*;
import java.net.*;
import javax.swing.event.ChangeEvent;
class main extends JFrame {
Image img;                                                                      //ͼƬ����ΪImage
MyCanvas canvas;                                                                //�Զ�����࣬�̳�Canvas
JSlider jSlider;                                                                //��ʵJSlider���ǻ���

public static void main(String[] args) {
    new main().setVisible(true);
}

public main(){
    Container cp=getContentPane();
    cp.setLayout(new BorderLayout());
    URL imgurl=main.class.getResource("img.jpg");
    img=Toolkit.getDefaultToolkit().getImage(imgurl);
    canvas=new MyCanvas();                                                      //ʵ����MyCanvas�� �ƺ��ǻ�ͼ��壬��Ϊ����һ�б�����������������
    cp.add(canvas);        
    jSlider=getJSlider();                                                       //ʵ������JSlider���飬ʹ�õ����Զ���Ļ�ȡ����
    cp.add(jSlider, BorderLayout.SOUTH);
    setBounds(100,100,800,600);                                                 //setbounds�������������ô��ڴ�С�⣬�������˴��ڵĳ�ʼλ��
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("ͼƬ����");
}
    
private JSlider getJSlider(){                                                   //�Զ���Ļ�ȡ����JSlider�ķ���
    if(jSlider==null){                                                          //���ȫ�ֱ���JSlider���黹û�д���������봴��ģ��
        jSlider=new JSlider();                                                  //����һ���µĻ������jSlider
        jSlider.setMaximum(100);                                                //�趨�����������ֵ
        jSlider.setMinimum(1);                                                  //�趨����������Сֵ
        jSlider.addChangeListener(new javax.swing.event.ChangeListener() {      //��������ר�������¼�      ���ı��������
            public void stateChanged(ChangeEvent e) {                           //ר����������stateChanged  ����������ֵ���ı��ˣ�
                canvas.repaint();                                               //��ͼ���Canvas���»���ͼƬ
            }
        });
    }
    return jSlider;                                                             //�������洴����JSlider�������
}

public class MyCanvas extends Canvas {                                          //��ͼ���֣��̳���Canvas��
    public void paint(Graphics g){                                              //���ʹ����Ϸ���������Graphics g
        int newW=0, newH=0, imgWidth=0, imgHeight=0;                            //��������ı����ȳ�ʼ��
        imgWidth=img.getWidth(this);                                            //��ȡĿǰͼƬ�Ŀ��
        imgHeight=img.getHeight(this);                                          //��ȡĿǰͼƬ�ĸ߶�
        double value=jSlider.getValue();                                        //����JSlider��������getValue��������Ŀǰ�����λ��
        newW=(int) (imgWidth*value/100);                                        //������µĿ��
        newH=(int) (imgHeight*value/100);                                       //������µĸ߶�
        g.drawImage(img, 0, 0, newW, newH, this);                               //����ͼƬ
    }
}

}

//������Լ�������һ�����������ǲ�û��ʵ��������  ������null��   ʵ����Ҳ��ӳ����ֻ��һ����ָ���ң����
//���ڻ��������ԣ�����setmaximum��setMinimum�������������趨�����Ҷ˺�����˴����ֵ����ʵ�е���PhotoShop�Ľ��乤��
//��Java��API�ĵ��У� Canvas����������ͼ����壬 ������дpaint()������

//���ڻ�����ӵĶ����¼���javax.swing.event.ChangeListener()     �ڲ���stateChanged(ChangeEvent e)