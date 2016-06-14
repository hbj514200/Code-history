import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.InputEvent.*;

class main extends JFrame {
 JMenuBar menuBar=new JMenuBar();
 JLabel wenzi=new JLabel("请选择菜单，用鼠标或快捷键                  ");
 JLabel biaoshi=new JLabel("                                                                                                                By 左手程式， 右手诗");
 JLabel tupian=new JLabel();
 
    public static void main(String[] args) {
        new main().setVisible(true); 
    }
    
    public main(){
        setSize(480,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("菜单综合窗口");
        setResizable(false);
        setJMenuBar(menuBar);
        getContentPane().add(wenzi, BorderLayout.WEST);
        getContentPane().add(biaoshi, BorderLayout.SOUTH);
        
        Icon img=new ImageIcon(main.class.getResource("img.jpg"));
        tupian.setIcon(img);
        getContentPane().add(tupian, BorderLayout.CENTER);
        
        JMenu fileJmenu=new JMenu("文件 (F) ");
        fileJmenu.setMnemonic('F');
        menuBar.add(fileJmenu);
        
            JMenuItem newItem=new JMenuItem("新建 (N) ");
            newItem.setMnemonic('N');
            newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, CTRL_MASK));
            newItem.addActionListener(new ItemListener());
            fileJmenu.add(newItem);
            
            JMenu openmenu=new JMenu("打开 (O) ");
            openmenu.setMnemonic('O');
            fileJmenu.add(openmenu);
            
            fileJmenu.addSeparator();
            
                JMenuItem weikaiItem=new JMenuItem("未打开过的 (N) ");
                weikaiItem.setMnemonic('N');
                weikaiItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ALT_MASK|CTRL_MASK));
                weikaiItem.addActionListener(new ItemListener());
                openmenu.add(weikaiItem);
            
                JMenuItem yikaiItem=new JMenuItem("刚打开过的 (C) ");
                yikaiItem.setMnemonic('C');
                yikaiItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ALT_MASK|CTRL_MASK));
                yikaiItem.addActionListener(new ItemListener());
                openmenu.add(yikaiItem);
                
            JMenuItem saveItem=new JMenuItem("保存 (S) ");
            saveItem.setMnemonic('S');
            saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, CTRL_MASK));
            saveItem.addActionListener(new ItemListener());
            fileJmenu.add(saveItem);
            
            fileJmenu.addSeparator();
            
            JMenuItem exitItem=new JMenuItem("退出 (E) ");
            exitItem.setMnemonic('E');
            exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, CTRL_MASK));
            exitItem.addActionListener(new ItemListener());
            fileJmenu.add(exitItem);
            
        JMenu editJmenu=new JMenu("编辑 (E) ");
        fileJmenu.setMnemonic('E');
        menuBar.add(editJmenu);
        
            JMenuItem jianqianItem=new JMenuItem("剪切 (T) ");
            jianqianItem.setMnemonic('T');
            jianqianItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, CTRL_MASK));
            jianqianItem.addActionListener(new ItemListener());
            editJmenu.add(jianqianItem);    
            
            JMenuItem copyItem=new JMenuItem("复制 (C) ");
            copyItem.setMnemonic('C');
            copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, CTRL_MASK));
            copyItem.addActionListener(new ItemListener());
            editJmenu.add(copyItem);   
            
            editJmenu.addSeparator();
            
            JMenuItem zhantieItem=new JMenuItem("粘贴 (P) ");
            zhantieItem.setMnemonic('P');
            zhantieItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, CTRL_MASK));
            zhantieItem.addActionListener(new ItemListener());
            editJmenu.add(zhantieItem);   
            
            editJmenu.addSeparator();
            
            JMenu frontmenu=new JMenu("字体 (F) ");
            openmenu.setMnemonic('F');
            editJmenu.add(frontmenu);
                
                JCheckBoxMenuItem jiacu=new JCheckBoxMenuItem("加粗 (B) ");
                jiacu.addActionListener(new ItemListener());
                jiacu.setSelected(true);
                frontmenu.add(jiacu);
                
                JCheckBoxMenuItem xieti=new JCheckBoxMenuItem("斜体 (I) ");
                xieti.addActionListener(new ItemListener());
                frontmenu.add(xieti);
            
            editJmenu.addSeparator();
                
            JMenu shuxinmenu=new JMenu("属性 (A) ");
            openmenu.setMnemonic('A');
            editJmenu.add(shuxinmenu);
            
                JRadioButtonMenuItem read=new JRadioButtonMenuItem("只读 (R) ");
                read.addActionListener(new ItemListener());
                read.setSelected(true);
                shuxinmenu.add(read);
                
                JRadioButtonMenuItem write=new JRadioButtonMenuItem("可写 (W) ");
                write.addActionListener(new ItemListener());
                shuxinmenu.add(write);
                
                    ButtonGroup group=new ButtonGroup();
                    group.add(read);
                    group.add(write);
            
        JMenu helpmenu=new JMenu("帮助 (H) ");
        fileJmenu.setMnemonic('H');
        menuBar.add(helpmenu);
        
            JMenuItem guanyuItem=new JMenuItem("关于小祥 (G) ");
            guanyuItem.setMnemonic('G');
            guanyuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, CTRL_MASK));
            guanyuItem.addActionListener(new ItemListener());
            helpmenu.add(guanyuItem);   
    }
    
    public class ItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JMenuItem item=(JMenuItem) e.getSource();
            wenzi.setText("您点击的菜单项是：   "+item.getText()+"             ");
            
            if(item.getText()=="关于小祥 (G) ")    JOptionPane.showMessageDialog(null, "制作者希望自己是个艺术家\n\n思维也许是神性的残留，\n在纯思的世界里更容易认知实物的本质，却也真的冰冷无情。\n\n也许是诗词更有价值，\n但是一点, 可惜的是搞这个真的没有什么战斗力，很容易被KO。\n\n     我 凡人 可不可以在中间找到一个平衡点\n       智慧又不失情趣？", "关于作者", JOptionPane.PLAIN_MESSAGE);
            
        }
    }
    
}