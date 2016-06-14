import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
class main extends JFrame {
Thread thread;
JButton jb1=new JButton("开始");          JButton jb2=new JButton("停止");

public main(){
Container cp=getContentPane();
setSize(200,100);      setVisible(true);    setDefaultCloseOperation(EXIT_ON_CLOSE);    setLayout(new FlowLayout());    setResizable(false);
cp.add(jb1);        cp.add(jb2);     
Thread thread=new Thread(new Runnable() {
    public void run() {
        int count=0;
        while(true){
            try {   Thread.sleep(100);    System.out.println(count++);    }
            catch (InterruptedException e)   {    System.out.println("输入已停止");    break;   }
        }
    }
});
jb1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)  {    thread.start();    }
});
jb2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)    {     thread.interrupt();       }
});
}

public static void main(String[] args)   {   new main();   }
    
}