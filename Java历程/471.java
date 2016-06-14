import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class main extends JFrame {
    
public main()       {    super();    initialize();      }

public void initialize(){
    setSize(300,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CanvasPanel());                                                     //ʱ���������Ϊ��ͼ�������������Զ���ģ�
    setTitle("��ͼʵ��2");
}
    
public static void main(String[] args)     {     new main().setVisible(true);      }

class CanvasPanel extends JPanel {                                              //��ͼ�����󣬼̳�JPanel
    public void paint(Graphics g){                                              //paint���Ϸ���
        super.paint(g);                                                         //�ϰ취�����ø����paint������
        Graphics2D g2=(Graphics2D) g;                                           //��Graphics����gת��ΪGraphics2D���󣬻�ù�������
        Shape[] shapes=new Shape[4];                                            //����ͼ������
        shapes[0]=new Ellipse2D.Double(5,5,100,100);                            //����һ��λ�ã� �������ζ���
        shapes[1]=new Rectangle2D.Double(110,5,100,100);                        //�������λ�ã� ����Բ�ζ���
        shapes[2]=new Rectangle2D.Double(15,15,80,80);                          //��������λ�ã� ����Բ�ζ���
        shapes[3]=new Ellipse2D.Double(120,15,80,80);                           //�����ĺ�λ�ã� �������ζ���
        for(Shape shape : shapes){                                              //����ͼ�ζ���
            Rectangle2D bounds=shape.getBounds2D();                             //����ͼ������
            if(bounds.getWidth()==80)       g2.fill(shape);                     //���ͼ��   (�ж�ͼ�Σ���Ϊͼ�θ߶Ȳ�ͬ)
            else                            g2.draw(shape);                     //����ͼ��
        }
        
    }
}

}

//Shape��ͼ�����ͣ� ���ͼ�����ݡ�   ����Shape[]����ͼ������
//��������shape�����getBounds2D��ȡһ��Rectangle2D���󡭡�����