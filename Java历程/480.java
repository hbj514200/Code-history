import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
class main extends JFrame {
    
private int dx1, dy1, dx2, dy2;
private int sx1, sy1, sx2, sy2;
private MyCanvas canvasPanel=new MyCanvas();
//URL imgurl=main.class.getResource("img.jpg");
private Image img=Toolkit.getDefaultToolkit().getImage(main.class.getResource("img.jpg"));
   
public main(){
    dx2=sx2=300;
    dy2=sy2=200;
    JButton anniu1=getButton1();            JButton anniu2=getButton2();
    Container cp=getContentPane();
    cp.setLayout(new BorderLayout());
    Panel xia=new Panel(new FlowLayout());       xia.add(anniu1);  xia.add(anniu2);
    cp.add(xia, BorderLayout.SOUTH);
    cp.add(canvasPanel);
    setSize(320,220);
    setTitle("图片翻转");
    setVisible(true);
}

public static void main(String[] args) {
    new main();
}

private JButton getButton1(){
    JButton anniu=new JButton("水平翻转");
    anniu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            sx1=Math.abs(sx1-300);
            sx2=Math.abs(sx2-300);
            canvasPanel.repaint();
        }
    });
    return anniu;
}

private JButton getButton2(){
    JButton anniu=new JButton("垂直翻转");
    anniu.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            sy1=Math.abs(sy1-200);
            sy2=Math.abs(sy2-200);
            canvasPanel.repaint();
        }
    });
    return anniu;
}

class MyCanvas extends Canvas {
    public void paint(Graphics g){
        g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, this);
    }
}

}

//注： 本例需要同目录下有一个img.jpg图片，分辨率300*200.
//在这个例子中， 有一个很重要的地方：  利用两个getButton的方法利用返回形式，来创建了两个不同的按钮，清晰明了！！！！   可以借鉴