import javax.swing.*;
import java.awt.*;

class main extends JFrame {
private int OVAL_WIDTH=80;                                                      //�趨Բ�Ŀ��
private int OVAL_HEIGHT=80;                                                     //�趨Բ�ĸ߶�

public main(){                                                                  //���췽��
    super();                                                                    //���ø���Ĺ��췽��
    initalize();                                                               //����������Զ��庯����  ���Ǹ������ǡ���ʼ����
}

public static void main(String[] args)      {       new main();     }          

private void initalize(){                                                       //��ʼ������
    setSize(300,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setContentPane(new DrawPanel());                                            //���ô������Ϊ�Զ���Ļ�ͼ��塣  ��Ҫ
    setTitle("�廷��ͼ");
    setVisible(true);
}
    
class DrawPanel extends JPanel {                                                //�ڲ���̳�JPanelʵ�ֻ�ͼ���
    public void paint(Graphics g){                                              //��д�˹̶�����paint������δ֪
        super.paint(g);                                                         //���ø��๹�췽��������δ֪g
        g.drawOval(10 , 10, OVAL_WIDTH, OVAL_HEIGHT);                            //Բ�λ�ͼ
        g.drawOval(80, 10, OVAL_WIDTH, OVAL_HEIGHT);
        g.drawOval(150, 10, OVAL_WIDTH, OVAL_HEIGHT);
        g.drawOval(50, 70, OVAL_WIDTH, OVAL_HEIGHT);
        g.drawOval(120, 70, OVAL_WIDTH, OVAL_HEIGHT);
    }
}

}