import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {

    public static void main(String[] args) {
        new main().setVisible(true);
    }
 
public main(){
    Container cp=getContentPane();
    cp.setLayout(new FlowLayout());
    setSize(320, 240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("文件选择窗口");
    
    JButton button=new JButton("选择文件");
    cp.add(button);
    
    TextField wenzi=new TextField(30);
    cp.add(wenzi);
    
    
    button.addActionListener(new ActionListener() {                             //为 按钮 添加动作事件
        public void actionPerformed(ActionEvent e) {                              //固定响应动作方法
            JFileChooser fileChooser=new JFileChooser();                                //创建一个文件选择对象 FileChooser 。
            int i=fileChooser.showOpenDialog(getContentPane());                         //显示 文件选择窗口
            if(i==JFileChooser.APPROVE_OPTION){                                         //判断用户单机的是不是 “打开” 按钮
                File selectedFile=fileChooser.getSelectedFile();                        //定义 File 对象 ，  文件选择器的getSelectedFile方法 返回被选择的文件
                wenzi.setText(selectedFile.getName());                                  //又是文件的 getName()方法 获取文件名， 并显示在wenzi文本框中。
            }
        }
    });
}
    
}

//选择文件还是要io包的支持
// FileChooser 是文件选择器
//而 int i=fileChooser.showOpenDialog(getContentPane()); 是一个固定语句，显示一个文件选择框，  i则表示用户选择的状态， 例如i=1， 表示用户点击了 确定 按钮选择了文件