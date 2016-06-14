
import java.util.*;                                                                       //又是这个多用途杂货包
class main {                                                                              //主类
public static void main(String[] args) {                                                  //主main测试函数
        
ArrayList<Integer> a=new ArrayList<>();                                                   //创建一个int类型的ArrayList 
a.add(1);                                                                                 //把1加到ArrayList里面去
for(int i=0; i<a.size(); i++)       System.out.println("获取ArrayList容器的值： "+a.get(i));//循环，遍历所有内容并输出

HashMap<Integer,String> m=new HashMap<>();                                                //创建一个HashMap，定义为整数key， 数据String
for(int i=0; i<5; i++)    m.put(i, "成员 "+i);                                             //循环，向HashMap中添加五个映射关系
for(int i=0; i<m.size(); i++)       System.out.println("获取HashMap的值： "+m.get(i));      //循环，遍历所有内容并输出
        
Vector<String> v=new Vector<>();                                                           //创建一个Vector容器并设定泛型为String
for(int i=0; i<5; i++)          v.addElement("成员"+i);                                    //循环，向HashMap中添加五个字符串
for(int i=0; i<v.size(); i++)  System.out.println("获取Vector容器的值： "+v.get(i));        //循环，遍历所有内容并输出

}
}

//这一下对泛型的好处和用途有了更深的了解， 还有似乎容器类型的东西好像实现了某个共同的借口，很明显他们Map和List和Vector容器都有size(）返回储存数据的数量长度，get（key）返回值，add和remove什么的