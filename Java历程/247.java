import java.awt.*;
import javax.swing.*;
class main extends JFrame{                         		//����̳�JFrame

public main() {                                          //�����ڵķ���
Container cp=getContentPane();                           //��ȡһ����������
cp.setLayout(new GridLayout(1,2));                       //��������12���ֹ���������
JLabel mianban=new JLabel("�����Ҳ�ѡ������Ϊ�᳤�ж�˧");//����������ʾ��ǩ
cp.add(mianban);                                          //�����ֱ�ǩ��������
JList<String> jl=new JList<>(new MyListModel());         //����һ���ַ�������JList�б��(jl)�� ��������Լ���MyListModel�� 
JScrollPane js=new JScrollPane(jl);            				//����һ��JS����С���(jl)
js.setBounds(10,10,100,100);                             //����JS����С���Ĵ�С
cp.add(js);                                              //��JS����С�������������
setVisible(true);                                        //���ô���ɼ�
setSize(480,140);                                        //���ô����С
setTitle("����ѧԺ�����ղ�ϵͳ");                        //���ô��ڱ�������
}

public static void main(String[] arg)		{   new main();   }    //�����õ���main����

}

//����һ��MyListModel��̳г����AbstractListModelģ�͡�
class MyListModel extends AbstractListModel<String> {
private String[] contents={"ͦ˧��","��˧��","�ǳ�˧","�ҵ���������","�������žžž","�������������!"};   //�����б���ѡ���ַ�������

public String getElementAt(int x)   {   if(x<contents.length) return contents[x++];  else return null;  } 
public int getSize()                {   return contents.length;  }  
//���������ǹ̶�����������ķ���ָ���ַ�����ע��x++�� ����ķ���ѡ�����鳤�ȡ�

}