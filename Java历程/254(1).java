import java.awt.*;
import javax.swing.*;
class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {        //新建下拉模型项目类
String selecteditem="首席设计师";                                                             //已选项目
String[] test={"首席设计师","首席执行官","超级大股东"};                                         //选项字符串列表数组

public int getSize()                        {   return test.length;        }                 //固定方法，返回选项数组长度
public void setSelectedItem(Object item)    {   selecteditem=(String)item; }                 //设定选中选项
public String getSelectedItem()             {   return selecteditem;       }                 //获取目前的选项
public String getElementAt(int index)       {   return test[index];        }                 //遍历数组每个项目

}


class main extends JFrame {                                   //主窗口JFrame类

public main(){
Container cp=getContentPane();                               //获取一个界面容器
cp.setLayout(new BorderLayout());                            //设置由窗口便捷管理器管理
JComboBox<String> jc=new JComboBox<>(new MyComboBox());      //创建JComboBox下拉项目
JCheckBox jc1=new JCheckBox("男");                       //创建jc1复选框
JCheckBox jc2=new JCheckBox("女");                       //创建jc2复选框
JButton jb1=new JButton("确定");   JButton jb2=new JButton("取消");    jb1.setBounds(10,10,100,100);   jb2.setBounds(10,10,100,100);    //新建两个文字按钮并设置大小
JPanel jp2=new JPanel();    JPanel jp3=new JPanel();       //新建两个JP固定面板
jp2.setLayout(new FlowLayout());    jp3.setLayout(new FlowLayout());    //设定两固定面板的自动布局管理器
jp2.add(jc1);  jp2.add(jc2);   jp3.add(jb1);  jp3.add(jb2);             //把组件加入面板
cp.add(jc,BorderLayout.NORTH);   cp.add(jp2,BorderLayout.CENTER);   cp.add(jp3,BorderLayout.SOUTH);   //面板按顺序加入主窗口
setSize(240,140);  setVisible(true);  
}

public static void main(String[] arg)    {   new main();    }

}
