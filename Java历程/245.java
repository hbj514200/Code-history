import java.awt.*;
import javax.swing.*;
class main extends JFrame {                                //�̳�JFrame
JComboBox<String> jc=new JComboBox<>(new MyComboBox());    //����String������ģ��JComboBox(jc)����������Դ���MyComboBox��
JLabel jl=new JLabel("�����᳤��");                        //��ʾ������ʾ��ǩ

public main() {                                            //��Ҫ����
Container cp=getContentPane();                             //��ȡһ����������
cp.setLayout(new FlowLayout());                            //�����ڷ����Զ�����������
cp.add(jl);		cp.add(jc);                                 //�ѱ�ǩ������JConboboxģ�ͼ�������
setVisible(true);                                          //ʹ����ɼ�
setSize(320,240);                                          //�����������С
setTitle("����ѧԺ�ʾ����");                              //���������ڵı�������
}

public static void main(String[] arg)  {  new main();   }  //�����õ�main����

}

//���洴����һ���̳��ų����б�ģ����AbstractListModel��ComboBox������ģ���࣬ͬʱҪ��ʵ��ComboBoxModel(����ģ��ͨ�ñ�׼�ӿ�)�Ľӿڡ�

class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {
String selecteditem=null;                   //����ΪĬ����û��ѡ�е�ѡ�(���ǹ̶�������)
String[] test={"˧��","����","ů��","�Ʊ�̥@_@"};     //�ַ����������ڱ�ʾÿ��ѡ��

public String getElementAt(int index)       {  return test[index]; 		  }   //�ӿڹ̶������� ���صڼ�����ѡ�����֡�
public int    getSize()                     {  return test.length;         }  //�ӿڹ̶������� ����ѡ������ĳ��ȡ�
public void   setSelectedItem(Object item)  {  selecteditem=(String)item;  }  //�ӿڹ̶������� ����һ�����ݣ��趨ѡ�еı�����
public String getSelectedItem()             {  return selecteditem;        }  //�ӿڹ̶������� ����Ŀǰ��ѡ��ѡ�

}