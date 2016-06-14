import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

class main extends JFrame {
JDesktopPane desktopPane=null;                                                  //JdesktopPane是桌面面板对象
JInternalFrame plnFrame=null;                                                   //人事管理内部窗体对象，       
JInternalFrame rlnFrame=null;                                                   //账套管理内部窗体对象，  
JInternalFrame tlnFrame=null;                                                   //待遇管理内部窗体对象，  
JButton renshi=new JButton("人事管理");
JButton zhangtao=new JButton("账套管理");
JButton daiyu=new JButton("待遇管理");

public static void main(String[] args)      {           new main().setVisible(true);        }

public main(){
    setTitle("小祥人事管理系统");
    setSize(1280,800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    desktopPane=new JDesktopPane();                                             //创建了一个空的桌面对象
    desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);                        //设置桌面面板的拖拽方式，  就是拖拽时是否实时显示窗口，。 目测drag是拖动的意思
    getContentPane().add(desktopPane, BorderLayout.CENTER);                         //把桌面面板加入到窗口界面的中间
    JLabel backJLabel=new JLabel();                                             //创建底层JLabel标签
    ImageIcon icon=new ImageIcon(main.class.getResource("img.jpg"));                //创建ImageIcon对象。（桌面面板的壁纸）
    backJLabel.setIcon(icon);                                                       //设置底层标签的图片setIcon。
    backJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());          //设置底层标签的位置和大小（与壁纸图片等大）
    desktopPane.add(backJLabel, new Integer(Integer.MIN_VALUE));                //把底层标签JLabel置底放置。   固定语句
    JPanel mianban=new JPanel(new FlowLayout());                                //创建一个顶部的按钮面板（Flow布局管理）
    mianban.add(renshi);       mianban.add(zhangtao);       mianban.add(daiyu); //把三个按钮加到面板上
    getContentPane().add(mianban, BorderLayout.NORTH);                          //把按钮面板加入到窗口界面的顶部
    
    renshi.addActionListener(new BAlistener(plnFrame, "人事管理窗口"));          //三个按钮添加了本地的动作事件类。
    zhangtao.addActionListener(new BAlistener(rlnFrame, "账套管理窗口"));
    daiyu.addActionListener(new BAlistener(tlnFrame, "待遇管理窗口"));
}
    
public class BAlistener implements ActionListener{                              //自定义的动作事件类，继承ActionListener
    JInternalFrame inFrame;                                                         //定义一个内部窗口对象，  JInternalFrame
    String title;                                                                   //定义title标题字符串
    public BAlistener(JInternalFrame inFrame, String title){                        //构造方法，传入两个对象： 内部窗口、 窗口标题
        this.inFrame=inFrame;                                                           //传递形参
        this.title=title;                                                               //传递形参
    }
    public void actionPerformed(ActionEvent e){                                     //固定动作响应方法
        if(inFrame==null||inFrame.isClosed()){                                        //如果这个内部窗口是null的，或已经不存在
            JInternalFrame[] allFrames=desktopPane.getAllFrames();                      //利用getAllFrame方法获取目前桌面面板中所有的小窗口对象，（使用数组承接）
            int titleBarHight=30*allFrames.length;                                      //定义了titleBarHight是30倍的内部窗口长度
            int x=10+titleBarHight,     y=x;                                            //定义x的值和y的值
            int width=250, height=180;                                                  //定义了width和hight， 宽度和高度
            inFrame=new InternalFrame(title);                                           //实例化一个新的内部窗口叫做“title”字符串
            inFrame.setBounds(x,y,width,height);                                        //设置它的位置和大小
            desktopPane.add(inFrame);                                                   //把这个窗口添加到桌面面板上去
            inFrame.setVisible(true);                                                   //设置这个内部窗口可见
        }
        try {                                                                      //窗口操作也有风险？？？！！
            inFrame.setSelected(true);                                              //设置这个新建的内部窗口为被选中状态
        } catch (Exception e1) {            e1.printStackTrace();                    //否则抛出异常
        }
    }

}

private class InternalFrame extends JInternalFrame {                            //自定义内部类， 内部窗口，继承了JInternalFrame
    public InternalFrame(String title){                                             //构造方法，传入标题title
        setTitle(title);                                                                //设置内部窗口的标题名字
        setResizable(true);                                                             //设置内部窗口可以自由调整大小
        setClosable(true);                                                              //设置内部窗口可以被关闭
        setIconifiable(true);                                                           //好像是设置内部窗口是否允许设置图标
        setMaximizable(true);                                                           //设置内部窗口可以被最大化
        ImageIcon icon=new ImageIcon(main.class.getResource("img2.bmp"));               //新实例化一个图标对象img2
        setFrameIcon(icon);                                                             //利用setFrameIcon方法设置内部窗口的窗口图标
    }
}
    
}

//注： 本代码实例需要两个图标img.jpg与窗口等大的壁纸，     img2.bmp一个窗口小图标，不要太大