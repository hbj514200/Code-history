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
Emp emp= new Emp("001", "����");                            //�����ĸ�Emp�������
Emp emp2=new Emp("005", "����");
Emp emp3=new Emp("004", "��һ");
Emp emp4=new Emp("015", "��˹��");
map.put(emp. getid(), emp.getname() );                        //��HashMap�ﴴ���ĸ�ӳ���ϵ���������
map.put(emp2.getid(), emp2.getname()); 
map.put(emp3.getid(), emp3.getname());
map.put(emp4.getid(), emp4.getname());
map.remove("015");                                            //����ɾ�����remove()����
Set<String> set = map.keySet();                              // ��ȡMap�����е�key���󼯺�set
Iterator<String> it = set.iterator();                        //���set�ĵ�����
System.out.println("HashMap��ʵ�ֵ�Map���ϣ�����");           
while (it.hasNext()) {         
String str=it.next();    String name=map.get(str);          //����key��ȫ������HashMap�����е�����Valuse
System.out.println(str + " " + name);
}

}

}

//����TreeMap��HashMap��һ�۵Ķ�����ֻ���ڲ�ʵ�ַ�ʽ��̫һ���� һ������һ����ϣ��HashMap��Ч���Ըߵ��������� Hash���Դ���null�����ǻ����Եļ��ϡ�