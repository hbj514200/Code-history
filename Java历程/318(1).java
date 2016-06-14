class main {                                                                    //主类
enum Constants2     {   Constants_A, Constants_B    }                           //创建一个枚举类型包含CA、CB
         
public static void doit2(Constants2 c) {                                        //测试函数，输入一个枚举类型
switch (c) {                                                                    //switch判断
case Constants_A:       System.out.println("doit2() Constants_A");  break;      //若是CA，输出信息
case Constants_B:       System.out.println("doit2() Constants_B");  break;      //若是CB，输出信息
}
}
	
public static void main(String[] args) {                                        //主main测试函数
main.doit2(Constants2.Constants_A);                                             //调用doit2()方法，传入枚举成员CA
main.doit2(Constants2.Constants_B);                                             //调用doit2()方法，传入枚举成员CA
}

}

//这题目就是坑人