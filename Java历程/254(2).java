import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class main extends JFrame{                                                //主窗口继承JFrame
private static final long serialVersionUID = 1L;                                 //
private String[] contents={"列表1","列表2","列表3","列表4","列表5"};               //创建选项数组
private JComboBox<String> jc=new JComboBox<>();                                  //创建一个下拉项目
private JButton jb=new JButton("提交");                                          //创建一个按钮jb
int count=0;                                                                    //

public main(){                                                                  //主窗口类
setSize(320,100);
setVisible(true);
jc.setSize(100,50);
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);                     //设置窗口关闭方式
Container cp=getContentPane();                                                  //获取一个界面容器
cp.setLayout(new GridLayout(1,2));                                           //设置窗口自动布局管理
cp.add(jc);    cp.add(jb);                                                      //把两个组件加入界面容器
jb.addActionListener(new ActionListener(){                                      //为按钮jb添加点击监听事件
public void actionPerformed(ActionEvent arg0) {                                 //动作事件固定响应方法
if(count<contents.length){                                                      
jc.addItem(contents[count++]);                                                  //他妈的原来有addItem（）；
}
}
});	
}

public static void main(String[] args)   {   new main();   }                    //测试主main函数

}
