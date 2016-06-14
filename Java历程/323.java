import java.awt.Container;                                                      //界面容器只是用了awt的Container而已……
import java.net.URL;                                                            //原来url只是用到net中的URL而已……
import javax.swing.*;                                                           //swing架构包
class main extends JFrame {                                                     //主类，继承JFrame
private JLabel jl=new JLabel();                                                 //创建一个JLabel标签
private static Thread t;                                                        //创建一个Thread的实例t
private int count=0;                                                            //定义一个count整数为0
private Container cp=getContentPane();                                          //获取一个界面容器cp

public main(){                                                                  //构造函数，界面
setBounds(300,200,250,100);                                                     //调整大小
cp.setLayout(null);                                                             //不要布局管理器
URL url=main.class.getResource("1.gif");                                        //用getReSource()方法来获取url对象，读取1.gif
Icon icon=new ImageIcon(url);                                                   //设置Icon为ImageIcon类型，并传入url
jl.setIcon(icon);                                                               //向JLabel面板加入图片， setIcon()方法  
jl.setHorizontalAlignment(SwingConstants.LEFT);                                 //把这个jl标签放在桌面的左边
jl.setBounds(10,10,200,50);                                                     //设置Jl标签的的大小和位置
jl.setOpaque(true);                                                             //设置空间不透明
t=new Thread(new Runnable() {                                                   //内部Thread匿名类
    public void run() {                                                         //固定的runble接口的run方法
       while(count<=200){                                                       //循环操作
           jl.setBounds(count,10,200,50);                                       //设置jl标签的大小
           try                  {   Thread.sleep(5);    }                      //有风险的sleep操作， 进程休眠30ms
           catch(Exception e)   {   e.printStackTrace();   }                    //发生异常则显示异常的详细信息
           count+=1;                                                            //count计数值增加
           if(count==200)       count=0;                                        //循环。
       }
    }
});
t.start();                                                                      //调用t的start()方法
cp.add(jl);                                                                     //把jl标签加入cp界面容器，  怎么顺序在这里
setVisible(true);                                                               //设置主界面可见
setDefaultCloseOperation(DISPOSE_ON_CLOSE);                                     //设置关闭方式

}

public static void main(String[] args)      {   new main();    }               

    
}


//对于创建窗口的类来说， 把窗口上面的各种组件都创建为成员变量很好，里面的每种方法都可以使用，最重要的是可以使得界面代码清晰简洁
//在这个代码中， 直接定义了一个Thread对象实例，似乎并不需要什么独特的包，然后直接向Thread实例传入一个Runnable类型匿名内部类，同时实现run方法。
//在上面的情况下， t就可以当做一个线程用了（也有start），  但是也没有发现代码中哪里有实现Runnable接口。
//实际上还有一点，这个程序通过不断的移动图标实现移动， 是一帧一帧的。