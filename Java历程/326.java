import java.util.*;                                                             //����;��
import java.awt.*;                                                              //�����
import javax.swing.*;                                                           //���������
class main extends JFrame {                                                     //�̳�JFrame������
private Thread t;                                                               //�����յ�Thread���̴߳�硣
private static Color[] color={Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.ORANGE, Color.YELLOW, Color.RED, Color.pink, Color.lightGray};//����һ����ɫ����
private static final Random rand=new Random();                                  //������һ���������ȡ����

private static Color getC()     {   return color[rand.nextInt(color.length)];   } //������һ��getC���������������ɫ�����еĶ�һ����ɫֵ��
private main(){                                                                   //�����Է���
t=new Thread(new Runnable() {                                                     //��Thread�������һ��Runnable����ʹ�õ��������ڲ���
   int x=30, y=50;                                                                //�������ڲ����е�run�����ⶨ��int����ֵx��y
    public void run() {                                                           //���߳̽ӿڹ̶�run����
       while(true){                                                               //����ѭ��
           try {    Thread.sleep(100);     }     catch (Exception e)    {   e.printStackTrace();   }   //�̳в����з���try�� ����100ms
           Graphics graphics=getGraphics();                                       //��ȡһ����ͼ���
           graphics.setColor(getC());                                             //�趨��ɫ�� ��ɫ��getC����
           graphics.drawLine(x,y,100,y++);                                        //����������趨��λ�úʹ�С
           if(y>=80)       y=50;                                                  //ѭ����
       }
     }
    
});
t.start();                                                                        //�߳�����
}
    
public static void main(String[] args)      {        init(new main(), 100, 100);     }  

public static void init(JFrame frame, int width, int height){                     
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(width,height);
frame.setVisible(true);
}

}

//rand��netInt�ķ����ڵھ���ʹ�õ��ƺ�ͦ��ֵġ�