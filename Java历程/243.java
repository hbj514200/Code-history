import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class main extends JFrame {                          //�̳�JFrame��

public main() {                                        
JCheckBox jc1=new JCheckBox();                       //����jc1��ѡ��
JCheckBox jc2=new JCheckBox();                       //����jc2��ѡ��
JCheckBox jc3=new JCheckBox();                       //����jc3��ѡ��
JTextArea jt=new JTextArea();                        //����һ������jt�����ֱ༭��
JPanel panel1=new JPanel();                          //����һ��JPanel��С���panel1
JPanel panel2=new JPanel();                          //����һ��JPanel��С���panel2
Container c=getContentPane();                        //��ȡһ����������
c.setLayout(new BorderLayout());                     //������ʹ�ñ߽粼�ֹ���������
c.add(panel1,BorderLayout.CENTER);                    //��panel1��JPanel�����ڴ����ϲ�
final JScrollPane scrollPane=new JScrollPane(jt);    //����һ��������༭jt��������JS����С��塣
scrollPane.setVisible(true);
panel1.add(scrollPane);                              //�Ѵ����ֱ༭��JS����С������JPanel��塣
c.add(panel2,BorderLayout.SOUTH);                          //��panel2��JPanel�̶�С�����ڴ����²�
panel2.add(jc1);		panel2.add(jc2);		panel2.add(jc3);      //������jc��ѡ�����panel2�̶�С���
jc1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
jt.append("��ѡ��1����ѡ����\n");
}
});
jc2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
jt.append("��ѡ��2����ѡ����\n");
}
});
jc3.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
jt.append("��ѡ��3����ѡ����\n");
}
});
setVisible(true);
setSize(240,320);
}

public static void main(String[] arg)   {   new main();  }

}