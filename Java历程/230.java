import java.awt.*;
import javax.swing.*;

class main implements Icon {
private int width, height;
public int getIconHeight()             {  return this.height;  }
public int getIconWidth()              {  return this.width;   }
public main(int width, int height) {  this.width=width;  this.height=height;  }
public void paintIcon(Component arg0, Graphics arg1, int x, int y)
                                       {  arg1.fillOval(x,y,width,height);   }

public static void main(String[] arg){
main icon=new main(300,300);
JLabel jl=new JLabel("这面黑镜子里面的人最帅！",icon,SwingConstants.CENTER);
jl.setSize(500,500);
JFrame jf=new JFrame("741 舍长专用Java窗口");
Container c=jf.getContentPane();
jf.setVisible(true);
jf.setSize(1024,768);
jf.add(jl);
}

}