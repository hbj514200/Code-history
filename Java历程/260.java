import java.util.*;
class main implements Comparable<Object> {                                //TreeSet类，实现Object类型的Comarable接口
String name;   long id;                                                   //树对象储存的实际内容

public main(String name, long id)     {   this.name = name;   this.id = id;   }       //写入外部的内容
public int compareTo(Object o)        {   main upstu = (main) o;   int result=id>upstu.id ? 1:(id==upstu.id ? 0:-1);  return result;  }   //固定的东西，TreeSet从小到大排列， id。
public long getId()                   {   return id;          }        //读取id值
public void setId(long id)            {   this.id = id;       }        //重写id值
public String getName()               {   return name;        }        //读取name值

public static void main(String[] args) {                               //主main测试函数
main stu1 = new main("1同学", 01011);                                  //创建储存对象一号
main stu2 = new main("2同学", 01021);                                  //创建储存对象二号
main stu3 = new main("3同学", 01051);                                  //创建储存对象三号
main stu4 = new main("4同学", 01012);                                  //创建储存对象四号
TreeSet<main> tree = new TreeSet<>();                                  //创建一个树叫tree
tree.add(stu1);     tree.add(stu2);     tree.add(stu3);     tree.add(stu4);    //把四个东西加入树，使用add方法。
Iterator<main> it = tree.iterator();                                           //用iterator得到普通迭代器
System.out.println("Set集合中的所有元素：");                                     
while (it.hasNext()) {   main stu = (main) it.next();   System.out.println(stu.getId() + " " + stu.getName());    }  //while循环配上迭代器hasNext()遍历， 内部用it.next(）返回。
it = tree.headSet(stu2).iterator();                   //用iterator得到前面迭代器 stu2前面的(包括stu2)
System.out.println("截取前面部分的集合：");
while (it.hasNext()) {   main stu = (main) it.next();   System.out.println(stu.getId() + " " + stu.getName());    }   //while循环配上迭代器hasNext()遍历， 内部用it.next(）返回。
it = tree.subSet(stu2, stu3).iterator();
System.out.println("截取中间部分的集合");               //用iterator得到区间迭代器 stu2和stu3之间的(不包括stu2，包括stu3，（】)
while (it.hasNext()) {   main stu = (main) it.next();   System.out.println(stu.getId() + " " + stu.getName());    }   //while循环配上迭代器hasNext()遍历， 内部用it.next(）返回。
}

}
