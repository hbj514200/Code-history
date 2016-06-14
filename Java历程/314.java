import java.util.*;                                                             //这是一个多用途杂货包
class main {                                                                    //主类

public static void main(String[] args) {                                        //主main测试函数
HashMap<Integer,String> mu=new HashMap<>();                                     //创建一个泛型的HashMap， 定义为Integer和String型
for(int i=0; i<5; i++)   mu.put(i, "我是集合成员 "+i);                           //循环，向HashMap里面添加映射关系
for(int i=0; i<mu.size(); i++)      System.out.println(mu.get(i));             //HashMap对象里面有size(）方法可以返回其储存内容的数量，get(key)获取储存值
}

}

//经过这个代码实例， 泛型的作用终于有效的体现出来， 首先HashMap的映射关系在前面的文章中只介绍了使用字符串映射到字符串，而这里的话可以自由定义映射对象，方便而且功能强大。
//体现了Java的“万物皆对象”的编程思想， 也是不错诶