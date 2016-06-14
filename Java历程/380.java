import java.awt.*;                                                              //界面包
import java.util.Vector;                                                        //Vector容器包
import javax.swing.*;                                                           //界面组件包
import javax.swing.table.*;                                                     //电子表格包
class main extends JFrame {                                                     //主类， 继承JFrame
 
public static void main(String[] arg)       {   new main();     }               //主main测试函数

public main(){                                                                  //主函数
setTitle("超级EXcel表格");                                                       //设置主窗口标题名字
setSize(500,375);                                                               //设置主窗口的大小
setDefaultCloseOperation(EXIT_ON_CLOSE);                                        //设置主窗口的关闭方式
JScrollPane mianban=new JScrollPane();                                          //创建一个滚动小面板
getContentPane().add(mianban);                                                  //把滚动小面板加入界面容器
String[] columnNames={"A","B","C","D","E","F","G"};                             //创建一个字符串string数组，表示表格头
Vector<String> columnNameV=new Vector<>();                                      //创建一个储存表格内容的字符串string容器
for(int column=0; column<columnNames.length; column++)    columnNameV.add(columnNames[column]);    //表格头的行遍历，  把表格头字符串数组内的西都加了进去   
Vector<Vector<String>> tableValueV=new Vector<>();                              //创建一个叫tableValueV的容器的容器（字符串），用于存放表格内容
for(int row=1; row<21; row++){                                                  //现在是按行循环
    Vector<String> rowV=new Vector<>();                                         //每次循环里创建了一个小字符串容器叫rowV用于存放每一行的表格内容
    for(int column=0; column<columnNames.length; column++)      rowV.add(columnNames[column]+row);   //内部小循环，遍历每行表格头数组，并加入行容器（后面还加了数字row）
    tableValueV.add(rowV);                                                      //表格总容器每次都加入一次小的行容器
}
JTable table=new JTable(tableValueV, columnNameV);                              //创建电子表格对象，先输入容器的容器，后面是表格头数组
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);                                //关闭表格的自动调整功能(否则表格随窗口大小变化)
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                    //选择模式为单选，不可多选
table.setSelectionBackground(Color.yellow);                                     //被选择行的背景是黄色
table.setSelectionForeground(Color.red);                                        //被选择行的文字是红色
table.setRowHeight(30);                                                         //每行的行高30
mianban.setViewportView(table);                                                 //这与面板和表格性质规定有关不应该add， 而是使用setViewportVoew方法来把表格对象添加进去
setVisible(true);                                                               //使主窗口可见
}


//原来它里面命名的时候总是后面有V，例如namesV，其实V代表Vector容器！