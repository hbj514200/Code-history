import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {
    
    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public main(){
    setSize(320, 240);
    setTitle("ϵͳ���� ����");
    Container cp=getContentPane();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImageIcon icon=new ImageIcon(main.class.getResource("img.jpg"));
    
    if(SystemTray.isSupported()==false) {
        System.out.println("����ϵͳ��֧������");
        System.exit(0);
    }
    
    MenuItem item=new MenuItem("�˳�");
    PopupMenu popupMenu=new PopupMenu();
    popupMenu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
        }
    });
        
    TrayIcon trayIcon=new TrayIcon(icon.getImage(), "ʹ��ϵͳ����", popupMenu);
    SystemTray systemTray=SystemTray.getSystemTray();
    try                 {       systemTray.add(trayIcon);       }
     catch (Exception e){       e.printStackTrace();            }
}
    
}

// System.isSupported() �������Բ鿴Ŀǰϵͳ�Ƿ�֧�� ϵͳ���� ����
// ������ʹ�õ��� ����ʽ�˵� PopupMenu