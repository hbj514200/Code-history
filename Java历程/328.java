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
threadA.start();                                                                //实现接口的start(）方法，好像没有不可以
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
//threadB.start();                                                                //实现接口的start(）方法，好像没有不可以
}
    
public static void init(JFrame frame, int width, int height) {
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
frame.setSize(width,height);
frame.setVisible(true);
}

}

//其实利用join方法实现的进度条可以的