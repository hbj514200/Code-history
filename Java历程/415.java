import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

class main extends JFrame {
JDesktopPane desktopPane=null;                                                  //JdesktopPane������������
JInternalFrame plnFrame=null;                                                   //���¹����ڲ��������       
JInternalFrame rlnFrame=null;                                                   //���׹����ڲ��������  
JInternalFrame tlnFrame=null;                                                   //���������ڲ��������  
JButton renshi=new JButton("���¹���");
JButton zhangtao=new JButton("���׹���");
JButton daiyu=new JButton("��������");

public static void main(String[] args)      {           new main().setVisible(true);        }

public main(){
    setTitle("С�����¹���ϵͳ");
    setSize(1280,800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    desktopPane=new JDesktopPane();                                             //������һ���յ��������
    desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);                        //��������������ק��ʽ��  ������קʱ�Ƿ�ʵʱ��ʾ���ڣ��� Ŀ��drag���϶�����˼
    getContentPane().add(desktopPane, BorderLayout.CENTER);                         //�����������뵽���ڽ�����м�
    JLabel backJLabel=new JLabel();                                             //�����ײ�JLabel��ǩ
    ImageIcon icon=new ImageIcon(main.class.getResource("img.jpg"));                //����ImageIcon���󡣣��������ı�ֽ��
    backJLabel.setIcon(icon);                                                       //���õײ��ǩ��ͼƬsetIcon��
    backJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());          //���õײ��ǩ��λ�úʹ�С�����ֽͼƬ�ȴ�
    desktopPane.add(backJLabel, new Integer(Integer.MIN_VALUE));                //�ѵײ��ǩJLabel�õ׷��á�   �̶����
    JPanel mianban=new JPanel(new FlowLayout());                                //����һ�������İ�ť��壨Flow���ֹ���
    mianban.add(renshi);       mianban.add(zhangtao);       mianban.add(daiyu); //��������ť�ӵ������
    getContentPane().add(mianban, BorderLayout.NORTH);                          //�Ѱ�ť�����뵽���ڽ���Ķ���
    
    renshi.addActionListener(new BAlistener(plnFrame, "���¹�����"));          //������ť����˱��صĶ����¼��ࡣ
    zhangtao.addActionListener(new BAlistener(rlnFrame, "���׹�����"));
    daiyu.addActionListener(new BAlistener(tlnFrame, "����������"));
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
            JInternalFrame[] allFrames=desktopPane.getAllFrames();                      //����getAllFrame������ȡĿǰ������������е�С���ڶ��󣬣�ʹ������нӣ�
            int titleBarHight=30*allFrames.length;                                      //������titleBarHight��30�����ڲ����ڳ���
            int x=10+titleBarHight,     y=x;                                            //����x��ֵ��y��ֵ
            int width=250, height=180;                                                  //������width��hight�� ��Ⱥ͸߶�
            inFrame=new InternalFrame(title);                                           //ʵ����һ���µ��ڲ����ڽ�����title���ַ���
            inFrame.setBounds(x,y,width,height);                                        //��������λ�úʹ�С
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
    public InternalFrame(String title){                                             //���췽�����������title
        setTitle(title);                                                                //�����ڲ����ڵı�������
        setResizable(true);                                                             //�����ڲ����ڿ������ɵ�����С
        setClosable(true);                                                              //�����ڲ����ڿ��Ա��ر�
        setIconifiable(true);                                                           //�����������ڲ������Ƿ���������ͼ��
        setMaximizable(true);                                                           //�����ڲ����ڿ��Ա����
        ImageIcon icon=new ImageIcon(main.class.getResource("img2.bmp"));               //��ʵ����һ��ͼ�����img2
        setFrameIcon(icon);                                                             //����setFrameIcon���������ڲ����ڵĴ���ͼ��
    }
}
    
}

//ע�� ������ʵ����Ҫ����ͼ��img.jpg�봰�ڵȴ�ı�ֽ��     img2.bmpһ������Сͼ�꣬��Ҫ̫��