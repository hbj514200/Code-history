import java.util.*;
class Emp {                                                                           //设定实际储存内容
private String id, name;

public Emp(String id,String name)     {    this.id=id;    this.name = name;     }   //传入储存内容
public String getid()                 {    return id;          }                    //读取id值
public void setid(String id)          {    this.id=id;         }                    //设定id值
public String getname()               {    return name;        }                    //读取name值
public void setname(String name)      {    this.name = name;   }                    //设定name值
	
}

class main {                                               //创建类main

public static void main(String[] arg) {                    //主方法
Map<String,String> map=new HashMap<>();                    //创建一个HashMap对象
Emp emp= new Emp("001", "张三");                            //创建四个Emp储存对象
Emp emp2=new Emp("005", "李四");
Emp emp3=new Emp("004", "王一");
Emp emp4=new Emp("015", "艾斯比");
map.put(emp. getid(), emp.getname() );                        //在HashMap里创建四个映射关系，即是添加
map.put(emp2.getid(), emp2.getname()); 
map.put(emp3.getid(), emp3.getname());
map.put(emp4.getid(), emp4.getname());
map.remove("015");                                            //核心删除语句remove()方法
Set<String> set = map.keySet();                              // 获取Map集合中的key对象集合set
Iterator<String> it = set.iterator();                        //获得set的迭代器
System.out.println("HashMap类实现的Map集合，无序：");           
while (it.hasNext()) {         
String str=it.next();    String name=map.get(str);          //利用key的全集遍历HashMap集合中的所有Valuse
System.out.println(str + " " + name);
}

}

}

//看来TreeMap和HashMap是一眼的东西，只是内部实现方式不太一样， 一个排序一个哈希，HashMap的效率稍高到但是无序， Hash可以传入null。都是互异性的集合。