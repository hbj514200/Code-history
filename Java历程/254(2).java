import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class main extends JFrame{                                                //�����ڼ̳�JFrame
private static final long serialVersionUID = 1L;                                 //
private String[] contents={"�б�1","�б�2","�б�3","�б�4","�б�5"};               //����ѡ������
private JComboBox<String> jc=new JComboBox<>();                                  //����һ��������Ŀ
private JButton jb=new JButton("�ύ");                                          //����һ����ťjb
int count=0;                                                                    //

public main(){                                                                  //��������
setSize(320,100);
setVisible(true);
jc.setSize(100,50);
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);                     //���ô��ڹرշ�ʽ
Container cp=getContentPane();                                                  //��ȡһ����������
cp.setLayout(new GridLayout(1,2));                                           //���ô����Զ����ֹ���
cp.add(jc);    cp.add(jb);                                                      //��������������������
jb.addActionListener(new ActionListener(){                                      //Ϊ��ťjb��ӵ�������¼�
public void actionPerformed(ActionEvent arg0) {                                 //�����¼��̶���Ӧ����
if(count<contents.length){                                                      
jc.addItem(contents[count++]);                                                  //�����ԭ����addItem������
}
}
});	
}

public static void main(String[] args)   {   new main();   }                    //������main����

}
