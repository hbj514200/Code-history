import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class main extends JFrame{
JScrollPane mianban=new JScrollPane();
JPanel mianban2=new JPanel(new FlowLayout());
JButton anniu=new JButton("ѡ��");
JTable table;
int x=0, y=0;
 
public static void main(String[] args) {
     new main().setVisible(true);
}

public main(){
    setTitle("ѡ������");
    setSize(640,540);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp=getContentPane();
    String[] columnNames={"1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��", "9��", "10��", "11��", "12��"};
    String[][] tableValues=new String[31][50];
    
    for(int i=0; i<30; i++)
        for(int j=0; j<12; j++)
            if(j!=2-1||(i!=29&&i!=30))   tableValues[i][j]=new Integer(i+1).toString();
            else                         tableValues[i][j]=" ";
    for(int i=0; i<12; i++) if(i+1==1||i+1==3||i+1==5||i+1==7||i+1==8||i+1==10||i+1==12)   tableValues[30][i]="31";
    
    table=new JTable(tableValues, columnNames);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    mianban.setViewportView(table);
    cp.add(mianban, BorderLayout.CENTER);
    mianban2.add(new JLabel("��ѡ������: "));
    cp.add(mianban2, BorderLayout.SOUTH);
    anniu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int yue=table.getSelectedColumn();
            int ri=table.getSelectedRow();
            if(table.getValueAt(ri, yue)==null)   {   x=0;      y=0;           new MyJDialog(main.this).setVisible(true);   }
            else                                  {   x=ri+1;   y=yue+1;       new MyJDialog(main.this).setVisible(true);   }
        }
    });
    mianban2.add(anniu);
}
    
class MyJDialog extends JDialog {
JLabel jl;
public MyJDialog(main frame){
super(frame,"������ʾ",true);
Container container=getContentPane();
if(x==0)     jl=new JLabel("�벻Ҫѡ��հ״���");
else         jl=new JLabel("��ѡ����ǣ� "+y+" �� "+x+" ��");
jl.setHorizontalAlignment(SwingConstants.CENTER);
container.add(jl);
setBounds(600,400,400,250);
setVisible(true);
}
}

}

//����һ���Լ������ҵ�������ʵ�������У���Ҫ��Ϥһ�¶���Jtable��ʹ�á� ����