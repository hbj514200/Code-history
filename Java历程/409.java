import java.awt.*;
import javax.swing.*;

class main extends JFrame {
    
public static void main(String[] args) {
    new main().setVisible(true);
}
    
public main(){
    super();
    setTitle("分割面板实例窗口");
    setBounds(100,100,500,375);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JSplitPane hSplitPane=new JSplitPane();                                     //创建了一个竖直的分隔条， split单词是分割, 分隔条默认就是水平分割的
    hSplitPane.setDividerLocation(40);                                          //设置竖直分隔条左侧为宽度40像素
    getContentPane().add(hSplitPane, BorderLayout.CENTER);                      //把这个竖直分隔条加入界面容器
    hSplitPane.setLeftComponent(new JLabel("     1"));                          //分隔条左侧添加组件
    
    JSplitPane vSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);            //创建了一个水平分隔条， 参数JSplitPane.VERTICAL_SPLIT 表示这东西是横着的
    vSplitPane.setDividerLocation(30);                                          //设置水平分隔条上方宽度30
    vSplitPane.setDividerSize(8);                                               //设置分隔条的线条宽度
    vSplitPane.setOneTouchExpandable(true);                                     //提供UI收放小部件（小三角箭头）
    
    
    hSplitPane.setRightComponent(vSplitPane);                                   //竖直分隔条把水平分隔条加到它的右边
    vSplitPane.setLeftComponent(new JLabel("      2"));                         //水平分隔条添加向它的上边添加文字标签组件
    vSplitPane.setRightComponent(new JLabel("       3"));                       //水平分隔条添加向它的下边添加文字标签组件                       
}

}


//分隔条要设定区域宽度的话， 默认是：  上、  左。  指的是setDivierLocation()方法
//在分隔条对象添加组件时也是   上=左    下=右，  也就是说没有setUpComponent()方法
//对于分隔条的放置而言， 也是遵循和原来见面组件一样的互相添加原则，只不过没有了加到里面这种概念，只有把这个分隔条加到那个分隔条哪边这种操作
//对于，setOneTouchExpandable(）方法， 是在分隔条上放置两个小三角，使得那部分区域有了最小化的功能
//分隔条好像暂时没有发现怎么锁定，都可以用鼠标调整