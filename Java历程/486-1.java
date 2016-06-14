import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

class main extends JFrame {
    
public main(){
    MyCanvas CanvasPanel=new MyCanvas();
    setSize(800,600);
    setTitle("»æÍ¼×÷Òµ");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(CanvasPanel);
}

public static void main(String[] args) {
    new main().setVisible(true);
}

class MyCanvas extends Canvas {
    public void paint(Graphics g){
        int[] x={300,400,200};
        int[] y={300,400,500};
        g.drawOval(100,100,100,100);
        g.drawOval(100,300,200,100);
        g.drawRect(10, 10, 100, 50);
        g.drawPolygon(x, y, 3);
    }
}
    
}
