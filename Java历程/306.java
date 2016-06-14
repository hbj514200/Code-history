import static java.lang.System.out;                                        //万年老不死的系统输出包，static表示导入这个包中的静态方法
class main {                                                               //住类
enum Constants2  {    Constants_A, Constants_B, Constants_c;   }           //创建一个包含三个数的枚举类型Constants2

public static void main(String[] args) {                                   //主main测试函数
for(int i=0; i<Constants2.values().length; i++)                            //利用values()方法遍历枚举类型的所有成员
out.println(Constants2.values()[i]+"在枚举类型中位置索引值"+Constants2.values()[i].ordinal());  
}
    
}

//每一个枚举类型的成员都可以用自带的ordinal()方法来返回一个整数int值，代表它在枚举类型的索引位置，注意数组是从0开始的