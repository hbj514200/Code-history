import java.awt.*;
import javax.swing.*;

class main extends JFrame {
    
public static void main(String[] args) {
    new main().setVisible(true);
}
    
public main(){
    Container cp=getContentPane();
    setSize(300,350);
    setTitle("彩色五环作业");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.add(new MyCanvas());
}

class MyCanvas extends Canvas {
    public void paint(Graphics g0){
        Graphics2D g=(Graphics2D) g0;
        g.setColor(Color.BLUE);          g.drawOval(10, 10, 80, 80);
        g.setColor(Color.BLACK);          g.drawOval(80, 10, 80, 80);
        g.setColor(Color.RED);           g.drawOval(150, 10, 80, 80);
        g.setColor(Color.YELLOW);          g.drawOval(50, 70, 80, 80);
        g.setColor(Color.GREEN);          g.drawOval(120, 70, 80, 80);
        
        g.setColor(Color.CYAN);
        g.fillRect(30,160,200,80);
        
       Font font=new Font("宋体", 1, 14);
       g.setFont(font);
       g.setColor(Color.BLACK);
       g.drawString("现在的时间是： ", 35, 180);
       g.drawString("2016年3月26日 晚上10点", 50, 210);
    }
}

}