import java.awt.*;
import javax.swing.*;
class main extends JFrame {

public main(){
setTitle("���Ǹ�ʹ���������ֹ������������մ���");      //���ô��ڱ���
Container c=getContentPane();
setLayout(new FlowLayout(2,10,10));                    //�Ҷ��룬ˮƽ�������ֱ���
for(int i=1; i<=10; i++)       c.add(new Button("��ť"+i));
setSize(500,300);                                      
setVisible(true);
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}

public static void main(String[] arg){
new main();
}

}