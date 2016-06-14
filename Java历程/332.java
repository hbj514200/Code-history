import javax.swing.*;                                                           //界面包
import java.awt.*;                                                              //窗口组件报
class main extends JFrame {                                                     //主类， 继承JFrame
JProgressBar jindu1=new JProgressBar();                                         //新建一号进度条
JProgressBar jindu2=new JProgressBar();                                         //新建二号进度条
JProgressBar jindu3=new JProgressBar();                                         //新建三号进度条
JProgressBar jindu4=new JProgressBar();                                         //新建四号进度条
Thread threadA, threadB, threadC, threadD;                                      //创建四个进程对象
int count=0;                                                                    //计数器count

public main(){                                                                  //主窗口方法
Container cp=getContentPane();                                                  //获取一个界面容器
cp.add(jindu1);   cp.add(jindu2);   cp.add(jindu3);   cp.add(jindu4);           //把四个进度条加入界面容器
jindu1.setStringPainted(true);      jindu2.setStringPainted(true);              //设置进度条显示数字提示
jindu3.setStringPainted(true);      jindu4.setStringPainted(true);              //设置进度条显示数字提示
threadA=new Thread(new MyThread(jindu1));                                       //新建进程A
threadB=new Thread(new MyThread(jindu2));                                       //新建进程B
threadC=new Thread(new MyThread(jindu3));                                       //新建进程C
threadD=new Thread(new MyThread(jindu4));                                       //新建进程D
setPriority("threadA", 5, threadA);                                             //设置进程A的优先度
setPriority("threadB", 5, threadB);                                             //设置进程B的优先度
setPriority("threadC", 4, threadC);                                             //设置进程C的优先度
setPriority("threadD", 3, threadD);                                             //设置进程D的优先度
}
    
public void setPriority(String threadname, int priority, Thread t){             //设置进程优先级的自创函数
t.setPriority(priority);                                                        //利用线程对象的setPriority()方法，设置优先级，传入1到10
t.setName(threadname);                                                          //利用线程对象的setName(）方法可以设置线程的名字
t.start();                                                                      //启动线程start
}

public static void main(String[] args)      {       init(new main(), 320, 240);     }    //主main测试函数

private final class MyThread implements Runnable {                                       //线程Runnable内容
private final JProgressBar jindu;                                                        //定义一个进度条对象
int count=0;                                                                             //定义计数器count=0
private MyThread(JProgressBar jindu)    {   this.jindu=jindu;   }                        //把外界传入的进度条赋值给本地的进度条
public void run(){                                                                       //固定的run()方法
while(true){                                                                             //无限循环
    jindu.setValue(count+=10);                                                           //使得进度条走动
    try {   Thread.sleep(1000);   } catch (InterruptedException e) {   System.out.println("当前线程被中断");    }  //进程休眠1000ms
}
}
}

public static void init(JFrame frame, int width, int height) {                  //工具型的方法吧
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);                                  //设置主窗口的关闭方式
frame.setSize(width,height);                                                    //设置主窗口的大小
frame.setVisible(true);                                                         //设置主窗口可见
frame.setLayout(new FlowLayout());                                              //设置窗口自由布局管理
}

}

//在本机运行这个代码时，由于机器运行速度很快所以并没有出现书上说的优先级先后的问题，至少肉眼看不出
//这里第一次使用了类的方式来处理Runnable