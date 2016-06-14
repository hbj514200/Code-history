interface Constants {                                                             //创建一个叫Constants的接口
public static final int Constants_A=1;                                            //定义公共的的CA值(不可变动)
public static final int Constants_B=12;                                           //定义公共的的CB值(不可变动)
}

class main {                                                                      //主类
enum Constants2{   Constants_A, Constants_B  }                                    //对CA和CB进行枚举类型转换

public static void doit(int c){                                                   //接受int的doit()方法
switch(c){                                                                        //对传入的整数c进行判断
case Constants.Constants_A :    System.out.println("doit() Constants_A");  break; //若是整数c等于CA，输出doit A。 （此处的CA是本类枚举的Constants2）
case Constants.Constants_B :    System.out.println("doit() Constants_B");  break; //若是整数c等于CB，输出doit B。 （此处的CA是本类枚举的Constants2）
}
}

public static void doit2(Constants2 c){                                           //接受Constants2枚举类型的传入实参
switch(c){                                                                        //对传入的整数c进行判断
case Constants_A :    System.out.println("doit2() Constants_A");  break;          //若是整数c等于CA，输出doit2 A。 （此处的CA是本类枚举的Constants2）
case Constants_B :    System.out.println("doit2() Constants_B");  break;          //若是整数c等于CB，输出doit2 B。 （此处的CA是本类枚举的Constants2）
}
}

public static void main(String[] args) {                                          //主main测试函数
main.doit(Constants.Constants_A);                                                 //调用本类doit方法，传入CA     （此处的CA是接口的Constants）
main.doit2(Constants2.Constants_A);                                               //调用本类doit2方法，传入CA    （此处的CA是本类枚举的Constants2）
main.doit2(Constants2.Constants_B);                                               //调用本类doit2方法，传入CA    （此处的CA是本类枚举的Constants2）                               
main.doit(3);                                                                     //调用本类doit方法，传入整数3         
}

}