import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.InputEvent.*;

class main extends JFrame {
 JMenuBar menuBar=new JMenuBar();
 JLabel wenzi=new JLabel("��ѡ��˵����������ݼ�                  ");
 JLabel biaoshi=new JLabel("                                                                                                                By ���ֳ�ʽ�� ����ʫ");
 JLabel tupian=new JLabel();
 
    public static void main(String[] args) {
        new main().setVisible(true); 
    }
    
    public main(){
        setSize(480,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("�˵��ۺϴ���");
        setResizable(false);
        setJMenuBar(menuBar);
        getContentPane().add(wenzi, BorderLayout.WEST);
        getContentPane().add(biaoshi, BorderLayout.SOUTH);
        
        Icon img=new ImageIcon(main.class.getResource("img.jpg"));
        tupian.setIcon(img);
        getContentPane().add(tupian, BorderLayout.CENTER);
        
        JMenu fileJmenu=new JMenu("�ļ� (F) ");
        fileJmenu.setMnemonic('F');
        menuBar.add(fileJmenu);
        
            JMenuItem newItem=new JMenuItem("�½� (N) ");
            newItem.setMnemonic('N');
            newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, CTRL_MASK));
            newItem.addActionListener(new ItemListener());
            fileJmenu.add(newItem);
            
            JMenu openmenu=new JMenu("�� (O) ");
            openmenu.setMnemonic('O');
            fileJmenu.add(openmenu);
            
            fileJmenu.addSeparator();
            
                JMenuItem weikaiItem=new JMenuItem("δ�򿪹��� (N) ");
                weikaiItem.setMnemonic('N');
                weikaiItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ALT_MASK|CTRL_MASK));
                weikaiItem.addActionListener(new ItemListener());
                openmenu.add(weikaiItem);
            
                JMenuItem yikaiItem=new JMenuItem("�մ򿪹��� (C) ");
                yikaiItem.setMnemonic('C');
                yikaiItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ALT_MASK|CTRL_MASK));
                yikaiItem.addActionListener(new ItemListener());
                openmenu.add(yikaiItem);
                
            JMenuItem saveItem=new JMenuItem("���� (S) ");
            saveItem.setMnemonic('S');
            saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, CTRL_MASK));
            saveItem.addActionListener(new ItemListener());
            fileJmenu.add(saveItem);
            
            fileJmenu.addSeparator();
            
            JMenuItem exitItem=new JMenuItem("�˳� (E) ");
            exitItem.setMnemonic('E');
            exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, CTRL_MASK));
            exitItem.addActionListener(new ItemListener());
            fileJmenu.add(exitItem);
            
        JMenu editJmenu=new JMenu("�༭ (E) ");
        fileJmenu.setMnemonic('E');
        menuBar.add(editJmenu);
        
            JMenuItem jianqianItem=new JMenuItem("���� (T) ");
            jianqianItem.setMnemonic('T');
            jianqianItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, CTRL_MASK));
            jianqianItem.addActionListener(new ItemListener());
            editJmenu.add(jianqianItem);    
            
            JMenuItem copyItem=new JMenuItem("���� (C) ");
            copyItem.setMnemonic('C');
            copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, CTRL_MASK));
            copyItem.addActionListener(new ItemListener());
            editJmenu.add(copyItem);   
            
            editJmenu.addSeparator();
            
            JMenuItem zhantieItem=new JMenuItem("ճ�� (P) ");
            zhantieItem.setMnemonic('P');
            zhantieItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, CTRL_MASK));
            zhantieItem.addActionListener(new ItemListener());
            editJmenu.add(zhantieItem);   
            
            editJmenu.addSeparator();
            
            JMenu frontmenu=new JMenu("���� (F) ");
            openmenu.setMnemonic('F');
            editJmenu.add(frontmenu);
                
                JCheckBoxMenuItem jiacu=new JCheckBoxMenuItem("�Ӵ� (B) ");
                jiacu.addActionListener(new ItemListener());
                jiacu.setSelected(true);
                frontmenu.add(jiacu);
                
                JCheckBoxMenuItem xieti=new JCheckBoxMenuItem("б�� (I) ");
                xieti.addActionListener(new ItemListener());
                frontmenu.add(xieti);
            
            editJmenu.addSeparator();
                
            JMenu shuxinmenu=new JMenu("���� (A) ");
            openmenu.setMnemonic('A');
            editJmenu.add(shuxinmenu);
            
                JRadioButtonMenuItem read=new JRadioButtonMenuItem("ֻ�� (R) ");
                read.addActionListener(new ItemListener());
                read.setSelected(true);
                shuxinmenu.add(read);
                
                JRadioButtonMenuItem write=new JRadioButtonMenuItem("��д (W) ");
                write.addActionListener(new ItemListener());
                shuxinmenu.add(write);
                
                    ButtonGroup group=new ButtonGroup();
                    group.add(read);
                    group.add(write);
            
        JMenu helpmenu=new JMenu("���� (H) ");
        fileJmenu.setMnemonic('H');
        menuBar.add(helpmenu);
        
            JMenuItem guanyuItem=new JMenuItem("����С�� (G) ");
            guanyuItem.setMnemonic('G');
            guanyuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, CTRL_MASK));
            guanyuItem.addActionListener(new ItemListener());
            helpmenu.add(guanyuItem);   
    }
    
    public class ItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JMenuItem item=(JMenuItem) e.getSource();
            wenzi.setText("������Ĳ˵����ǣ�   "+item.getText()+"             ");
            
            if(item.getText()=="����С�� (G) ")    JOptionPane.showMessageDialog(null, "������ϣ���Լ��Ǹ�������\n\n˼άҲ�������ԵĲ�����\n�ڴ�˼���������������֪ʵ��ı��ʣ�ȴҲ��ı������顣\n\nҲ����ʫ�ʸ��м�ֵ��\n����һ��, ��ϧ���Ǹ�������û��ʲôս�����������ױ�KO��\n\n     �� ���� �ɲ��������м��ҵ�һ��ƽ���\n       �ǻ��ֲ�ʧ��Ȥ��", "��������", JOptionPane.PLAIN_MESSAGE);
            
        }
    }
    
}