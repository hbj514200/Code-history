import java.awt.*;                                                                    //�����
import javax.swing.*;                                                                 //���������
class main extends JFrame {                                                           //���࣬�̳�JFrame
Thread thread;                                                                        //����һ�����߳̿յĴ��
     
public main(){                                                                        //�����ڷ���
setVisible(true);       setDefaultCloseOperation(EXIT_ON_CLOSE);    setSize(240,100); //�����ڵĻ�����������
JProgressBar jindu=new JProgressBar();                                                //�½�һ��������
jindu.setStringPainted(true);                                                         //���ý�������ʾ������ʾ
getContentPane().add(jindu);                                                          //ֱ������getContentPane������ȡ�˽����������ѽ������ӽ�ȥ
getContentPane().setLayout(new FlowLayout());                                         //�����ڲ����Զ�����
Thread thread=new Thread(new Runnable() {                                             //Ϊ���̴߳��������ݣ�ʵ��Runnable�ӿ�
    public void run() {                                                               //���̶̹߳�run����
       int count=0;                                                                   //����һ����������count
       while(true){                                                                   //����ѭ��
           try {    Thread.sleep(50);     jindu.setValue(count++);      }             //�����߳�����50ms��ͬʱ�Խ���������ֵ
           catch (Exception e) {    e.printStackTrace();    }                         //�����쳣ʱ����ʾ�쳣����ϸ��Ϣ
           if(count==100)   count=0;                                                  //�ý���������
       }
    }
});
thread.start();                                                                       //����thread������߳�
}
 
public static void main(String[] args)      {    new main();     }                    //��main���Ժ���

}