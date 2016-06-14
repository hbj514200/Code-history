import java.awt.*;                                                              //导入包
import java.awt.event.*;
import javax.swing.*;

public class main extends JFrame {
 JLabel label=new JLabel();
 JPopupMenu popupMenu = new JPopupMenu();                                       // 创建弹出式菜单对象 JPopupMenu
 
public static void main(String args[]){                                         //主main测试方法
    new main().setVisible(true);
}
	
	public main() {                                                         //构造方法
		setTitle("弹出式菜单窗口");                                        //以下两行为基本窗口属性设置
		setBounds(600, 300, 500, 375);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label.setText("                请在窗口中单击鼠标右键！");         //为底层标签 label 设置文字
		getContentPane().add(label, BorderLayout.CENTER);                //把文字标签 label 加入到界面容器 中间
		
		getContentPane().addMouseListener(new MouseAdapter() {     	// 为窗体的顶层容器添加鼠标事件监听器
                    public void mouseReleased(MouseEvent e) {                    // 鼠标按键被释放时触发该方法 mouseReleased
                        if (e.isPopupTrigger())                                     // 判断此次鼠标事件是否为该组件的弹出菜单触发事件 利用 isPopupTigger
                            popupMenu.show(e.getComponent(), e.getX(), e.getY());   // 如果是则在释放鼠标的位置弹出菜单
			}
		});
		
		JMenuItem cutItem = new JMenuItem("剪切");                       //新建一个菜单子对象， “剪切”。
		cutItem.addActionListener(new ItemListener());                      //添加菜单项的 响应事件（自定义的）
		popupMenu.add(cutItem);                                             //把它加入到菜单一级面板中
		
		JMenuItem copyItem = new JMenuItem("复制");                      //新建一个菜单子对象， “复制”。
		copyItem.addActionListener(new ItemListener());                     //添加菜单项的 响应事件（自定义的）     
		popupMenu.add(copyItem);                                            //把它加入到菜单一级面板中
		
		JMenuItem pastItem = new JMenuItem("粘贴");                      //新建一个菜单子对象， “粘贴”。
		pastItem.addActionListener(new ItemListener());                     //添加菜单项的 响应事件（自定义的）
		popupMenu.add(pastItem);                                            //把它加入到菜单一级面板中
		
		JMenu editMenu = new JMenu("编辑");                              //新建一个菜单层对象， “编辑”。  （菜单层对象）
		popupMenu.add(editMenu);                                            //把它加入到菜单一级面板中
		
		JMenuItem readItem = new JMenuItem("只读");                         //新建一个菜单子对象， “只读”。
		readItem.addActionListener(new ItemListener());                         //添加菜单项的 响应事件（自定义的）
		editMenu.add(readItem);                                                 //把它加入“编辑”菜单层
		
		JMenuItem writeItem = new JMenuItem("可写");                        //新建一个菜单子对象， “可写”。
		writeItem.addActionListener(new ItemListener());                        //添加菜单项的 响应事件（自定义的）
		editMenu.add(writeItem);                                                //把它加入“编辑”菜单层
		
		JMenu fontMenu = new JMenu("字体");                                 //新建一个菜单层对象， “字体”。（菜单层对象）
		editMenu.add(fontMenu);                                                 //把它加入到菜单一级面板中
		
		JMenuItem boldfacedItem = new JMenuItem("加粗");                    //新建一个菜单子对象， “加粗”。
		boldfacedItem.addActionListener(new ItemListener());                    //添加菜单项的 响应事件（自定义的）
		fontMenu.add(boldfacedItem);                                            //把它加入到字体菜单层面板中
		
		JMenuItem italicItem = new JMenuItem("斜体");                       //新建一个菜单子对象， “斜体”。
		italicItem.addActionListener(new ItemListener());                        //添加菜单项的 响应事件（自定义的）
		fontMenu.add(italicItem);                                                //把它加入到字体菜单层面板中
	}
	
    private class ItemListener implements ActionListener {                      //自定义的动作事件， 继承ActionListener
        public void actionPerformed(ActionEvent e) {                             //固定响应动作方法
            JMenuItem menuItem = (JMenuItem) e.getSource();                             //获取专递源对象
            System.out.println("您单击的是菜单项：" + menuItem.getText());                //输出 getText
		}
	}
	
}

//目前依旧难以区分Button按钮的ActionEvent和MouseEvent的区别，貌似一个是点击，另一个可以捕捉鼠标动作
//对于响应一样的动作事件， 自定义一个类继承ActionListener不错， 再配上getSource完美！！！