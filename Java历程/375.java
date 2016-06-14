import java.awt.*;                                                                   //界面包
import javax.swing.*;                                                                //界面组件包
class main extends JFrame {                                                          //主类，继承JFrame
             
public static void main(String[] args)   {    main frame=new main();      }          //主main测试方法
    
public  main(){                                                                      //构造函数，主函数
setTitle("可以滚动的表格窗口");                                                        //设置主窗口的标题名字
setSize(480,320);                                                                    //设置主窗口的大小
setDefaultCloseOperation(EXIT_ON_CLOSE);                                             //设置主窗口的关闭方式
String[] columName={"A","B"};                                                        //这是“列名”， 也就是最上面的选项卡的STring数组
String[][] tableValue={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}}; //表格数据内容，使用的是二维数组，…………
JTable table=new JTable(tableValue,columName);                                       //创建一个JTable电子表格
JScrollPane mianban=new JScrollPane(table);                                          //创建一个滚动小面板并把电子表格加入
getContentPane().add(mianban,BorderLayout.CENTER);                                   //把滚动小面板加入界面容器
setVisible(true);                                                                    //设置窗口可见
}

}

//创建电子表格的时候注意先传入的是二位数组内容，然后才是选项卡，好像传入的可以是一个容器，挺方便的
//创建滚动小面板时直接把组件利用构造方法加进去，没必要add，容易出问题