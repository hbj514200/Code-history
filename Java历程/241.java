import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.awt.event.*;                          //�����¼��İ���awt���档

class main extends JFrame {                       //�̳�JFrame

public main() {
URL url=main.class.getResource("anniu.jpg");      //��ȡ��ťͼƬ��url��ַ��
Icon icon=new ImageIcon(url);                     //����һ����ťͼƬ��Icon��
setLayout(new GridLayout(3,2,5,5));               //�����������3��2�У����5.
Container c=getContentPane();                     //������������
setSize(480,640);                                 //������������ڳ�ʼ��С
setTitle("�᳤���Դ���");                         //���ô��ڱ�������
setVisible(true);                                 //ʹ��������ڿɼ���
for(int i=1; i<=5; i++)                           //��Ӱ�ť����JButton������setEnabled����ť�Ƿ����
{   JButton J=new JButton("�᳤˧��˧"+i,icon);   if(i%2==0)   J.setEnabled(false);   c.add(J);   }
JButton jb=new JButton();                         //�½��հװ�ťJButton�����Դ����ַ������ֺ�iconͼƬ��
jb.setMaximumSize(new Dimension(90,30));          
jb.setIcon(icon);                                 //����JButton��ť��setIcon��������iconͼƬ���ð�ťͼƬ
jb.setHideActionText(true);                       
jb.setToolTipText("ͼƬ��ť");                    //ָ����ͼƬ��ť����ʾ���������֣�����ʵ�ʽ��治��ʾ��
jb.setBorderPainted(true);                       //���ð�ť�߿�Ҫ��ʾ��Ĭ�Ͼ���Ҫ�ģ�
jb.addActionListener(new ActionListener(){       //��Ӽ��������¼��������������š�
public void actionPerformed(ActionEvent e)       //Ӧ�����趨Ĭ�Ϲ̶����ֵĴ�������actionPerformed���������һ��ActionEvent���¼����ݶ���e��
{  JOptionPane.showMessageDialog(null,"�᳤��˧����֪���˰�");   }  //������������ʾ��Ϣ��
});
c.add(jb);                                       //��jb�������������
}

public static void main(String[] arg)  {  new main();  }  

}