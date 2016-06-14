import java.awt.*;                                                                    //界面包
import javax.swing.*;                                                                 //界面组件包
class main extends JFrame {                                                           //主类，继承JFrame
Thread thread;                                                                        //创建一个多线程空的大哥
     
public main(){                                                                        //主窗口方法
setVisible(true);       setDefaultCloseOperation(EXIT_ON_CLOSE);    setSize(240,100); //主窗口的基本属性设置
JProgressBar jindu=new JProgressBar();                                                //新建一个进度条
jindu.setStringPainted(true);                                                         //设置进度条显示数字提示
getContentPane().add(jindu);                                                          //直接利用getContentPane方法获取了界面容器，把进度条加进去
getContentPane().setLayout(new FlowLayout());                                         //主窗口布局自动管理
Thread thread=new Thread(new Runnable() {                                             //为多线程大哥添加内容，实现Runnable接口
    public void run() {                                                               //多线程固定run方法
       int count=0;                                                                   //定义一个计数整数count
       while(true){                                                                   //无限循环
           try {    Thread.sleep(50);     jindu.setValue(count++);      }             //尝试线程休眠50ms，同时对进度条设置值
           catch (Exception e) {    e.printStackTrace();    }                         //发生异常时，显示异常的详细信息
           if(count==100)   count=0;                                                  //让进度条归零
       }
    }
});
thread.start();                                                                       //启动thread这个多线程
}
 
public static void main(String[] args)      {    new main();     }                    //主main测试函数

}