import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {                          
	
 private CardLayout cardLayout=new CardLayout();                                // 卡片布局管理器
 private JPanel cardPanel=new JPanel(cardLayout);                               // 放置卡片的对象面板, 使用卡片布局管理
	
    public static void main(String args[]) {
            new main().setVisible(true);
    }
	
    public main() {
    setResizable(false);
    setTitle("使用卡片布局管理器");
    setBounds(100, 100, 600, 100);
    Container cp=getContentPane();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                             //主窗口基本属性设置
		
    cp.add(cardPanel, BorderLayout.CENTER);                                     // 把 卡片面板cardPanel 加入到主窗口容器的 中间
        String[] labelNames = { "卡片A", "卡片B", "卡片C" };                        // 定义了标签名字 String 数组
            for (int i = 0; i < labelNames.length; i++) {                          //循环，创建标签
		JLabel label = new JLabel(labelNames[i]);                          //{
                    label.setHorizontalAlignment(SwingConstants.CENTER);                // 设置标签文字居中
		    label.setFont(new Font("", Font.BOLD, 16));                         // 设置标签文本的字体
	            label.setForeground(new Color(255, 0, 0));                          // 设置标签文本的颜色
	            cardPanel.add(label, labelNames[i]);                                // 向卡片面板添加 标签
		}                                                                  //}
		
            
     JPanel buttonPanel=new JPanel();                                           // 创建一个按钮面板 buttonPanel
	cp.add(buttonPanel, BorderLayout.SOUTH);                                    // 添加到窗体下方
	String[] buttonNames = { "第一个", "前一个", "卡片A", "卡片B", "卡片C", "后一个", "最后一个" };
	for (int i = 0; i < buttonNames.length; i++) {
            JButton button = new JButton(buttonNames[i]);
	    button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    String buttonText = button.getText();
                    if (buttonText=="第一个")       cardLayout.first(cardPanel); 
               else if (buttonText=="前一个")       cardLayout.previous(cardPanel); 
	       else if (buttonText=="卡片A")        cardLayout.show(cardPanel, "卡片A");
	       else if (buttonText=="卡片B")        cardLayout.show(cardPanel, "卡片B"); 
	       else if (buttonText=="卡片C")        cardLayout.show(cardPanel, "卡片C"); 
	       else if (buttonText=="后一个")       cardLayout.next(cardPanel);  
               else if (buttonText=="最后一个")     cardLayout.last(cardPanel); 
		    }
			});
           buttonPanel.add(button);
		}
	}
}

//有一点像幻灯片， 一次只能显示一个。