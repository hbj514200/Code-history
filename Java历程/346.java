import java.awt.*;                                                //�����                       
import java.awt.event.*;                                          //��Ӧʱ���
import java.io.PrintWriter;                                       //��������
import javax.swing.*;                                             //���������
import java.net.*;                                                //�����
import javax.swing.border.BevelBorder;                            //��һ�����������
class main extends JFrame {                                       //���࣬�̳�JFrame
private PrintWriter writer;                                       //����һ��PrintWriter����������õ�
Socket socket;                                                    //�������ֶ���
private JTextArea ta=new JTextArea();                             //�ı������
private JTextField tf=new JTextField();                           //�ı������
Container cp=getContentPane();                                    //��ȡһ����������

public main(String title) {                                       //������������string�ַ���
    super(title);                                                 //�趨�������ڵ�����
    setDefaultCloseOperation(EXIT_ON_CLOSE);                      //���������ڵĹرշ�ʽ                       
    final JScrollPane scrollPane=new JScrollPane();               //����һ���������
    scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));    //ʹ�������¼���ı���͹��һ��
    cp.add(scrollPane, BorderLayout.CENTER);                      //�ѹ���С�������������м�
    cp.add(tf, "South");                                          //�����ֱ༭����ڽ�����±�
    scrollPane.setViewportView(ta);                               //������ѶȵĶ���������add                 
    tf.addActionListener(new ActionListener() {                   //Ϊtf���ֿ���Ӷ�����������������
        public void actionPerformed(ActionEvent e) {              //�̶��Ķ���������
            writer.println(tf.getText());                         //���ı����еĶ���д����
            ta.append(tf.getText()+'\n');                         //��ȡ�ı��������Ȼ���͸�������������ʹ��append����
            ta.setSelectionEnd(ta.getText().length());            //
            tf.setText("");                                       //����ı��༭�������
        }
});
}

private void connect() {                                          //���ӷ���
ta.append("���ڳ������ӡ�������");                                     //�ı�������ʾ����
    try {                                                        //��������з���try
        socket=new Socket("192.168.191.1", 8998);                //��socket���ֶ������ʵ����䣬���������IP�Ͷ˿�
        writer=new PrintWriter(socket.getOutputStream(),true);   //PrintWriter�����ʵ��������������socket��getOutput()���һ������������滹����һ��true
        ta.append("���������᳤�ķ�����\n");                       //����������ʾ�ѷ��������ӳɹ�
    } catch (Exception e)    {   System.out.println("�޷����ӵ��᳤�ķ�����");   }   //�쳣����ʾ����
}

public static void main(String[] args) {                          //��main���Ժ���
 main clien=new main("С�Ϳͻ���");                           //ʵ����������࣬���췽�����봰�ڱ����ַ���
 clien.setSize(320,200);                                     //���ô��ڵĴ�С
 clien.setVisible(true);                                     //���������ڿɼ�
 clien.connect();                                            //���������ں��������Ӻ���
 clien.setDefaultCloseOperation(EXIT_ON_CLOSE);              //���������ڵĹرշ�ʽ
}
    
}

//�ı���Ҳ������Ӷ������س�����
//����������У�������ö�����͵�һ���ش���;�� �����ٽ��沼�ֹ������У��������ö�����ͣ��ֱ�̶������˼����̶���ֵ�������Ϳ����ٵ��õ�ʱ�򷽱�ʹ����ʹ�ã�������1234ֱ���˺ܶ�