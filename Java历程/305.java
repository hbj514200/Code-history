import static java.lang.System.out;                                                            //又是这个系统输出包
class main  {                                                                                  //主类
enum Constants2  {   Constants_A, Constants_B;   }                                             //创建包含CA、CB的枚举类型Constants2,

public static void compare(Constants2 c) {                                                     //实现对比的函数，传入一个Constants2的枚举类型
for(int i=0; i<Constants2.values().length; i++)                                                //循环，直接把valuse()当做一个数组
out.println(c+"与"+Constants2.values()[i]+"的比较结果为： "+c.compareTo(Constants2.values()[i]));//输出比较结果，调用了枚举类型自己的compareTo()的方法
}

public static void main(String[] args)  {   compare(Constants2.valueOf("Constants_B"));  }     //主main测试函数
    
}

//枚举类型里面的东西不需要定义类型，如int，double等等。
//compaeTo比较时自己比他大则返回1，相同0， 比他大负数
