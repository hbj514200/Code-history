import java.awt.*;                                                              //界面包
import java.awt.event.*;                                                        //动作响应包
import javax.swing.*;                                                           //界面组件包
import java.net.*;                                                              //网络包
class main extends JFrame implements Runnable,ActionListener {                  //主类，继承JFrame成为窗口，实现多线程和动作事件接口。
int port;                                                                       //成员变量， 端口
InetAddress group=null;                                                         //成员变量， 网络地址对象
MulticastSocket socket=null;                                                    //成员变量，广播
JButton open=new JButton("开始接受");                                            //成员变量，按钮1
JButton stop=new JButton("停止接受");                                            //成员变量，按钮2
JTextArea inceAr=new JTextArea(10,10); 
//成员变量，接受广播的文本域
JTextArea inced=new JTextArea(10,10);                                           //成员变量，接受广播的文本域
Thread thread;                                                                  //成员变量，空的多线程大哥
boolean b=false;                                                                //这也要定义？？！！  我操
    
public main(){                                                                  //主窗口函数
super("健促地下组织秘密广播");                                                     //JFrame的super()是设定窗口标题
setDefaultCloseOperation(EXIT_ON_CLOSE);                                        //设置窗口的关闭方式
thread=new Thread(this);                                                        //创建多线程大哥，把本类输了进去，实现runnable
open.addActionListener(this);                                                   //为接受按钮添加动作事件
stop.addActionListener(this);                                                   //为停止按钮添加动作事件
inceAr.setForeground(Color.blue);                                               //？？？？？？？？？？？？？？？？
JPanel north=new JPanel();                                                      //创建一个滚定上面板
north.add(open);    north.add(stop);                                            //上面板加入两个按钮
getContentPane().add(north, BorderLayout.NORTH);                                //把上面板加入界面容器，
JPanel center=new JPanel();                                                     //创建一个中部固定面板
center.setLayout(new GridLayout(1,2));                                          //设置中面板内部使用网格布局管理。分为左右
center.add(inceAr);     center.add(inced);                                      //在中部面板中添加两个文本框
getContentPane().add(center, BorderLayout.CENTER);                              //把中部面板加入界面容器，
validate();                                                                     //好像是刷新界面
port=9898;                                                                      //设定端口为9898
    try {                                                                       //网络操作有风险try
        group=InetAddress.getByName("224.225.10.0");                            //利用InetAdress的getbyname方法可以把group有ip实例化
        socket=new MulticastSocket();                                           //实例化广播套字socket
        socket.joinGroup(group);                                                //把socket加入网络组
    } catch (Exception e)   {   System.out.println("代码第36行报错");  }         //异常的显示
setBounds(100,50,360,380);                                                      //设定窗口大小和位置
setVisible(true);                                                               //设置窗口可见
}

public void run(){                                                              //多线程固定run方法
while (true) {                                                                  //无限循环
    byte data[]=new byte[1024];                                                 //新建一个字节数组
    DatagramPacket packet=null;                                                 //创建一个空的UDP数据包
    packet=new DatagramPacket(data, data.length, group, port);                  //UDP数据包实际填满，传入字节数组，长度，网络对象，端口
    try {                                                                       //网络操作有风险try
        socket.receive(packet);                                                 //广播套字接受UDP数据包
        String message=new String(packet.getData(), 0, packet.getLength());     //把packet.getdata()方法受到的东西转化为字符串，0和长度getlength
        inceAr.setText("正在接受健促总部的信息: \n"+message);                      //在文本框显示目前操作
        inced.append(message+'\n');                                             //聊天记录显示
    } catch (Exception e)    {      System.out.println("接受健促最高指示信息失败");       }     //异常的报错
    if(b==true)     break;                                                      //点击停止接受的话跳出
}
}

public void actionPerformed(ActionEvent e){                                     //事件响应方法
if(e.getSource()==open){                                                        //如果是开始按钮的点击，进入if模块
    open.setBackground(Color.red);                                              //按钮变色
    stop.setBackground(Color.yellow);                                           //按钮变色
    if(!(thread.isAlive()))      thread=new Thread(this);                       //若果线程挂了，重新启动线程
    thread.start();                                                             //启动线程，动用run()方法
    b=false;                                                                    //标记
    }
if(e.getSource()==stop){                                                        //如果是停止按钮的点击，进入if模块
    open.setBackground(Color.yellow);                                           //按钮变色
    stop.setBackground(Color.red);                                              //按钮变色
    b=true;                                                                     //标记
    }
}

public static void main(String[] args) {                                        //主main测试函数
main rec=new main();                                                            //实例化本类
rec.setSize(460,200);                                                           //设置主窗口大小
}

}

//如果一个主类实现了多个接口，然后在自己内部实现不同方法就可以直接在内部this传入，很方便。避免了内部类。
//在这个复杂的代码中，似乎要上百行了。  对于代码缩进也有了更深的认识。
//利用seTForground()方法可以直射文本域的文字颜色
//这里发现一个非常重要的地方，就是在事件的actionPerformed方法里面可以使用e的getsource()方法获取来源，利用if的判断就可以使多个按钮使用同一个事件接口，很方便！！！
