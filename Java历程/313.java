class main <T> {                                                                //一个泛型主类<T>
private T[] array;                                                              //定义成员泛型数组array

public void setT(T[] array)     {   this.array=array;   }                       //将外界传入的对象数组储存到成员数组里面，setT()
public T[] getT()               {   return array;       }                       //向外界返回本类成员对象储存的对象数组，getT()

public static void main(String[] args) {                                        //主main测试函数
main<String> a=new main<String>();                                              //创建一个main对象， 将它的泛型定位String
String[] array={"成员 1","成员 2","成员 3","成员 4","成员 5"};                     //定义一个字符串数组。
a.setT(array);                                                                  //把array传入main泛型对象
for(int i=0; i<a.getT().length; i++)       System.out.println(a.getT()[i]);     //返回为数组的getT()方法可以直接当做数组，遍历main对象并输出内容。
}
    
}

//其实泛型可以说就是一个Object的东西，只不过要求你在使用前先声明一下，这样就不用向上向下转换了。
//还有返回为数组的函数在调用似乎可以直接当做数组对象来使用，其他类型也是，挺好的，看来万物皆对象的Java的确为了这个信条付出了很多啊