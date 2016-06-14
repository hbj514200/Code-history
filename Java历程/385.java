import java.awt.*;                                                              //�����
import javax.swing.*;                                                           //���������
import java.awt.event.*;                                                        //���涯����
import javax.swing.table.*;                                                     //���ӱ���

class main extends JFrame {                                                 //���࣬�̳�JFrame
private DefaultTableModel tableModel;                                           //���壺 DedaultTableModel   ���ģ��
private JTable table;                                                           //���壺 ���JTable����
private JTextField aTextField;                                                  //���壺 ���������Ǹ������ֿ�
private JTextField bTextField;

public static void main(String[] args) { 
     new main().setVisible(true);                                               //��main���Է����� �������ࡣ
}
    
public main(){                                                              //������
    setTitle("���ά��ģ��");                                                    //���������ڱ�������
    setBounds(100,100,510,375);                                                 //���������ڵĴ�С��λ��
    setDefaultCloseOperation(EXIT_ON_CLOSE);                                    //���������ڵĹرշ�ʽ
    JScrollPane mianban=new JScrollPane();                                      //�½���һ���������mianban
    getContentPane().add(mianban, BorderLayout.CENTER);                         //�ѹ�������������������м�
    String[] columnNames={"A","B"};                                                 //�������������
    String[][] tableValues={{"A1","B1"}, {"A2", "B2"}, {"A3", "B3"}};               //������ݣ� String��ά����
    tableModel=new DefaultTableModel(tableValues, columnNames);                     //ʵ������tableModel�ı��ģ�͡���ע�⣺���Ǳ�����
    
    table=new JTable(tableModel);                                               //ʵ����table��������������ӱ��ģ��
    table.setRowSorter(new TableRowSorter<>(tableModel));                           //Ϊtable����������������
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                    //���ñ��Ϊ��ѡ�ģ�
    table.addMouseListener(new MouseAdapter() {                                     //Ϊ������������䣬 ����ʵΪʲô��������������¼�����
        public void mouseClicked(MouseEvent e){                                         //�̶�������mouseClicked���������  ���ܵ�������¼�
            int selectedRow=table.getSelectedRow();                                             //����table�������getSelectedRow������ȡĿǰ��ѡ�е���һ�еĺ���
            Object oa=tableModel.getValueAt(selectedRow, 0);                                    //ѡ��������ߵı�����ݣ�ע�⣺Object���أ������ַ���������  ��0����ţ�
            Object ob=tableModel.getValueAt(selectedRow, 1);                                    //ѡ�������ұߵı�����ݣ�ע�⣺Object���أ������ַ���������  ��0����ţ�                    
            aTextField.setText(oa.toString());                                                  //�����ı�������ݣ�  ����Objectͨ�����й��е�toStiring()�����õ�Ŀ���ַ���
            bTextField.setText(ob.toString());                                                 //�����ı�������ݣ�  ����Objectͨ�����й��е�toStiring()�����õ�Ŀ���ַ���                                  
        }
});
    mianban.setViewportView(table);                                             //�ڹ�������м���table��� ע����������ҪsetViewportView(��,û��add
    JPanel mianban2=new JPanel();                                               //�������2�� Ҳ�������¶˵���һ�У��Ű�ť���ı���ģ�
    getContentPane().add(mianban2, BorderLayout.SOUTH);                             //�����2���뵽������ײ�
    mianban2.add(new Label("A: "));                                                     //���2��������       ���ֱ�ǩA��
    aTextField=new JTextField("A4", 10);                                                //���� �� �ı���
    mianban2.add(aTextField);                                                           //���2��������       �ı���  ��
    mianban2.add(new JLabel("B: "));                                                    //���2��������       ���ֱ�ǩB��
    bTextField=new JTextField("B4", 10);                                                //���2��������       �ı���  ��
    mianban2.add(bTextField);                                                           //���� �� �ı���
    JButton addButton=new JButton("���");                                       //����һ���µİ�ť������ӡ�
    addButton.addActionListener(new ActionListener() {                              //Ϊ����ӡ���ť��Ӷ����¼�
        public void actionPerformed(ActionEvent e) {                                    //�̶�����
            String[] rowValues={ aTextField.getText(), bTextField.getText() };              //������һ��String���飬 ���õ��������ı����е�getText������ַ���
            tableModel.addRow(rowValues);                                                   //����tableModel�������
            int rowCount=table.getRowCount()+1;                                             //����table��getRowCount����Ŀǰ���������   
            aTextField.setText("A"+rowCount);                                               //�������ı�����������ƣ�ָ����һ�н����ŵ����ݡ�
            bTextField.setText("B"+rowCount);                                               //�������ı�����������ƣ�ָ����һ�н����ŵ����ݡ�
        }
    });
    mianban2.add(addButton);                                                    //�����2��������  "���"��ť    
    JButton updButton=new JButton("�޸�");                                         //����һ��"�޸�"��ť
    updButton.addActionListener(new ActionListener() {                             //Ϊ"�޸�"��ť��Ӷ����¼�
        public void actionPerformed(ActionEvent e) {                                //�̶�������Ӧ����
            int selectedRow=table.getSelectedRow();                                    //����table��getSelectedRow����Ŀǰ��ѡ���еı��            
            if(selectedRow!=-1){                                                       //���Ŀǰ�б�ѡ�еĵ�Ԫ
                tableModel.setValueAt(aTextField.getText(), selectedRow, 0);            //���ñ���ֵ����
                tableModel.setValueAt(bTextField.getText(), selectedRow, 1);            //���ñ���ֵ����
            }
        }
    });
    mianban2.add(updButton);                                                     //�����2��������  �޸İ�ť
    
    JButton delButton=new JButton("ɾ��");                                       //�½�һ����ɾ������ť
    delButton.addActionListener(new ActionListener() {                           //Ϊ"�޸�"��ť��Ӷ����¼�
        public void actionPerformed(ActionEvent e) {                               //�̶�������Ӧ����
            int selectedRow=table.getSelectedRow();                                  //����table��getSelectedRow����Ŀǰ��ѡ���еı�� 
            if(selectedRow!=-1){                                                     //���Ŀǰ�б�ѡ�еĵ�Ԫ
                tableModel.removeRow(selectedRow);                                   //����table����removeRow����ɾ����һ��
            }
        }
    });
    mianban2.add(delButton);                                                    //�����2����������  ɾ����ť
}

}

//Χ�����������������䣺  table.setRowSorter(new TableRowSorter<>(tableModel));   Ҳ����˵����Ҫһ��tableModel���ģ��