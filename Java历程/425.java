import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;

class main extends JFrame {
 JToolBar toolbar=new JToolBar("������");
 
    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public main(){
    setSize(320,240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("����������");
    
    toolbar.setFloatable(false);
    getContentPane().add(toolbar, BorderLayout.NORTH);
    
        Button xinjian=new Button("�½�");
        xinjian.addActionListener(new ButtonListener());
        toolbar.add(xinjian);
        
        toolbar.addSeparator();
        
        Button save=new Button("����");
        save.addActionListener(new ButtonListener());
        toolbar.add(save);
        
        toolbar.addSeparator(new Dimension(20, 0));

        Button exit=new Button("�˳�");
        exit.addActionListener(new ButtonListener());
        toolbar.add(exit);
    
}
    
public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        System.out.println("��������ǣ�  "+e.getSource().toString());
    }
}

}

//��ť�������룡��