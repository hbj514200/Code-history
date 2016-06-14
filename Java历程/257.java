import java.util.*;                          //全名utility， 意为公共的，多用途的，杂货工具包
class main {

public static void main(String[] arg){       //主函数
ArrayList<String> list=new ArrayList<>();   
list.add("a");		list.add("b");		list.add("c");    //向list投入三个字符串
Iterator<String> it=list.iterator();                  //获取一个叫it的Sring类型迭代器， 调用list的iterator方法。  
while(it.hasNext()) 
{   String str=(String)it.next();   System.out.println(str);   }   //如果迭代器it的方法Next还有东西可以读取
}

}

//看来迭代器的hasNext方法返回一个boolean值表示是否还有下一读取对象。
//迭代器的next方法返回一个数据(应该要使用强制转换)。