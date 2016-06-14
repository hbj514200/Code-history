import java.util.*;
class main {
    
public static void main(String[] args) {                                        //主main测试函数
Map<String,String> map=new HashMap<>();                                         //新建一个字符串hashmap
map.put("01", "1号同学");            map.put("02", "2号同学");                   //创建2个储存对象
Set<String> set=map.keySet();                                                   //构建Map的Set对象集合，字符串类型，关于key。
Iterator<String> it=set.iterator();                                             //从set的iterator创建字符串迭代器。
System.out.println("Key集合中的元素");
while(it.hasNext())       System.out.println(it.next());                        //利用hasNext方法遍历。 it.next()返回字符串
map.remove("01");
Collection<String> coll=map.values();                                           //创建Collection集合， 关于Valuse
it=coll.iterator();                                                             //从coll的iterator创建字符串迭代器。 
System.out.println("values集合中的元素"); 
while(it.hasNext())       System.out.println(it.next());                        //利用hasNext方法遍历。 it.next()返回字符串
}
    
}

//HahMap可以实现映射，还有一个重点方法remove(key)可以还是删除key指定的对象，也可以直接输入对象