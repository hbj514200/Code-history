import java.util.*;
class main {

public static void main(String[] args) {
ArrayList<Character> list=new ArrayList<>();
list.add('A');  list.add('A');   list.add('a');  list.add('C');   list.add('c');   list.add('a');
Iterator<Character> it=list.iterator();
while(it.hasNext())  System.out.println(it.next());
}
    
}
ArrayList可以添加重复元素
treeSet可以接受相同元素，但是有重复的话只保留一个，和高中数学集合一样