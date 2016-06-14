import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {
 JProgressBar progressBar=new JProgressBar();
 JButton button=new JButton("完成");

    public static void main(String[] args) {
        new main().setVisible(true);
    }
 
public main(){
    setSize(240, 150);
    setTitle("进度条模拟升级窗口");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    Container cp=getContentPane();                                              // 主窗口界面容器
    cp.setLayout(new FlowLayout());
    
    cp.add(progressBar);                                                         // 进度条
        progressBar.setStringPainted(true);
        new Progress(progressBar, button).start();
    
    cp.add(button);                                                              // 按钮
        button.setEnabled(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
    });
}
    
public class Progress extends Thread {                                          //多线程的进度条
  JProgressBar progressBar;                                                         //创建一个 进度条
  JButton button;                                                                   //创建一个 按钮
  
    public Progress(JProgressBar progressBar, JButton button){                   //构造方法，参数传递
        this.button=button;         this.progressBar=progressBar;
    }
    
    public void run(){
        for(int i=0; i<100; i++){
            try {
                Progress.sleep(60);
                progressBar.setValue(i);
            } catch (Exception e) {         System.out.println("run()方法报错！");
            }
        }
            progressBar.setIndeterminate(false);
            progressBar.setString("升级完成！");
            button.setEnabled(true);
    }
    
}
    
}

//这个……  内部类的使用还是越来越广泛了……
//原来定义一个新的 “对象” 只要没有new。  那么使用复制= 的话，只是一个遥控器， 相当于 指针