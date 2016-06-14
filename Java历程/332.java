import javax.swing.*;                                                           //�����
import java.awt.*;                                                              //���������
class main extends JFrame {                                                     //���࣬ �̳�JFrame
JProgressBar jindu1=new JProgressBar();                                         //�½�һ�Ž�����
JProgressBar jindu2=new JProgressBar();                                         //�½����Ž�����
JProgressBar jindu3=new JProgressBar();                                         //�½����Ž�����
JProgressBar jindu4=new JProgressBar();                                         //�½��ĺŽ�����
Thread threadA, threadB, threadC, threadD;                                      //�����ĸ����̶���
int count=0;                                                                    //������count

public main(){                                                                  //�����ڷ���
Container cp=getContentPane();                                                  //��ȡһ����������
cp.add(jindu1);   cp.add(jindu2);   cp.add(jindu3);   cp.add(jindu4);           //���ĸ������������������
jindu1.setStringPainted(true);      jindu2.setStringPainted(true);              //���ý�������ʾ������ʾ
jindu3.setStringPainted(true);      jindu4.setStringPainted(true);              //���ý�������ʾ������ʾ
threadA=new Thread(new MyThread(jindu1));                                       //�½�����A
threadB=new Thread(new MyThread(jindu2));                                       //�½�����B
threadC=new Thread(new MyThread(jindu3));                                       //�½�����C
threadD=new Thread(new MyThread(jindu4));                                       //�½�����D
setPriority("threadA", 5, threadA);                                             //���ý���A�����ȶ�
setPriority("threadB", 5, threadB);                                             //���ý���B�����ȶ�
setPriority("threadC", 4, threadC);                                             //���ý���C�����ȶ�
setPriority("threadD", 3, threadD);                                             //���ý���D�����ȶ�
}
    
public void setPriority(String threadname, int priority, Thread t){             //���ý������ȼ����Դ�����
t.setPriority(priority);                                                        //�����̶߳����setPriority()�������������ȼ�������1��10
t.setName(threadname);                                                          //�����̶߳����setName(���������������̵߳�����
t.start();                                                                      //�����߳�start
}

public static void main(String[] args)      {       init(new main(), 320, 240);     }    //��main���Ժ���

private final class MyThread implements Runnable {                                       //�߳�Runnable����
private final JProgressBar jindu;                                                        //����һ������������
int count=0;                                                                             //���������count=0
private MyThread(JProgressBar jindu)    {   this.jindu=jindu;   }                        //����紫��Ľ�������ֵ�����صĽ�����
public void run(){                                                                       //�̶���run()����
while(true){                                                                             //����ѭ��
    jindu.setValue(count+=10);                                                           //ʹ�ý������߶�
    try {   Thread.sleep(1000);   } catch (InterruptedException e) {   System.out.println("��ǰ�̱߳��ж�");    }  //��������1000ms
}
}
}

public static void init(JFrame frame, int width, int height) {                  //�����͵ķ�����
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);                                  //���������ڵĹرշ�ʽ
frame.setSize(width,height);                                                    //���������ڵĴ�С
frame.setVisible(true);                                                         //���������ڿɼ�
frame.setLayout(new FlowLayout());                                              //���ô������ɲ��ֹ���
}

}

//�ڱ��������������ʱ�����ڻ��������ٶȺܿ����Բ�û�г�������˵�����ȼ��Ⱥ�����⣬�������ۿ�����
//�����һ��ʹ������ķ�ʽ������Runnable