import java.util.*;                                     //看来这个多用途包是List必须的
class main<T extends List> {                            //泛型主类， 要求泛型对象必须实现List接口，即受其限制
public static void main(String[] args) {                //主main测试函数
             
main<ArrayList> ar=new main<>();                        //实例化main对象，设定泛型为ArrayList
main<LinkedList> lr=new main<>();                       //实例化main对象，设定泛型为LinkedList
    
}
}

//无法设定泛型为HashMap，因为Map类的东西并没有按要求实现List接口， 这为同一规范提供了方便