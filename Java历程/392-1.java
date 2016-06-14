import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class main extends JFrame{
JScrollPane mianban=new JScrollPane();
JPanel mianban2=new JPanel(new FlowLayout());
JButton anniu=new JButton("选择");
JTable table;
int x=0, y=0;
 
public static void main(String[] args) {
     new main().setVisible(true);
}

public main(){
    setTitle("选择日期");
    setSize(640,540);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp=getContentPane();
    String[] columnNames={"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
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
    mianban2.add(new JLabel("请选择日期: "));
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
super(frame,"操作提示",true);
Container container=getContentPane();
if(x==0)     jl=new JLabel("请不要选择空白处！");
else         jl=new JLabel("你选择的是： "+y+" 月 "+x+" 日");
jl.setHorizontalAlignment(SwingConstants.CENTER);
container.add(jl);
setBounds(600,400,400,250);
setVisible(true);
}
}

}

//这是一个自己打的作业，在这个实例代码中，主要熟悉一下对于Jtable的使用。 操作