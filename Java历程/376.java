
import java.awt.*;                                                              //�����
import java.util.Vector;                                                        //���껹������util����Vector����������
import javax.swing.*;                                                           //���������
import javax.swing.table.JTableHeader;                                          //���գ�  ���Զ�ʹ����tableС���е�JTableHeader����
class main extends JFrame {                                                     //���࣬�̳�JFrame
    
public static void main(String[] args)      {   new main();     }               //��main���Ժ���
     
public main(){                                                                  //������
setTitle("���ɹ�����С��  Excel");                                                //����
setSize(480,320);                                                               //���������ڱ�������
setDefaultCloseOperation(EXIT_ON_CLOSE);                                        //���������ڵĹرշ�ʽ
Vector<String> columNameV=new Vector<>();                                       //����һ���ַ���string���������ڴ�ű�ǩ��
columNameV.add("A");                                                            //���ǩ����������ַ�����A��
columNameV.add("B");                                                            //���ǩ����������ַ�����B��
columNameV.add("C");                                                            //���ǩ����������ַ�����C��
columNameV.add("D");                                                            //���ǩ����������ַ�����D��
Vector<Vector<String>> tableValueV=new Vector<>();                              //������һ������ַ���string���������������ڱ�ʾ�������
for(int row=1; row<6; row++){                                                   //6�ε�forѭ��
Vector<String> rowV=new Vector<>();                                             //����for�ڲ���һ���ַ���string����
rowV.add("A"+row);                                                              //����һ�е�����ѡ��������forѭ���������
rowV.add("B"+row);                                                              //ͬ��
rowV.add("C"+row);                                                              //ͬ��
rowV.add("D"+row);                                                              //ͬ��
tableValueV.add(rowV);                                                          //��ÿһ�е�string������������
}
JTable table=new JTable(tableValueV,columNameV);                                //����һ�����
getContentPane().add(table,BorderLayout.CENTER);                                //ֱ��������������룬������û�й�����
JTableHeader tableHeader=table.getTableHeader();                                //������һ�����ͷ��  ʹ�õ��Ǳ������getTableHeader()����
getContentPane().add(tableHeader,BorderLayout.NORTH);                           //�ѱ��ͷ���˽�ȥ
setVisible(true);                                                               //���������ڿɼ�
}

}

//���������õĴ�������Ļ�����getContentPane()�����棬ʹ�ô�����Ӽ��
//����ǽ����ֱ����ӵ�������(������С���)����ô����ǲ�����ֱ�ǩ���ģ�����Ϊ��ĳЩ�ط�ֱ��ʹ�á�����Ҫ���ͷ�Ļ�ʹ�õ��ӱ���getTableHeader()�������һ�����ͷ����
//����ʹ����һ�������е�������Ҳ���Ƕ�ά��������ʾ��ά����