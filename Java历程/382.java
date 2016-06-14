import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.*;
import sun.swing.table.DefaultTableCellHeaderRenderer;
class main extends JFrame {
JTable table;
String[] st={"A","B","C","D","E"};
JButton anniu1=new JButton("全部选择");
JButton anniu2=new JButton("取消选择");

public static void main(String[] args)    {     new main();     }
    
public main(){
    Vector<Vector<String>> tableValueV=new Vector<>();
    Vector<String> columnNamesV=new Vector<>();
    setSize(410,320);
    for(int i=0; i<st.length; i++)    columnNamesV.add(st[i]);
    table=new JTable(tableValueV, columnNamesV);
    for(int i=0; i<20; i++){
        Vector<String> ve=new Vector<>();
        for(int j=0; j<st.length; j++)      ve.add(st[j]+i);       tableValueV.add(ve);
    }
    JScrollPane mianban=new JScrollPane(table);
    
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    Container cp=getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(mianban,BorderLayout.CENTER);
    JPanel xia=new JPanel(new FlowLayout());
    xia.add(anniu1);    xia.add(anniu2);
    cp.add(xia, BorderLayout.SOUTH);
    
    anniu1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            table.selectAll();                                                  //表格的setectAll可以全选
        }
    });
    anniu2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            table.clearSelection();                                             //清空表格的选中项
        }
    });
    
    
    table.setRowSelectionInterval(1,3);                                         //设置默认被选中行是1到3行
    table.addRowSelectionInterval(5,5);                                         //添加一个被选中行
    
    System.out.println("表格的行数和列数分别是：  "+table.getRowCount()+"   "+table.getColumnCount());    //利用表格对象的getRowCOunt方法可以获取表格行数，getColumnCount方法获取表格列数
    System.out.println("目前被选中的行数总共有： "+table.getSelectedRowCount());                          //利用表格对象的getSelectionRowCount方法获取被选中行数的总数
    System.out.println("第3行的选中状态为： "+table.isRowSelected(2));                                   //利用表格兑现搞得isRowSelected方法判断 第2行 是否为选中状态 
    System.out.println("第6行的选中状态为： "+table.isRowSelected(6));                                   //利用表格兑现搞得isRowSelected方法判断 第6行 是否为选中状态
    System.out.println("被选中的第一行的索引是： "+table.getSelectedRow());                               //表格对象的getSectedRow方法可以返回一个整数值，告诉你当先被选中的行中的第一行
    int[] selectedRows=table.getSelectedRows();                                                        //原来getSelectedRow方法返回的是int数组，只不过你没有数组来承接的话，就是一个第一行的行号
    for(int row=0; row<selectedRows.length; row++)        System.out.print(selectedRows[row]+" ");     //遍历被选中的行号数组
    System.out.println("");
    System.out.println("列移动前第二列的名称是： "+table.getColumnName(1));                               //利用表格对象的getColumnName方法可以获取第n列的列名字
    System.out.println("列移动前2列2行的值是： "+table.getValueAt(1, 1));                                //利用表格对象的getValueAt方法获取指定单元的值，但是注意表格是0基的，从0开始，和二位数组一样
    table.moveColumn(1,4);                                                                            //利用表格对象的moveColumn方法把第一列移动到第四列
   
    
   
}

}