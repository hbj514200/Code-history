import java.awt.*;
import javax.swing.*;  
class main extends JFrame {                      //���Ǽ̳�JFrame��ġ�

public main() {
Container c=getContentPane();                    //��ȡ��������
JTextArea ta=new JTextArea(20,50);               //����һ��JTextArea��������ta��
JScrollPane sp=new JScrollPane(ta);              //��������������JScrollPane��壬����ʱֱ�Ӱ�ta���롣
c.add(sp);                                       //��JScrollPane���sp���뵽���������С�
setTitle("�������������ֱ༭��");                //���������ڵı������֡�
setVisible(true);                                //��ʾ������
setSize(480,320);                                //���������ڵĴ�С
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);          //Ӧ��������Ϊ�رմ���ʱʲôҲ���ɡ�
}

public static void main(String[] arg)  {  new main();  }

}