import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.*;
import sun.swing.table.DefaultTableCellHeaderRenderer;
class main extends JFrame {
JTable table;
String[] st={"A","B","C","D","E"};
JButton anniu1=new JButton("ȫ��ѡ��");
JButton anniu2=new JButton("ȡ��ѡ��");

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
            table.selectAll();                                                  //����setectAll����ȫѡ
        }
    });
    anniu2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            table.clearSelection();                                             //��ձ���ѡ����
        }
    });
    
    
    table.setRowSelectionInterval(1,3);                                         //����Ĭ�ϱ�ѡ������1��3��
    table.addRowSelectionInterval(5,5);                                         //���һ����ѡ����
    
    System.out.println("���������������ֱ��ǣ�  "+table.getRowCount()+"   "+table.getColumnCount());    //���ñ������getRowCOunt�������Ի�ȡ���������getColumnCount������ȡ�������
    System.out.println("Ŀǰ��ѡ�е������ܹ��У� "+table.getSelectedRowCount());                          //���ñ������getSelectionRowCount������ȡ��ѡ������������
    System.out.println("��3�е�ѡ��״̬Ϊ�� "+table.isRowSelected(2));                                   //���ñ����ָ��isRowSelected�����ж� ��2�� �Ƿ�Ϊѡ��״̬ 
    System.out.println("��6�е�ѡ��״̬Ϊ�� "+table.isRowSelected(6));                                   //���ñ����ָ��isRowSelected�����ж� ��6�� �Ƿ�Ϊѡ��״̬
    System.out.println("��ѡ�еĵ�һ�е������ǣ� "+table.getSelectedRow());                               //�������getSectedRow�������Է���һ������ֵ�������㵱�ȱ�ѡ�е����еĵ�һ��
    int[] selectedRows=table.getSelectedRows();                                                        //ԭ��getSelectedRow�������ص���int���飬ֻ������û���������нӵĻ�������һ����һ�е��к�
    for(int row=0; row<selectedRows.length; row++)        System.out.print(selectedRows[row]+" ");     //������ѡ�е��к�����
    System.out.println("");
    System.out.println("���ƶ�ǰ�ڶ��е������ǣ� "+table.getColumnName(1));                               //���ñ������getColumnName�������Ի�ȡ��n�е�������
    System.out.println("���ƶ�ǰ2��2�е�ֵ�ǣ� "+table.getValueAt(1, 1));                                //���ñ������getValueAt������ȡָ����Ԫ��ֵ������ע������0���ģ���0��ʼ���Ͷ�λ����һ��
    table.moveColumn(1,4);                                                                            //���ñ������moveColumn�����ѵ�һ���ƶ���������
   
    
   
}

}