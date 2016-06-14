class main extends Thread {                     //创建主类继承Thread
    
public void run() {                            //按要求覆盖了run()方法
    int count=0;                               //创建计数整数count
while(true){                                   //无限循环
    try {   sleep(100);     System.out.println(count++);    } catch (Exception e) {       e.printStackTrace();      }
}                //利用sleep每100ms输出一句话
}
    
public static void main(String[] args) {      //主main测试函数
new main().start();                           //直接调用同类的方法
}

}