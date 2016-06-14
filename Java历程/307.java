
import static java.lang.System.out;                                                               //系统输出包
class main {                                                                                      //主类
    
enum Constants2  {                                                                                //创建一个Constanst2的枚举类型
Constants_A("我是枚举成员A"),Constants_B("我是枚举成员B"),Constants_C("我是枚举成员C"),Constants_D(3);//定义四个枚举成员，有的带参数。
private String description;        private int i=4;                                               //定义描述私有的字符串和整数i
private Constants2()                    {                                      }                  //空的无参数构造方法
private Constants2(String description)  {   this.description=description;      }                  //带字符串参数的构造方法，设定描述字符串
private Constants2(int i)               {   this();i=this.i+i;                 }                  //带整数i的构造方法，设定i的值。
public String getdescription()          {   return description;                }                  //返回描述字符串
public int getI()                       {   return i;                          }                  //返回整数i
}

public static void main(String[] args) {                                                          //主main测试函数
for(int i=0; i<Constants2.values().length; i++)                                                   //循环，遍历Constants2枚举类型中所有的成员
out.print(Constants2.values()[i]+"调用getDescription()描述方法为： "+Constants2.values()[i].getdescription()+"\n");     //调用枚举成员的getDescription()方法读取他们的描述字符串并输出
out.print(Constants2.valueOf("Constants_D")+"调用getDescription()描述方法为： "+Constants2.valueOf("Constants_D").getdescription()+"\n");//调用枚举成员D的getDescription()方法读取他的描述字符串并输出
}
    
} 

//经过这一个代码，发现枚举类型好像功能较为强大，似乎是一种高级结构体，因为自带方法。
//还有，似乎对于万物皆对象的Java来说， 每个枚举成员好都是一个对象，因为他们都有自带的方法。（估计是继承了某个父类来的）