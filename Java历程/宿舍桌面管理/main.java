import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {
JDesktopPane desktopPane=null;                                                  //JdesktopPane是桌面面板对象
JLabel backJLabel=null;                                                         //背景面板

JInternalFrame hzbFrame=null;                                                   //hzb内部窗体对象，       
JInternalFrame cqhFrame=null;                                                   //cqh内部窗体对象，  
JInternalFrame cgcFrame=null;                                                   //cgc内部窗体对象，  
JInternalFrame sheFrame=null;                                                   //she内部窗体对象，  

JButton hzb=new JButton("胡泽斌");                                               //新建的 按钮 对象
JButton cqh=new JButton("成钦宏");
JButton cgc=new JButton("陈光赐");
JButton she=new JButton("射 长");

ImageIcon icon, icon1, icon2, icon3, icon4;                                           //四个人的 图标对象

public void tupian(){
    icon =new ImageIcon(main.class.getResource("img.jpg"));                                //桌面
    icon1=new ImageIcon(main.class.getResource("zb.jpg"));                      //设置 icon 为四张图片。   由main()调用
    icon2=new ImageIcon(main.class.getResource("qh.jpg"));
    icon3=new ImageIcon(main.class.getResource("gc.jpg"));
    icon4=new ImageIcon(main.class.getResource("she.jpg"));
}                                                                 

public void dongzuo(){
    hzb.addActionListener(new BAlistener(hzbFrame, "胡泽斌 资料窗口"));           //四个按钮添加了本地的动作事件类。
    cqh.addActionListener(new BAlistener(cqhFrame, "成钦宏 资料窗口"));
    cgc.addActionListener(new BAlistener(cgcFrame, "陈光赐 资料窗口"));
    she.addActionListener(new BAlistener(cgcFrame, "射 长 资料窗口"));
}

public static void main(String[] args)      {           new main().setVisible(true);        }

public main(){
    setSize(1290, 870);
    setTitle("D1-741 宿舍成员 桌面 管理系统");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    this.dongzuo();                                                             //添加按钮动作
    this.tupian();                                                              //图片来源 实例化icon
    
    desktopPane=new JDesktopPane();                                             //创建了一个空的桌面对象
    getContentPane().add(desktopPane, BorderLayout.CENTER);                     //把桌面面板加入到窗口界面的中间
    
    backJLabel=new JLabel();                                                    //创建底层JLabel标签
    backJLabel.setIcon(icon);                                                   //设置底层标签的图片setIcon。
    desktopPane.add(backJLabel, new Integer(Integer.MIN_VALUE));                //把底层标签JLabel置底放置。   固定语句
    backJLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());      //设置底层标签的位置和大小（与壁纸图片等大）
    backJLabel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if(e.MOUSE_CLICKED==500)   JOptionPane.showMessageDialog(null, "制作者希望自己是个艺术家\n\n思维也许是神性的残留，\n在纯思的世界里更容易认知实物的本质，却也真的冰冷无情。\n\n也许是诗词更有价值，\n但是一点, 可惜的是搞这个真的没有什么战斗力，很容易被KO。\n\n     我 凡人 可不可以在中间找到一个平衡点\n       智慧又不失情趣？", "关于作者", JOptionPane.PLAIN_MESSAGE);
        }
    });
    
    JPanel mianban=new JPanel(new FlowLayout());                                //创建一个顶部的按钮面板（Flow布局管理）
    getContentPane().add(mianban, BorderLayout.NORTH);                          //把按钮面板加入到窗口界面的顶部
    mianban.add(hzb);
    mianban.add(cqh);
    mianban.add(cgc);
    mianban.add(she);                                                           //把4个按钮加到面板上
    
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
            int num=0;                                                                        //(按钮来源记录)
            JInternalFrame[] allFrames=desktopPane.getAllFrames();                      //利用getAllFrame方法获取目前桌面面板中所有的小窗口对象，（使用数组承接）
            int titleBarHight=30*allFrames.length;                                      //定义了titleBarHight是30倍的内部窗口长度
            int x=10+titleBarHight,     y=x;                                            //定义x的值和y的值
            
            if(e.getSource()==hzb)    num=1;
            if(e.getSource()==cqh)    num=2;
            if(e.getSource()==cgc)    num=3;
            if(e.getSource()==she)    num=4;
            
            inFrame=new InternalFrame(title, num);                                 //实例化一个新的内部窗口叫做“title”字符串
            inFrame.setBounds(x, y, 500, 360);                                    //设置它的位置和大小
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
    public InternalFrame(String title, int num){                                        //构造方法，传入标题title
        setTitle(title);                                                                //设置内部窗口的标题名字
        setResizable(false);                                                             //设置内部窗口不可以调整大小
        setClosable(true);                                                              //设置内部窗口可以被关闭
        setMaximizable(true);                                                           //设置内部窗口可以被最大化
        
        JLabel mianban=new JLabel();
        if(num==1)   mianban.setIcon(icon1);
        if(num==2)   mianban.setIcon(icon2);
        if(num==3)   mianban.setIcon(icon3);
        if(num==4)   mianban.setIcon(icon4);
        add(mianban);
    }
}
    
}

//注： 本代码实例需要两个图标img.jpg与窗口等大的壁纸，     img2.bmp一个窗口小图标，不要太大