import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyJDialog extends JDialog {
public MyJDialog(main frame){
super(frame,"����ƥ��ʧ��",true);
Container container=getContentPane();
JLabel jl=new JLabel("�᳤̫˧���޷�ƥ�䵽�ʺ������Ů��");
jl.setHorizontalAlignment(SwingConstants.CENTER);
container.add(jl);
setBounds(600,400,400,250);
setVisible(true);
}
}

class main extends JFrame {

public static void main(String[] arg){
new main();
}

public main(){
super("���챾������ƽ̨");
Container container=getContentPane();
container.setLayout(null);
JLabel jl=new JLabel("����JLabel������ʾ�Ĳ���");
jl.setHorizontalAlignment(SwingConstants.CENTER);
container.add(jl);
setVisible(true);
setSize(1024,768);
JButton bl=new JButton("ƥ����Ů��������");
bl.setBounds(400,300,250,100);
bl.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
new MyJDialog(main.this).setVisible(true);
}
});
container.add(bl);
//��˵����ʡ�Բ��ִ���
}

}