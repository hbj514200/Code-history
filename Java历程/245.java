import java.awt.*;
import javax.swing.*;
class main extends JFrame {                                //继承JFrame
JComboBox<String> jc=new JComboBox<>(new MyComboBox());    //创建String下拉的模型JComboBox(jc)，传入的是自创的MyComboBox类
JLabel jl=new JLabel("请问舍长是");                        //提示文字显示标签

public main() {                                            //主要方法
Container cp=getContentPane();                             //获取一个界面容器
cp.setLayout(new FlowLayout());                            //主窗口服从自动管理器管理
cp.add(jl);		cp.add(jc);                                 //把标签和下拉JConbobox模型加入容器
setVisible(true);                                          //使窗体可见
setSize(320,240);                                          //设置主窗体大小
setTitle("肇庆学院问卷调查");                              //设置主窗口的标题名字
}

public static void main(String[] arg)  {  new main();   }  //测试用的main函数

}

//下面创建了一个继承着抽象列表模型类AbstractListModel的ComboBox的下拉模型类，同时要求实现ComboBoxModel(下拉模型通用标准接口)的接口。

class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {
String selecteditem=null;                   //设置为默认是没有选中的选项。(这是固定的名字)
String[] test={"帅哥","男神","暖男","云备胎@_@"};     //字符串数组用于表示每个选项

public String getElementAt(int index)       {  return test[index]; 		  }   //接口固定函数， 返回第几个的选项名字。
public int    getSize()                     {  return test.length;         }  //接口固定函数， 返回选项数组的长度。
public void   setSelectedItem(Object item)  {  selecteditem=(String)item;  }  //接口固定函数， 传入一个数据，设定选中的变量。
public String getSelectedItem()             {  return selecteditem;        }  //接口固定函数， 返回目前已选的选项。

}