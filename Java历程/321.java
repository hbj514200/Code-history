import java.lang.*;                                                                       //java的语言基础包
class main extends Thread {                                                               //创建主类，继承多线程大哥Thread
private int count=10;                                                                     //创建私有成员变量count=10

public void run(){                                                                        //这是多线程程序对象中的执行run方法，主代码全在里面
while(true){        System.out.println(count+" ");      if(--count==0)      return;     } //循环输出数字
}

public static void main(String[] args) {                                                  //主main测试函数
new main().start();                                                                       //调用主类的start()方法，这是来自父类Thread的启动入口
}
    

}

//看来， Thread大哥是多线程的超级父类，不继承他的话就要自己实现对应的接口，接口是一切都有了规范。   