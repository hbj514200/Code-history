import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
class main extends JFrame {
    
public main(){
    Container cp=getContentPane();
    JScrollPane mianban=new JScrollPane();                
    cp.add(mianban, BorderLayout.CENTER);
    String[] columnNames={"A", "B"};                                              //��������
    String[][] tableValues={{"A1","B1"}, {"A2", "B2"}, {"A3","B3"}, {"A4","B4"}}; //������ݣ� ��λString����
    DefaultTableModel tableModel=new DefaultTableModel(tableValues, columnNames); //����һ�����ģ�͡�   ����Ķ�����Jtableһ����
    JTable table=new JTable(tableModel);                                          //������ģ�ͣ�ʵ����һ��Jtable���ӱ�����
    table.setRowSorter(new TableRowSorter<>(tableModel));                         //������table�����ڲ���setRowSorter()�����趨������ 
    mianban.setViewportView(table);                                               //��񲻿���ֱ��add
    setSize(320,240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("�������");
}
    
public static void main(String[] args) {
    new main().setVisible(true);
}

}

//���ñ����е�����Ч��������������ģ�   table.setRowSorter(new TableRowSorter<>(tableModel)); 