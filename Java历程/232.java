import java.awt.*;
import javax.swing.*;
import java.net.*;                                              //�������URL����ʹ�õ�ǰ��
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

public main(){
Container container=getContentPane();                             //��ȡһ��JFrame������
JLabel jl=new JLabel("�����ҵı�ֽ",JLabel.CENTER);         //����һ��JL��ǩ
URL url=main.class.getResource("imageButton.jpg");             //��ȡͼƬ��URL
Icon icon=new ImageIcon(url);                                              //ʵ����Icon����
jl.setIcon(icon);                                                     //Ϊ��ǩ����ͼƬ
jl.setHorizontalAlignment(SwingConstants.CENTER);                     //���־���
jl.setOpaque(true);                                                   //���ñ�ǩ��͸�������ɼ���
container.add(jl);
setSize(1280,720);
setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
JButton bl=new JButton("ƥ����Ů��������");
bl.setBounds(400,300,250,100);
bl.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
new MyJDialog(main.this).setVisible(true);
}
});
container.add(bl);
}

public static void main(String[] arg)   {    new main();   }

}
