import java.awt.*;
import javax.swing.*;
class main extends JFrame{

public void CreateJFrame(String title){
JFrame jf=new JFrame(title);                             //���title�ַ�������������ϵ����֣�
Container container=jf.getContentPane();                 //��ȡһ������������
container.setBackground(Color.white);
jf.setVisible(true);
jf.setSize(1200,700);
jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}

public static void main(String[] arg){
new main().CreateJFrame("���D1-741���� �᳤ר��ϵͳ");
}

}