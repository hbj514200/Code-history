import java.awt.*;                                     
import javax.swing.*;
import java.awt.event.*;
class main extends JFrame {                                    //�����ڼ̳�JFrame��Ϊ����
private JButton jb=new JButton("�᳤˧��˧�Ĵ�");            //����һ����Ա��̬�İ�ťjb��
   
public main(){                                                //����      
Container cp=getContentPane();                                //��ȡһ����������
setSize(550,320);   setTitle("�ڲ����¼�������Դ���");   setVisible(true);
setLayout(null);                                              //���ò�Ҫ�����������Ԥ
cp.add(jb);                                                   //��jb��ť�����������
jb.setBounds(10,10,150,40);                                   //����jb��ť��С
jb.addActionListener(new jbAction());                         //Ϊjb��ӱ�����¼��������
}
  
class jbAction implements ActionListener {                    //�Զ���һ���¼�����
public void actionPerformed(ActionEvent e)   {   jb.setText("��Ȼ˧��");   }   //���ݣ���ťjb�ķ�Ӧ
}

public static void main(String[] arg)   {   new main();  }    //��main���Ժ���

}