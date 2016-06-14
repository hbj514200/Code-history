import java.awt.*;
import javax.swing.*;
class main extends JFrame{                         		//主类继承JFrame

public main() {                                          //主窗口的方法
Container cp=getContentPane();                           //获取一个界面容器
cp.setLayout(new GridLayout(1,2));                       //设置网格12布局管理器管理
JLabel mianban=new JLabel("请在右侧选择你认为舍长有多帅");//创建文字提示标签
cp.add(mianban);                                          //把文字标签加入容器
JList<String> jl=new JList<>(new MyListModel());         //创建一个字符串类型JList列表框(jl)， 传入的是自己的MyListModel。 
JScrollPane js=new JScrollPane(jl);            				//创建一个JS滚动小面板(jl)
js.setBounds(10,10,100,100);                             //设置JS滚动小面板的大小
cp.add(js);                                              //把JS滚动小面板加入界面容器
setVisible(true);                                        //设置窗体可见
setSize(480,140);                                        //设置窗体大小
setTitle("肇庆学院民意普查系统");                        //设置窗口标题名字
}

public static void main(String[] arg)		{   new main();   }    //测试用的主main函数

}

//创建一个MyListModel类继承抽象的AbstractListModel模型。
class MyListModel extends AbstractListModel<String> {
private String[] contents={"挺帅的","好帅啊","非常帅","我的梦中男神","我想和他啪啪啪","我想给他生猴子!"};   //创建列表框的选项字符串数组

public String getElementAt(int x)   {   if(x<contents.length) return contents[x++];  else return null;  } 
public int getSize()                {   return contents.length;  }  
//上面两个是固定函数，上面的返回指定字符串，注意x++。 下面的返回选项数组长度。

}