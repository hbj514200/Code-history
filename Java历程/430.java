import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {
    
    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public main(){
    setSize(320, 240);
    setTitle("系统托盘 窗口");
    Container cp=getContentPane();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImageIcon icon=new ImageIcon(main.class.getResource("img.jpg"));
    
    if(SystemTray.isSupported()==false) {
        System.out.println("您的系统不支持托盘");
        System.exit(0);
    }
    
    MenuItem item=new MenuItem("退出");
    PopupMenu popupMenu=new PopupMenu();
    popupMenu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
        }
    });
        
    TrayIcon trayIcon=new TrayIcon(icon.getImage(), "使用系统托盘", popupMenu);
    SystemTray systemTray=SystemTray.getSystemTray();
    try                 {       systemTray.add(trayIcon);       }
     catch (Exception e){       e.printStackTrace();            }
}
    
}

// System.isSupported() 方法可以查看目前系统是否支持 系统托盘 功能
// 托盘上使用的是 弹出式菜单 PopupMenu