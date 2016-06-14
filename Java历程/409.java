import java.awt.*;
import javax.swing.*;

class main extends JFrame {
    
public static void main(String[] args) {
    new main().setVisible(true);
}
    
public main(){
    super();
    setTitle("�ָ����ʵ������");
    setBounds(100,100,500,375);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JSplitPane hSplitPane=new JSplitPane();                                     //������һ����ֱ�ķָ����� split�����Ƿָ�, �ָ���Ĭ�Ͼ���ˮƽ�ָ��
    hSplitPane.setDividerLocation(40);                                          //������ֱ�ָ������Ϊ���40����
    getContentPane().add(hSplitPane, BorderLayout.CENTER);                      //�������ֱ�ָ��������������
    hSplitPane.setLeftComponent(new JLabel("     1"));                          //�ָ������������
    
    JSplitPane vSplitPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);            //������һ��ˮƽ�ָ����� ����JSplitPane.VERTICAL_SPLIT ��ʾ�ⶫ���Ǻ��ŵ�
    vSplitPane.setDividerLocation(30);                                          //����ˮƽ�ָ����Ϸ����30
    vSplitPane.setDividerSize(8);                                               //���÷ָ������������
    vSplitPane.setOneTouchExpandable(true);                                     //�ṩUI�շ�С������С���Ǽ�ͷ��
    
    
    hSplitPane.setRightComponent(vSplitPane);                                   //��ֱ�ָ�����ˮƽ�ָ����ӵ������ұ�
    vSplitPane.setLeftComponent(new JLabel("      2"));                         //ˮƽ�ָ�������������ϱ�������ֱ�ǩ���
    vSplitPane.setRightComponent(new JLabel("       3"));                       //ˮƽ�ָ�������������±�������ֱ�ǩ���                       
}

}


//�ָ���Ҫ�趨�����ȵĻ��� Ĭ���ǣ�  �ϡ�  ��  ָ����setDivierLocation()����
//�ڷָ�������������ʱҲ��   ��=��    ��=�ң�  Ҳ����˵û��setUpComponent()����
//���ڷָ����ķ��ö��ԣ� Ҳ����ѭ��ԭ���������һ���Ļ������ԭ��ֻ����û���˼ӵ��������ָ��ֻ�а�����ָ����ӵ��Ǹ��ָ����ı����ֲ���
//���ڣ�setOneTouchExpandable(�������� ���ڷָ����Ϸ�������С���ǣ�ʹ���ǲ�������������С���Ĺ���
//�ָ���������ʱû�з�����ô��������������������