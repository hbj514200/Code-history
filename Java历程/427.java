import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class main extends JFrame {

    public static void main(String args[]) {
        new main().setVisible(true);
    }
	
    public main() {
        setTitle("选择照片对话框");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("<双击选择照片>", SwingConstants.CENTER);  
        getContentPane().add(label, BorderLayout.CENTER);
        
        label.addMouseListener(new MouseAdapter() {                             //为 label 标签添加一个鼠标事件
			
            public void mouseClicked(MouseEvent e) {                                //固定响应动作方法
                JFileChooser fileChooser=new JFileChooser();                	     //创建了一个文件选择器	
		javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("图像文件（JPG/GIF）", "JPG", "JPEG", "GIF");     // 设置文件过滤器，只列出JPG或GIF格式的图片
		fileChooser.setFileFilter(filter);                                   //利用文件选择器的 setFileFilter 方法设置它的文件选择过滤规则      
		if (e.getClickCount()==2) {                                             //利用鼠标动作事件的 getClickCount 方法可以获取鼠标点击次数
                    int i = fileChooser.showOpenDialog(getContentPane());                     // 显示文件选择对话框，并记录返回结果
		    if (i == JFileChooser.APPROVE_OPTION) {                                   //表示有 JFileChooser 已经有合法的选择
			File selectedFile = fileChooser.getSelectedFile();                    //将文件选择器返回的文件对象承接下来
			label.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));         // 将图片显示到标签上
			label.setText(null);     
					}
				}
			}
		});
	}
}

//原来如果文字加入JLabel文字标签，可以设置居中显示，SwingConstants.CENTER.
//设置文件过滤器的那条语句当做模板就好了
//在一个例如匿名内部类中，不是方法的部分，可以直接{}符合语句！！