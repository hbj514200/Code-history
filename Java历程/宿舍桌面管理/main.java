import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {
JDesktopPane desktopPane=null;                                                  //JdesktopPane������������
JLabel backJLabel=null;                                                         //�������

JInternalFrame hzbFrame=null;                                                   //hzb�ڲ��������       
JInternalFrame cqhFrame=null;                                                   //cqh�ڲ��������  
JInternalFrame cgcFrame=null;                                                   //cgc�ڲ��������  
JInternalFrame sheFrame=null;                                                   //she�ڲ��������  

JButton hzb=new JButton("�����");                                               //�½��� ��ť ����
JButton cqh=new JButton("���պ�");
JButton cgc=new JButton("�¹��");
JButton she=new JButton("�� ��");

ImageIcon icon, icon1, icon2, icon3, icon4;                                           //�ĸ��˵� ͼ�����

public void tupian(){
    icon =new ImageIcon(main.class.getResource("img.jpg"));                                //����
    icon1=new ImageIcon(main.class.getResource("zb.jpg"));                      //���� icon Ϊ����ͼƬ��   ��main()����
    icon2=new ImageIcon(main.class.getResource("qh.jpg"));
    icon3=new ImageIcon(main.class.getResource("gc.jpg"));
    icon4=new ImageIcon(main.class.getResource("she.jpg"));
}                                                                 

public void dongzuo(){
    hzb.addActionListener(new BAlistener(hzbFrame, "����� ���ϴ���"));           //�ĸ���ť����˱��صĶ����¼��ࡣ
    cqh.addActionListener(new BAlistener(cqhFrame, "���պ� ���ϴ���"));
    cgc.addActionListener(new BAlistener(cgcFrame, "�¹�� ���ϴ���"));
    she.addActionListener(new BAlistener(cgcFrame, "�� �� ���ϴ���"));
}

public static void main(String[] args)      {           new main().setVisible(true);        }

public main(){
    setSize(1290, 870);
    setTitle("D1-741 �����Ա ���� ����ϵͳ");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    this.dongzuo();                                                             //��Ӱ�ť����
    this.tupian();                                                              //ͼƬ��Դ ʵ����icon
    
    desktopPane=new JDesktopPane();                                             //������һ���յ��������
    getContentPane().add(desktopPane, BorderLayout.CENTER);                     //�����������뵽���ڽ�����м�
    
    backJLabel=new JLabel();                                                    //�����ײ�JLabel��ǩ
    backJLabel.setIcon(icon);                                                   //���õײ��ǩ��ͼƬsetIcon��
    desktopPane.add(backJLabel, new Integer(Integer.MIN_VALUE));                //�ѵײ��ǩJLabel�õ׷��á�   �̶����
    backJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());      //���õײ��ǩ��λ�úʹ�С�����ֽͼƬ�ȴ�
    backJLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if(e.MOUSE_CLICKED==500)   JOptionPane.showMessageDialog(null, "������ϣ���Լ��Ǹ�������\n\n˼άҲ�������ԵĲ�����\n�ڴ�˼���������������֪ʵ��ı��ʣ�ȴҲ��ı������顣\n\nҲ����ʫ�ʸ��м�ֵ��\n����һ��, ��ϧ���Ǹ�������û��ʲôս�����������ױ�KO��\n\n     �� ���� �ɲ��������м��ҵ�һ��ƽ���\n       �ǻ��ֲ�ʧ��Ȥ��", "��������", JOptionPane.PLAIN_MESSAGE);
        }
    });
    
    JPanel mianban=new JPanel(new FlowLayout());                                //����һ�������İ�ť��壨Flow���ֹ���
    getContentPane().add(mianban, BorderLayout.NORTH);                          //�Ѱ�ť�����뵽���ڽ���Ķ���
    mianban.add(hzb);
    mianban.add(cqh);
    mianban.add(cgc);
    mianban.add(she);                                                           //��4����ť�ӵ������
    
}
    
public class BAlistener implements ActionListener{                              //�Զ���Ķ����¼��࣬�̳�ActionListener
    JInternalFrame inFrame;                                                         //����һ���ڲ����ڶ���  JInternalFrame
    String title;                                                                   //����title�����ַ���
    
    public BAlistener(JInternalFrame inFrame, String title){                        //���췽���������������� �ڲ����ڡ� ���ڱ���
        this.inFrame=inFrame;                                                           //�����β�
        this.title=title;                                                               //�����β�
    }
    
    public void actionPerformed(ActionEvent e){                                     //�̶�������Ӧ����
        if(inFrame==null||inFrame.isClosed()){                                        //�������ڲ�������null�ģ����Ѿ�������
            int num=0;                                                                        //(��ť��Դ��¼)
            JInternalFrame[] allFrames=desktopPane.getAllFrames();                      //����getAllFrame������ȡĿǰ������������е�С���ڶ��󣬣�ʹ������нӣ�
            int titleBarHight=30*allFrames.length;                                      //������titleBarHight��30�����ڲ����ڳ���
            int x=10+titleBarHight,     y=x;                                            //����x��ֵ��y��ֵ
            
            if(e.getSource()==hzb)    num=1;
            if(e.getSource()==cqh)    num=2;
            if(e.getSource()==cgc)    num=3;
            if(e.getSource()==she)    num=4;
            
            inFrame=new InternalFrame(title, num);                                 //ʵ����һ���µ��ڲ����ڽ�����title���ַ���
            inFrame.setBounds(x, y, 500, 360);                                    //��������λ�úʹ�С
            desktopPane.add(inFrame);                                                   //�����������ӵ����������ȥ
            inFrame.setVisible(true);                                                   //��������ڲ����ڿɼ�
        }
        try {                                                                      //���ڲ���Ҳ�з��գ���������
            inFrame.setSelected(true);                                              //��������½����ڲ�����Ϊ��ѡ��״̬
        } catch (Exception e1) {            e1.printStackTrace();                    //�����׳��쳣
        }
    }

}

private class InternalFrame extends JInternalFrame {                            //�Զ����ڲ��࣬ �ڲ����ڣ��̳���JInternalFrame
    public InternalFrame(String title, int num){                                        //���췽�����������title
        setTitle(title);                                                                //�����ڲ����ڵı�������
        setResizable(false);                                                             //�����ڲ����ڲ����Ե�����С
        setClosable(true);                                                              //�����ڲ����ڿ��Ա��ر�
        setMaximizable(true);                                                           //�����ڲ����ڿ��Ա����
        
        JLabel mianban=new JLabel();
        if(num==1)   mianban.setIcon(icon1);
        if(num==2)   mianban.setIcon(icon2);
        if(num==3)   mianban.setIcon(icon3);
        if(num==4)   mianban.setIcon(icon4);
        add(mianban);
    }
}
    
}

//ע�� ������ʵ����Ҫ����ͼ��img.jpg�봰�ڵȴ�ı�ֽ��     img2.bmpһ������Сͼ�꣬��Ҫ̫��