import java.util.*;                          //ȫ��utility�� ��Ϊ�����ģ�����;�ģ��ӻ����߰�
class main {

public static void main(String[] arg){       //������
ArrayList<String> list=new ArrayList<>();   
list.add("a");		list.add("b");		list.add("c");    //��listͶ�������ַ���
Iterator<String> it=list.iterator();                  //��ȡһ����it��Sring���͵������� ����list��iterator������  
while(it.hasNext()) 
{   String str=(String)it.next();   System.out.println(str);   }   //���������it�ķ���Next���ж������Զ�ȡ
}

}

//������������hasNext��������һ��booleanֵ��ʾ�Ƿ�����һ��ȡ����
//��������next��������һ������(Ӧ��Ҫʹ��ǿ��ת��)��