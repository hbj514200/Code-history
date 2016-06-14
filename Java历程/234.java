import java.awt.*;
import javax.swing.*;
class main extends JFrame {

public main(){
setTitle("我是个使用了流布局管理器的萌萌哒窗口");      //设置窗口标题
Container c=getContentPane();
setLayout(new FlowLayout(2,10,10));                    //右对齐，水平间隔，垂直间隔
for(int i=1; i<=10; i++)       c.add(new Button("按钮"+i));
setSize(500,300);                                      
setVisible(true);
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}

public static void main(String[] arg){
new main();
}

}