import java.awt.*;                                                //界面包                       
import java.awt.event.*;                                          //响应时间包
import java.io.PrintWriter;                                       //数据流包
import javax.swing.*;                                             //界面组件包
import java.net.*;                                                //网络包
import javax.swing.border.BevelBorder;                            //是一个美化界面的
class main extends JFrame {                                       //主类，继承JFrame
private PrintWriter writer;                                       //创建一个PrintWriter对象，输出流用的
Socket socket;                                                    //创建套字对象
private JTextArea ta=new JTextArea();                             //文本框对象
private JTextField tf=new JTextField();                           //文本框对象
Container cp=getContentPane();                                    //获取一个界面容器

public main(String title) {                                       //主方法，传入string字符串
    super(title);                                                 //设定了主窗口的名字
    setDefaultCloseOperation(EXIT_ON_CLOSE);                      //设置主窗口的关闭方式                       
    final JScrollPane scrollPane=new JScrollPane();               //创建一个滚动面板
    scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));    //使得聊天记录的文本框凸出一点
    cp.add(scrollPane, BorderLayout.CENTER);                      //把滚动小面板加入容器的中间
    cp.add(tf, "South");                                          //把文字编辑框放在界面的下边
    scrollPane.setViewportView(ta);                               //界面高难度的东西，类似add                 
    tf.addActionListener(new ActionListener() {                   //为tf文字框添加动作？？？？！！！
        public void actionPerformed(ActionEvent e) {              //固定的动作主方法
            writer.println(tf.getText());                         //将文本框中的东西写入流
            ta.append(tf.getText()+'\n');                         //获取文本框的文字然后发送给滚动文字区域，使用append方法
            ta.setSelectionEnd(ta.getText().length());            //
            tf.setText("");                                       //清空文本编辑框的内容
        }
});
}

private void connect() {                                          //连接方法
ta.append("正在尝试连接…………");                                     //文本区域显示文字
    try {                                                        //网络操作有风险try
        socket=new Socket("192.168.191.1", 8998);                //将socket套字对象进行实例填充，传入服务器IP和端口
        writer=new PrintWriter(socket.getOutputStream(),true);   //PrintWriter输出流实例化，传入套字socket的getOutput()获得一个输出流，后面还用了一个true
        ta.append("已连接上舍长的服务器\n");                       //文字区域提示已服务器连接成功
    } catch (Exception e)    {   System.out.println("无法连接到舍长的服务器");   }   //异常的显示处理
}

public static void main(String[] args) {                          //主main测试函数
 main clien=new main("小赐客户端");                           //实例化这个主类，向构造方法传入窗口标题字符串
 clien.setSize(320,200);                                     //设置窗口的大小
 clien.setVisible(true);                                     //设置主窗口可见
 clien.connect();                                            //调用主窗口函数的连接函数
 clien.setDefaultCloseOperation(EXIT_ON_CLOSE);              //设置主窗口的关闭方式
}
    
}

//文本框也可以添加动作，回车出发
//在这个代码中，发现了枚举类型的一个重大用途， 例如再接面布局管理器中，传入的是枚举类型，分别固定代表了几个固定的值。这样就可以再掉用的时候方便使用者使用，比起用1234直观了很多