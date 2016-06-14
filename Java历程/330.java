import java.awt.*;                                                                     //界面包
import javax.swing.*;                                                                  //界面组件包
class main extends JFrame {                                                            //主类，继承JFrame
Thread thread;                                                                         //创建一个Thread多线程空的大哥

public static void main(String[] args)      {    init(new main(), 100, 100);     }     //主main测试函数

public main(){                                                                         //主界面方法     
final JProgressBar jindu=new JProgressBar();                                           //创建一个进度条
getContentPane().add(jindu, BorderLayout.NORTH);                                       //把进度条放在窗口上面
jindu.setStringPainted(true);                                                          //在进度条上放置数字显示
thread=new Thread(new Runnable() {                                                     //为thread多线程大哥添加Runnable对象
    public void run() {                                                                //固定run()方法
        int count=0;                                                                   //创建count计数
        while(true){                                                                   //无限的循环
            jindu.setValue(++count);                                                   //setValue()方法设置进度条的数字递增显示
            try                            {   thread.sleep(1000);     }               //try 进程休眠1000.
            catch (Exception e) {   System.out.println("结束当前进程");    break;     } //interrupt()，抛出异常，接收后跳出
        }
    }
});
thread.start();                                                                        //使得thread线程启动
thread.interrupt();                                                                    //调用interrupt的方法，放出异常使得进程停止
}

public static void init(JFrame frame, int width, int height){                          //主窗口的设置
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
frame.setSize(width,height);
frame.setVisible(true);
}
    
}