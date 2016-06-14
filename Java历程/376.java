
import java.awt.*;                                                              //界面包
import java.util.Vector;                                                        //尼玛还动用了util包的Vector？？！！！
import javax.swing.*;                                                           //界面组件包
import javax.swing.table.JTableHeader;                                          //沃日！  还自动使用了table小包中的JTableHeader……
class main extends JFrame {                                                     //主类，继承JFrame
    
public static void main(String[] args)      {   new main();     }               //主main测试函数
     
public main(){                                                                  //主函数
setTitle("不可滚动的小赐  Excel");                                                //设置
setSize(480,320);                                                               //设置主窗口标题名字
setDefaultCloseOperation(EXIT_ON_CLOSE);                                        //设置主窗口的关闭方式
Vector<String> columNameV=new Vector<>();                                       //创建一个字符串string容器，用于存放标签名
columNameV.add("A");                                                            //向标签名容器添加字符串“A”
columNameV.add("B");                                                            //向标签名容器添加字符串“B”
columNameV.add("C");                                                            //向标签名容器添加字符串“C”
columNameV.add("D");                                                            //向标签名容器添加字符串“D”
Vector<Vector<String>> tableValueV=new Vector<>();                              //创建了一个存放字符串string容器的容器，用于表示表格数据
for(int row=1; row<6; row++){                                                   //6次的for循环
Vector<String> rowV=new Vector<>();                                             //创建for内部的一个字符串string容器
rowV.add("A"+row);                                                              //把那一行的所有选项加入这个for循环里的容器
rowV.add("B"+row);                                                              //同上
rowV.add("C"+row);                                                              //同上
rowV.add("D"+row);                                                              //同上
tableValueV.add(rowV);                                                          //把每一行的string数据容器加入
}
JTable table=new JTable(tableValueV,columNameV);                                //创建一个表格
getContentPane().add(table,BorderLayout.CENTER);                                //直接向界面容器加入，这样就没有滚动了
JTableHeader tableHeader=table.getTableHeader();                                //创建了一个表格头？  使用的是表格对象的getTableHeader()方法
getContentPane().add(tableHeader,BorderLayout.NORTH);                           //把表格头加了进去
setVisible(true);                                                               //设置主窗口可见
}

}

//界面容器用的次数不多的话可以getContentPane()来代替，使得代码更加简洁
//如果是将表格直接添加到界面上(不经过小面板)，那么表格是不会出现标签名的，这是为了某些地方直接使用。若需要表格头的话使用电子表格的getTableHeader()方法获得一个表格头对象
//这里使用了一个容器中的容器，也就是二维容器来表示二维数组