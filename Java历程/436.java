import java.awt.*;
import javax.swing.*;

class main extends JFrame {
    
    public static void main(String[] args) {
        new main().setVisible(true);
    }
    
public main(){
    setSize(320, 240);
    setResizable(false);
    setTitle("��ʽ���ֹ�����");
    Container cp=getContentPane();
    setDefaultCloseOperation(EXIT_ON_CLOSE);                                    // ���������������ڵĻ�����������
    
    Box box=Box.createVerticalBox();                                            // ������һ�� ��ֱ��ʽ���ֹ����� box    ���󴰿ڵĴ󲼾֣�
    cp.add(box, BorderLayout.CENTER);                                               // �� box �ӵ������������м� 
    box.add(Box.createVerticalStrut(5));                                            // box �����һ��5���صĴ�ֱ֧��
    
    Box topicBox=Box.createHorizontalBox();                                     // ������һ������ ˮƽ��ʽ���ֹ����� topicBox
    cp.add(topicBox, BorderLayout.NORTH);                                           // �� topicBox ���뵽�����������Ϸ�
    topicBox.add(Box.createHorizontalStrut(5));                                     // topicBox �������һ��5���ؿ��ˮƽ֧��
    JLabel topiclabel=new JLabel("���⣺ ");                                         // ����һ�����ֱ�ǩ topiclabel �����ݣ����⣩
    topicBox.add(topiclabel);                                                           //�� topiclabel ���뵽 topicBox �� 
    topicBox.add(Box.createHorizontalStrut(5));                                     // topicBox �������һ��5���ؿ��ˮƽ֧��
    JTextField topicTextField=new JTextField(30);                                   // ����һ�������ı��� topicTextField
    topicBox.add(topicTextField);                                                       //�� topicTextField ���뵽 topicBox ��  
    
    Box contentBox=Box.createHorizontalBox();                                   // ������һ�� ˮƽ��ʽ���ֹ����� contentBox
    contentBox.setAlignmentX(1);                                                    // contenBox    ˮƽ���������Ҷ���
    box.add(contentBox);                                                        //�� contentBox ���뵽������ box ��
    contentBox.add(Box.createHorizontalStrut(5));                                   // contentBox �������һ��5���ؿ��ˮƽ֧��
    JLabel contJLabel=new JLabel("���ݣ� ");                                     // ����һ�����ֱ�ǩ contlabel �����ݣ����ݣ�
    contJLabel.setAlignmentY(0);                                                    // ��ǩ ���϶���
    contentBox.add(contJLabel);                                                     // �� contBox ��� contlabel
    contentBox.add(Box.createHorizontalStrut(5));                               // contBox �������һ��5���ؿ��ˮƽ֧��
    
    JScrollPane mianban=new JScrollPane();                                      // ����һ������С��� mianban
    mianban.setAlignmentY(0);                                                       // �������� ���϶���
    contentBox.add(mianban);                                                        // �� contBox ���� mianban
    JTextArea contenTextArea=new JTextArea();                                       // ����һ���ı��� contTextArea
    contenTextArea.setLineWrap(true);                                                   // �����ı��� �Զ�����
    mianban.setViewportView(contenTextArea);                                            //�� mianban �����ı��� setViewportView
    box.add(Box.createVerticalStrut(5));                                        //box ��� ��ֱ֧�� �������֣�        
    
    JButton fasongButton=new JButton("ȷ��");
    fasongButton.setAlignmentX(1);                                              //��ť ���Ҷ���
    box.add(fasongButton);
}
    
}

// ��ֱ����ķָ�֧��Ҳ�д�ֱ֧���� ˮƽ����ķָ�֧��Ҳ��ˮƽ֧����    ���ڷֿ���ͬ����������Ƕ�ճ��һ��add(Box.creat��������)
// ��ͬ������Խ���ʹ�ã� �������һ���� С���������塣
// ���ö���ʱ ��ʵ�õ����м���뷽ʽ��   �������������������ϸ�����������������롭��