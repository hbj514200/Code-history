import java.awt.*;
import javax.swing.*;
class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {        //�½�����ģ����Ŀ��
String selecteditem="��ϯ���ʦ";                                                             //��ѡ��Ŀ
String[] test={"��ϯ���ʦ","��ϯִ�й�","������ɶ�"};                                         //ѡ���ַ����б�����

public int getSize()                        {   return test.length;        }                 //�̶�����������ѡ�����鳤��
public void setSelectedItem(Object item)    {   selecteditem=(String)item; }                 //�趨ѡ��ѡ��
public String getSelectedItem()             {   return selecteditem;       }                 //��ȡĿǰ��ѡ��
public String getElementAt(int index)       {   return test[index];        }                 //��������ÿ����Ŀ

}


class main extends JFrame {                                   //������JFrame��

public main(){
Container cp=getContentPane();                               //��ȡһ����������
cp.setLayout(new BorderLayout());                            //�����ɴ��ڱ�ݹ���������
JComboBox<String> jc=new JComboBox<>(new MyComboBox());      //����JComboBox������Ŀ
JCheckBox jc1=new JCheckBox("��");                       //����jc1��ѡ��
JCheckBox jc2=new JCheckBox("Ů");                       //����jc2��ѡ��
JButton jb1=new JButton("ȷ��");   JButton jb2=new JButton("ȡ��");    jb1.setBounds(10,10,100,100);   jb2.setBounds(10,10,100,100);    //�½��������ְ�ť�����ô�С
JPanel jp2=new JPanel();    JPanel jp3=new JPanel();       //�½�����JP�̶����
jp2.setLayout(new FlowLayout());    jp3.setLayout(new FlowLayout());    //�趨���̶������Զ����ֹ�����
jp2.add(jc1);  jp2.add(jc2);   jp3.add(jb1);  jp3.add(jb2);             //������������
cp.add(jc,BorderLayout.NORTH);   cp.add(jp2,BorderLayout.CENTER);   cp.add(jp3,BorderLayout.SOUTH);   //��尴˳�����������
setSize(240,140);  setVisible(true);  
}

public static void main(String[] arg)    {   new main();    }

}
