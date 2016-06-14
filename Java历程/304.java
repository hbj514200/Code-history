import static  java.lang.System.out;                             //使用了一个系统输出包
class main {                                                     //主类
enum Constants2     {   Constants_A, Constants_B;    }           //穿件一个枚举类型， 包括CA、CB。
 
public static void main(String[] args) {                         //主main测试函数
for(int i=0; i<Constants2.values().length; i++)                  //循环，Constants2.valuse()直接代表一个数组。
out.println("枚举类型成员变量： "+Constants2.values()[i]);         //输出每一项的名字。
}

}

//使用倒是挺方便的