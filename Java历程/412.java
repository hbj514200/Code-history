import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.swing.event.*;

class main extends JFrame {
final JTabbedPane tabbedPane=new JTabbedPane();                                 //创建一个选项卡面板，默认在窗口上部

    public static void main(String[] args) {
        new main().setVisible(true);
    }

public main(){
    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);               //选项卡面板的布局管理，  现在是滚动面板
    tabbedPane.addChangeListener(new ChangeListener() {                         //为标签添加动作事件， 居然是改变监听，  原以为是点击事件呢
        public void stateChanged(ChangeEvent e) {                               //固定方法，状态改变事件
            int selectedIndex=tabbedPane.getSelectedIndex();                    //利用选项卡面板的getSelectedIndex获取目前选的是哪个标签
            String title=tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());  //选项卡面板的getTitleAt获取第n个字符串
            System.out.println(title);                                          //输出选项卡名
        }
    });
    
    getContentPane().add(tabbedPane, BorderLayout.CENTER);                      //把选项卡面板加入界面容器中间？？！！
    URL resource=main.class.getResource("tab.jpg");                             //获取了选项卡图标URL
    ImageIcon imageIcon=new ImageIcon(resource);                                //实例化图标对象
    JLabel tabJLabelA=new JLabel();                                             //创建了三个JLabel标签
    JLabel tabJLabelB=new JLabel();
    JLabel tabJLabelC=new JLabel();
    
    tabJLabelA.setText("选项卡A");                                               //分别设置三个文字标签的文字
    tabbedPane.addTab("选项卡A", imageIcon, tabJLabelA, "点击查看选项卡A");        //向选项卡面板加入选项，  传入：  选项名， 选项图标， 页面面板对象，提示文字
    tabJLabelB.setText("选项卡B");
    tabbedPane.addTab("选项卡B", imageIcon, tabJLabelB, "点击查看选项卡A");
    tabJLabelC.setText("选项卡C");
    tabbedPane.addTab("选项卡C", imageIcon, tabJLabelC, "点击查看选项卡A");
    tabbedPane.setSelectedIndex(2);                                             //设置选中项
    tabbedPane.setEnabledAt(0, false);                                          //一号选项卡不可用！   注意是0基的！
    
    setSize(320,240);
    setTitle("选项卡窗口");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}


    
}