import java.awt.*;                                                              //界面包       
import javax.swing.*;                                                           //界面组件包
class main extends JFrame {                                                     //主类，继承JFrame
private Thread threadA, threadB;                                                //创建两个多线程大哥空的实例
final JProgressBar jindu1=new JProgressBar(), jindu2=new JProgressBar();        //创建两个进度条，进度条是JProgressBar
int count=0;                                                                    //创建计数count

public static void main(String[] args)      {   init(new main(), 200, 200);    }//主main函数， 输入intit的窗口对象，窗口的大小

public main() {                                                                 //界面主函数
getContentPane().add(jindu1, BorderLayout.NORTH);                               //把一号进度条放在窗口上边
getContentPane().add(jindu2, BorderLayout.SOUTH);                               //把二号进度条放在窗口下边
jindu1.setStringPainted(true);      jindu2.setStringPainted(true);              //设置两个进度条显示数字
threadA=new Thread(new Runnable() {                                             //为线程A传入Runnble的匿名内部类
       public void run(){                                                       //实现线程接口的run()方法
           int count=0;                                                         //将计数器count归零
           while(true){                                                         //循环
               jindu1.setValue(++count);                                        //通过进度条对象的setValue方法设定进度值
               try {    Thread.sleep(100);   threadB.join();    } catch (Exception e) {  e.printStackTrace();   }   //线程操作有风险try， 跳到线程B， 利用ThreadB的join方法。
       }
    }
});
threadA.start();                                                                //实现接口的start(）方法，好像没有不可以启动线程
threadB=new Thread(new Runnable() {                                             //为线程B传入Runnble的匿名内部类
    public void run(){                                                          //实现线程接口的run()方法
        int count=0;                                                            //将计数器count归零
        while(true){                                                            //循环
            jindu2.setValue(++count);                                           //通过进度条对象的setValue方法设定进度值
            try {   Thread.sleep(100);   } catch (Exception e) {     e.printStackTrace();   }   //利用sleep时间控制了进度条的速度
            if(count==100)       break;                                         //如果进度条走完跳出循环结束run()方法， 这里由于是线程A跳转过来的，所以这个线程B运行结束后会自动调回线程A继续执行
        }
    }
});
threadB.start();                                                                //实现接口的start(）方法，好像没有不可以启动线程
}
    
public static void init(JFrame frame, int width, int height) {                  //工具型的方法吧
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);                                  //设置主窗口的关闭方式
frame.setSize(width,height);                                                    //设置主窗口的大小
frame.setVisible(true);                                                         //设置主窗口可见
}

}

//这里有一个很特殊的地方，就是在11和12行中在获取界面容器时， 并没有使用传统的Container cp=getContentPane()的形式， 
//而是采用了getContentPane()直接代替了cp， 好像默认就创建了一个界面容器一样
//还有在这个代码中， 第一次操作了进度条。原来这也需要结合线程的控制来使用，怪不得并没有在前面介绍swing的时候讲，
//对于线程的控制，通常采用的是先创建一个实例，然后加入一个Runnable的内部类，在里面实现run方法。  sleep方法直接使用Thread