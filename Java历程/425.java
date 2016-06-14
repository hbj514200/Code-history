import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;

class main extends JFrame {
 JToolBar toolbar=new JToolBar("工具栏");
 
    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public main(){
    setSize(320,240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("工具栏窗口");
    
    toolbar.setFloatable(false);
    getContentPane().add(toolbar, BorderLayout.NORTH);
    
        Button xinjian=new Button("新建");
        xinjian.addActionListener(new ButtonListener());
        toolbar.add(xinjian);
        
        toolbar.addSeparator();
        
        Button save=new Button("保存");
        save.addActionListener(new ButtonListener());
        toolbar.add(save);
        
        toolbar.addSeparator(new Dimension(20, 0));

        Button exit=new Button("退出");
        exit.addActionListener(new ButtonListener());
        toolbar.add(exit);
    
}
    
public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        System.out.println("您点击的是：  "+e.getSource().toString());
    }
}

}

//按钮出现乱码！！