
import java.util.*;                                                                       //�����������;�ӻ���
class main {                                                                              //����
public static void main(String[] args) {                                                  //��main���Ժ���
        
ArrayList<Integer> a=new ArrayList<>();                                                   //����һ��int���͵�ArrayList 
a.add(1);                                                                                 //��1�ӵ�ArrayList����ȥ
for(int i=0; i<a.size(); i++)       System.out.println("��ȡArrayList������ֵ�� "+a.get(i));//ѭ���������������ݲ����

HashMap<Integer,String> m=new HashMap<>();                                                //����һ��HashMap������Ϊ����key�� ����String
for(int i=0; i<5; i++)    m.put(i, "��Ա "+i);                                             //ѭ������HashMap��������ӳ���ϵ
for(int i=0; i<m.size(); i++)       System.out.println("��ȡHashMap��ֵ�� "+m.get(i));      //ѭ���������������ݲ����
        
Vector<String> v=new Vector<>();                                                           //����һ��Vector�������趨����ΪString
for(int i=0; i<5; i++)          v.addElement("��Ա"+i);                                    //ѭ������HashMap���������ַ���
for(int i=0; i<v.size(); i++)  System.out.println("��ȡVector������ֵ�� "+v.get(i));        //ѭ���������������ݲ����

}
}

//��һ�¶Է��͵ĺô�����;���˸�����˽⣬ �����ƺ��������͵Ķ�������ʵ����ĳ����ͬ�Ľ�ڣ�����������Map��List��Vector��������size(�����ش������ݵ��������ȣ�get��key������ֵ��add��removeʲô��