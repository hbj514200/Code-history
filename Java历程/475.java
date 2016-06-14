import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
class main extends JFrame {
private Shape rect;
private Font font;                                                              //����һ����������font
String time="2016��3��24������";

public main(){
    rect=new Rectangle2D.Double(10,10,200,80);                                   //�����ͼ�ζ���ʵ����Ϊ����
    font=new Font("����",Font.BOLD,16);
    setSize(230,140);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(new CanvasPanel());                                                     //�ѻ�ͼ�������������
    setTitle("��ͼ�ı�");
    setVisible(true);
}
 
public static void main(String[] args) {             
    new main();
}
    
class CanvasPanel extends JPanel {                                              //�̳�JPanel���Զ����ͼ���   
public void paint(Graphics g){                                                   //���ʹ�����д��paint
    super.paint(g);                                                             //���ø����paint()��������g
    Graphics2D g2=(Graphics2D) g;                                               //����ΪGraphics2D���� ���ܸ�ǿ��
    g2.setColor(Color.CYAN);                                                    //Ϊg2��ͼ��������ǰ��ɫ
    g2.fill(rect);                                                              //Ϊͼ�������ɫ
    g2.setColor(Color.BLUE);                                                    //����g2�ĵ�ǰ��ͼ��ɫ
    g2.setFont(font);                                                           //Ϊg2��ͼ�����趨����
    g2.drawString("���ڵ�ʱ����: ",20,30);                                        //��ʾ����
    g2.drawString(time,50,60);
}     
}
    
}

//�������������һ��ҪgetContentPanel������ֱ��add()�ƺ�Ҳ���ԡ�������
//���ڻ�ͼ��壬����paint�����ſ��Ի�ͼ    super.paint(g);              Graphics2D g2=(Graphics2D) g;    Ҳ�Ǳ����
//�ڷ�����ʾ���ڵ��Ǹ���������ò�Ҫ��setVisible��ʾ���ڵķ�����  ��������main().setVisible()���ñȽϺã���Ϊ��ʱ�򲢲�һ��Ҫ��������ʾ