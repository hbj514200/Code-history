import java.awt.*;
import javax.swing.*;

class main extends JFrame {

public main(){
setTitle("�᳤˧�ĳ̶�Ⱥ�ڵ���");
Container c=getContentPane();                        //���ʹ�������ȡ����
setLayout(new BorderLayout());                       //ָ��ϵͳʹ�ñ߽粼�ֹ�����
c.add(BorderLayout.WEST, new JButton("�ұ�˵�Ķ�"));
c.add(BorderLayout.EAST, new JButton("���˵�ö�"));
c.add(BorderLayout.NORTH, new JButton("����˵�Ķ�"));
c.add(BorderLayout.CENTER, new JButton("�᳤��˧"));
c.add(BorderLayout.SOUTH, new JButton("����˵�Ķ�"));
setSize(550,350);
setVisible(true);
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}

public static void main(String[] arg)  {    new main();    }

}
