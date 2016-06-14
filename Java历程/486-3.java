import javax.swing.*;
import java.awt.*;

class main extends JFrame implements Runnable{
int num=0;
MyCanvas CanvasPanel=new MyCanvas();
    
public main(){
    Container cp=getContentPane();
    setSize(800,600);
    setTitle("多线程测试窗口");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.add(CanvasPanel);
    setVisible(true);
    Thread thread=new Thread(this);
    thread.start();
}
    
public static void main(String[] args) {
   new main();
}

public void run(){
    try{
      while(true){
         num=num+3;
         CanvasPanel.repaint();
         Thread.sleep(100);
        if(num>500) num=0;
     }
    }catch(InterruptedException e)  {  e.printStackTrace();  }
}


class MyCanvas extends Canvas {
    public void paint(Graphics g0){
        Graphics2D g=(Graphics2D) g0;
        g.setColor(Color.red);
        g.rotate(Math.toRadians(Math.random()*90));
        g.fillOval(100+num, 50, 30, 150);
    }
}

}