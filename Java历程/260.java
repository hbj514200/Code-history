import java.util.*;
class main implements Comparable<Object> {                                //TreeSet�࣬ʵ��Object���͵�Comarable�ӿ�
String name;   long id;                                                   //�����󴢴��ʵ������

public main(String name, long id)     {   this.name = name;   this.id = id;   }       //д���ⲿ������
public int compareTo(Object o)        {   main upstu = (main) o;   int result=id>upstu.id ? 1:(id==upstu.id ? 0:-1);  return result;  }   //�̶��Ķ�����TreeSet��С�������У� id��
public long getId()                   {   return id;          }        //��ȡidֵ
public void setId(long id)            {   this.id = id;       }        //��дidֵ
public String getName()               {   return name;        }        //��ȡnameֵ

public static void main(String[] args) {                               //��main���Ժ���
main stu1 = new main("1ͬѧ", 01011);                                  //�����������һ��
main stu2 = new main("2ͬѧ", 01021);                                  //��������������
main stu3 = new main("3ͬѧ", 01051);                                  //���������������
main stu4 = new main("4ͬѧ", 01012);                                  //������������ĺ�
TreeSet<main> tree = new TreeSet<>();                                  //����һ������tree
tree.add(stu1);     tree.add(stu2);     tree.add(stu3);     tree.add(stu4);    //���ĸ�������������ʹ��add������
Iterator<main> it = tree.iterator();                                           //��iterator�õ���ͨ������
System.out.println("Set�����е�����Ԫ�أ�");                                     
while (it.hasNext()) {   main stu = (main) it.next();   System.out.println(stu.getId() + " " + stu.getName());    }  //whileѭ�����ϵ�����hasNext()������ �ڲ���it.next(�����ء�
it = tree.headSet(stu2).iterator();                   //��iterator�õ�ǰ������� stu2ǰ���(����stu2)
System.out.println("��ȡǰ�沿�ֵļ��ϣ�");
while (it.hasNext()) {   main stu = (main) it.next();   System.out.println(stu.getId() + " " + stu.getName());    }   //whileѭ�����ϵ�����hasNext()������ �ڲ���it.next(�����ء�
it = tree.subSet(stu2, stu3).iterator();
System.out.println("��ȡ�м䲿�ֵļ���");               //��iterator�õ���������� stu2��stu3֮���(������stu2������stu3������)
while (it.hasNext()) {   main stu = (main) it.next();   System.out.println(stu.getId() + " " + stu.getName());    }   //whileѭ�����ϵ�����hasNext()������ �ڲ���it.next(�����ء�
}

}
