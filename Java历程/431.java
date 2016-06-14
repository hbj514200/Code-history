import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class main extends JFrame {
    

	public static void main(String args[]) {
		new main().setVisible(true);
	}
	
	public main() {
		setTitle("使用桌面集成控件 窗口");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JButton dickButton = new JButton();
		dickButton.addActionListener(new ButtonListener(1));
		dickButton.setText("打开编程词典网");
		panel.add(dickButton);
		
		final JButton noteButton = new JButton();
		noteButton.addActionListener(new ButtonListener(2));
                noteButton.setText("打开记事本");
		panel.add(noteButton);
		
		final JButton wordButton = new JButton();
		wordButton.addActionListener(new ButtonListener(0));
		wordButton.setText("打开Word");
		panel.add(wordButton);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		int index;
		
		public ButtonListener(int index) {    this.index = index;   }
		
		public void actionPerformed(ActionEvent e) {
			try {
                              if (Desktop.isDesktopSupported()) {                 // 判断系统是否提供了对该类的支持
                              Desktop desktop = Desktop.getDesktop();             // 获得该类的对象
	switch (index) {
		case 1:    if (desktop.isSupported(Desktop.Action.BROWSE))            // 判断是否支持“浏览”动作
                                desktop.browse(new URI("http://www.mrbccd.com"));   // 浏览网站
                                    break;
		case 2:
			   if (desktop.isSupported(Desktop.Action.EDIT))
				desktop.edit(new File("src/new.txt"));                  // 编辑记事本
			            break;
		default:   if (desktop.isSupported(Desktop.Action.OPEN))
				desktop.open(new File("src/new.doc"));             // 打开Word
	}
}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}

//桌面集成类是 Desktop ， 其对象中的isSupported(参数) 方法可以返回当前系统是否支持某些功能，     例如desktop.open（new file文件），  Edit BROWSE等等。。

//还有一个：   当多个按钮调用同一个响应事件时， 可以传入一个参数index，  事件对象就可以根据index的值判断哪里来源，  并作出不同的反应。    此举代码非常清晰！！