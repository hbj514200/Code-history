import java.util.*;
class main {
    
public static void main(String[] args) {                                        //��main���Ժ���
Map<String,String> map=new HashMap<>();                                         //�½�һ���ַ���hashmap
map.put("01", "1��ͬѧ");            map.put("02", "2��ͬѧ");                   //����2���������
Set<String> set=map.keySet();                                                   //����Map��Set���󼯺ϣ��ַ������ͣ�����key��
Iterator<String> it=set.iterator();                                             //��set��iterator�����ַ�����������
System.out.println("Key�����е�Ԫ��");
while(it.hasNext())       System.out.println(it.next());                        //����hasNext���������� it.next()�����ַ���
map.remove("01");
Collection<String> coll=map.values();                                           //����Collection���ϣ� ����Valuse
it=coll.iterator();                                                             //��coll��iterator�����ַ����������� 
System.out.println("values�����е�Ԫ��"); 
while(it.hasNext())       System.out.println(it.next());                        //����hasNext���������� it.next()�����ַ���
}
    
}

//HahMap����ʵ��ӳ�䣬����һ���ص㷽��remove(key)���Ի���ɾ��keyָ���Ķ���Ҳ����ֱ���������