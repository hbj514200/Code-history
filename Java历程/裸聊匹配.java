import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyJDialog extends JDialog {
public MyJDialog(main frame){
super(frame,"裸聊匹配失败",true);
Container container=getContentPane();
JLabel jl=new JLabel("舍长太帅，无法匹配到适合你的美女！");
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
super("肇庆本地裸聊平台");
Container container=getContentPane();
container.setLayout(null);
JLabel jl=new JLabel("我是JLabel负责显示的部分");
jl.setHorizontalAlignment(SwingConstants.CENTER);
container.add(jl);
setVisible(true);
setSize(1024,768);
JButton bl=new JButton("匹配美女立即裸聊");
bl.setBounds(400,300,250,100);
bl.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
new MyJDialog(main.this).setVisible(true);
}
});
container.add(bl);
//听说这里省略部分代码
}

}