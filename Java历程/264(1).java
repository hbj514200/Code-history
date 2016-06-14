import java.util.*;
class main {
    
public static void main(String[] args) {
ArrayList<Integer> list=new ArrayList<>();
for(int i=1; i<=100; i++)     list.add(i);
list.remove(10);
Iterator<Integer> it=list.iterator();
while(it.hasNext())        System.out.println(it.next());
}
    
}