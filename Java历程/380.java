import java.awt.*;                                                              //�����
import java.util.Vector;                                                        //Vector������
import javax.swing.*;                                                           //���������
import javax.swing.table.*;                                                     //���ӱ���
class main extends JFrame {                                                     //���࣬ �̳�JFrame
 
public static void main(String[] arg)       {   new main();     }               //��main���Ժ���

public main(){                                                                  //������
setTitle("����EXcel���");                                                       //���������ڱ�������
setSize(500,375);                                                               //���������ڵĴ�С
setDefaultCloseOperation(EXIT_ON_CLOSE);                                        //���������ڵĹرշ�ʽ
JScrollPane mianban=new JScrollPane();                                          //����һ������С���
getContentPane().add(mianban);                                                  //�ѹ���С�������������
String[] columnNames={"A","B","C","D","E","F","G"};                             //����һ���ַ���string���飬��ʾ���ͷ
Vector<String> columnNameV=new Vector<>();                                      //����һ�����������ݵ��ַ���string����
for(int column=0; column<columnNames.length; column++)    columnNameV.add(columnNames[column]);    //���ͷ���б�����  �ѱ��ͷ�ַ��������ڵ��������˽�ȥ   
Vector<Vector<String>> tableValueV=new Vector<>();                              //����һ����tableValueV���������������ַ����������ڴ�ű������
for(int row=1; row<21; row++){                                                  //�����ǰ���ѭ��
    Vector<String> rowV=new Vector<>();                                         //ÿ��ѭ���ﴴ����һ��С�ַ���������rowV���ڴ��ÿһ�еı������
    for(int column=0; column<columnNames.length; column++)      rowV.add(columnNames[column]+row);   //�ڲ�Сѭ��������ÿ�б��ͷ���飬�����������������滹��������row��
    tableValueV.add(rowV);                                                      //���������ÿ�ζ�����һ��С��������
}
JTable table=new JTable(tableValueV, columnNameV);                              //�������ӱ����������������������������Ǳ��ͷ����
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);                                //�رձ����Զ���������(�������洰�ڴ�С�仯)
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);                    //ѡ��ģʽΪ��ѡ�����ɶ�ѡ
table.setSelectionBackground(Color.yellow);                                     //��ѡ���еı����ǻ�ɫ
table.setSelectionForeground(Color.red);                                        //��ѡ���е������Ǻ�ɫ
table.setRowHeight(30);                                                         //ÿ�е��и�30
mianban.setViewportView(table);                                                 //�������ͱ�����ʹ涨�йز�Ӧ��add�� ����ʹ��setViewportVoew�������ѱ�������ӽ�ȥ
setVisible(true);                                                               //ʹ�����ڿɼ�
}


//ԭ��������������ʱ�����Ǻ�����V������namesV����ʵV����Vector������