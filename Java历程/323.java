import java.awt.Container;                                                      //��������ֻ������awt��Container���ѡ���
import java.net.URL;                                                            //ԭ��urlֻ���õ�net�е�URL���ѡ���
import javax.swing.*;                                                           //swing�ܹ���
class main extends JFrame {                                                     //���࣬�̳�JFrame
private JLabel jl=new JLabel();                                                 //����һ��JLabel��ǩ
private static Thread t;                                                        //����һ��Thread��ʵ��t
private int count=0;                                                            //����һ��count����Ϊ0
private Container cp=getContentPane();                                          //��ȡһ����������cp

public main(){                                                                  //���캯��������
setBounds(300,200,250,100);                                                     //������С
cp.setLayout(null);                                                             //��Ҫ���ֹ�����
URL url=main.class.getResource("1.gif");                                        //��getReSource()��������ȡurl���󣬶�ȡ1.gif
Icon icon=new ImageIcon(url);                                                   //����IconΪImageIcon���ͣ�������url
jl.setIcon(icon);                                                               //��JLabel������ͼƬ�� setIcon()����  
jl.setHorizontalAlignment(SwingConstants.LEFT);                                 //�����jl��ǩ������������
jl.setBounds(10,10,200,50);                                                     //����Jl��ǩ�ĵĴ�С��λ��
jl.setOpaque(true);                                                             //���ÿռ䲻͸��
t=new Thread(new Runnable() {                                                   //�ڲ�Thread������
    public void run() {                                                         //�̶���runble�ӿڵ�run����
       while(count<=200){                                                       //ѭ������
           jl.setBounds(count,10,200,50);                                       //����jl��ǩ�Ĵ�С
           try                  {   Thread.sleep(5);    }                      //�з��յ�sleep������ ��������30ms
           catch(Exception e)   {   e.printStackTrace();   }                    //�����쳣����ʾ�쳣����ϸ��Ϣ
           count+=1;                                                            //count����ֵ����
           if(count==200)       count=0;                                        //ѭ����
       }
    }
});
t.start();                                                                      //����t��start()����
cp.add(jl);                                                                     //��jl��ǩ����cp����������  ��ô˳��������
setVisible(true);                                                               //����������ɼ�
setDefaultCloseOperation(DISPOSE_ON_CLOSE);                                     //���ùرշ�ʽ

}

public static void main(String[] args)      {   new main();    }               

    
}


//���ڴ������ڵ�����˵�� �Ѵ�������ĸ������������Ϊ��Ա�����ܺã������ÿ�ַ���������ʹ�ã�����Ҫ���ǿ���ʹ�ý�������������
//����������У� ֱ�Ӷ�����һ��Thread����ʵ�����ƺ�������Ҫʲô���صİ���Ȼ��ֱ����Threadʵ������һ��Runnable���������ڲ��࣬ͬʱʵ��run������
//�����������£� t�Ϳ��Ե���һ���߳����ˣ�Ҳ��start����  ����Ҳû�з��ִ�����������ʵ��Runnable�ӿڡ�
//ʵ���ϻ���һ�㣬�������ͨ�����ϵ��ƶ�ͼ��ʵ���ƶ��� ��һ֡һ֡�ġ�