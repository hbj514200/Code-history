import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
class main extends JFrame {
    
public main(){
    Container cp=getContentPane();
    JScrollPane mianban=new JScrollPane();                
    cp.add(mianban, BorderLayout.CENTER);
    String[] columnNames={"A", "B"};                                              //表格的列名
    String[][] tableValues={{"A1","B1"}, {"A2", "B2"}, {"A3","B3"}, {"A4","B4"}}; //表格内容， 二位String数组
    DefaultTableModel tableModel=new DefaultTableModel(tableValues, columnNames); //创建一个表格模型。   输入的东西和Jtable一样。
    JTable table=new JTable(tableModel);                                          //传入表格模型，实例化一个Jtable电子表格对象
    table.setRowSorter(new TableRowSorter<>(tableModel));                         //调用了table对象内部的setRowSorter()方法设定行排序， 
    mianban.setViewportView(table);                                               //表格不可以直接add
    setSize(320,240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("表格排序");
}
    
public static void main(String[] args) {
    new main().setVisible(true);
}

}

//设置本例中的排序效果的语句是这样的：   table.setRowSorter(new TableRowSorter<>(tableModel)); 