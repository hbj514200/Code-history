class main implements Runnable {                                                         //主类， 直接实现Runnable接口
int num=10;                                                                              //设置初始总票数为10

public void run(){                                                                       //固定方法run
    while(num>0){                                                                        //如果还有车票，num>0进入循环
        try {   Thread.sleep(100);  } catch (Exception e) {    e.printStackTrace();   }  //休眠100ms
        System.out.println("票数 "+num--);                                               //这个线程对票数进行了操作，同时显示出来
    }
}

public static void main(String[] args) {                                                //主main测试函数
main t=new main();                                                                      //实例化本类(也就是new Runnable)，因为本类实现类那个接口
Thread tA=new Thread(t);                                                                //为进程ThreadA添加内容t
Thread tB=new Thread(t);                                                                //为进程ThreadB添加内容t
Thread tC=new Thread(t);                                                                //为进程ThreadC添加内容t
Thread tD=new Thread(t);                                                                //为进程ThreadD添加内容t
tA.start();                                                                             //启动线程A
tB.start();                                                                             //启动线程B
tC.start();                                                                             //启动线程C
tD.start();                                                                             //启动线程D
}
    
}

//出现了出上的问题，的确在运行的时候最后出现了负值，而且有可能0 1 0的结果…………    所以需要进行线程同步