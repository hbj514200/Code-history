import java.util.*;
class Emp {                                                                           //�趨ʵ�ʴ�������
private String id, name;

public Emp(String id,String name)     {    this.id=id;    this.name = name;     }   //���봢������
public String getid()                 {    return id;          }                    //��ȡidֵ
public void setid(String id)          {    this.id=id;         }                    //�趨idֵ
public String getname()               {    return name;        }                    //��ȡnameֵ
public void setname(String name)      {    this.name = name;   }                    //�趨nameֵ
	
}

class main {                                               //������main

public static void main(String[] arg) {                    //������
Map<String,String> map=new HashMap<>();                    //����һ��HashMap����
Emp emp= new Emp("001", "����");                            //��������Emp�������
Emp emp2=new Emp("005", "����");
Emp emp3=new Emp("004", "��һ");
map.put(emp. getid(), emp.getname() );                        //��HashMap�ﴴ������ӳ���ϵ���������
map.put(emp2.getid(), emp2.getname()); 
map.put(emp3.getid(), emp3.getname());
Set<String> set = map.keySet();                              // ��ȡMap�����е�key���󼯺�set
Iterator<String> it = set.iterator();                        //���set�ĵ�����
System.out.println("HashMap��ʵ�ֵ�Map���ϣ�����");           
while (it.hasNext()) {         
String str=it.next();    String name=map.get(str);          //����key��ȫ������HashMap�����е�����Valuse
System.out.println(str + " " + name);
}

TreeMap<String,String> treemap = new TreeMap<>();            // ����TreeMap���϶���
treemap.putAll(map);                                         //�������HahMap�����Treemap, ʹ����putall����
Iterator<String> iter = treemap.keySet().iterator();         //��ȡһ���������� ��Treemap�е�keySet��iterator�õ�
System.out.println("TreeMap��ʵ�ֵ�Map���ϣ�����������");
while (iter.hasNext()) {                                    // ����TreeMap���϶���
String str = (String) iter.next();                          // ��ȡ�����е�����key����
String name = (String) treemap.get(str);                   // ��ȡ�����е�����valuesֵ
System.out.println(str + " " + name);
}

}

}

//����TreeMap��HashMap��һ�۵Ķ�����ֻ���ڲ�ʵ�ַ�ʽ��̫һ���� һ������һ����ϣ��HashMap��Ч���Ըߵ��������� Hash���Դ���null�����ǻ����Եļ��ϡ�