import java.awt.*;                                                              //�����
import java.awt.event.*;                                                        //������Ӧ��
import javax.swing.*;                                                           //���������
import java.net.*;                                                              //�����
class main extends JFrame implements Runnable,ActionListener {                  //���࣬�̳�JFrame��Ϊ���ڣ�ʵ�ֶ��̺߳Ͷ����¼��ӿڡ�
int port;                                                                       //��Ա������ �˿�
InetAddress group=null;                                                         //��Ա������ �����ַ����
MulticastSocket socket=null;                                                    //��Ա�������㲥
JButton open=new JButton("��ʼ����");                                            //��Ա��������ť1
JButton stop=new JButton("ֹͣ����");                                            //��Ա��������ť2
JTextArea inceAr=new JTextArea(10,10); 
//��Ա���������ܹ㲥���ı���
JTextArea inced=new JTextArea(10,10);                                           //��Ա���������ܹ㲥���ı���
Thread thread;                                                                  //��Ա�������յĶ��̴߳��
boolean b=false;                                                                //��ҲҪ���壿������  �Ҳ�
    
public main(){                                                                  //�����ں���
super("���ٵ�����֯���ܹ㲥");                                                     //JFrame��super()���趨���ڱ���
setDefaultCloseOperation(EXIT_ON_CLOSE);                                        //���ô��ڵĹرշ�ʽ
thread=new Thread(this);                                                        //�������̴߳�磬�ѱ������˽�ȥ��ʵ��runnable
open.addActionListener(this);                                                   //Ϊ���ܰ�ť��Ӷ����¼�
stop.addActionListener(this);                                                   //Ϊֹͣ��ť��Ӷ����¼�
inceAr.setForeground(Color.blue);                                               //��������������������������������
JPanel north=new JPanel();                                                      //����һ�����������
north.add(open);    north.add(stop);                                            //��������������ť
getContentPane().add(north, BorderLayout.NORTH);                                //�������������������
JPanel center=new JPanel();                                                     //����һ���в��̶����
center.setLayout(new GridLayout(1,2));                                          //����������ڲ�ʹ�����񲼾ֹ�����Ϊ����
center.add(inceAr);     center.add(inced);                                      //���в��������������ı���
getContentPane().add(center, BorderLayout.CENTER);                              //���в����������������
validate();                                                                     //������ˢ�½���
port=9898;                                                                      //�趨�˿�Ϊ9898
    try {                                                                       //��������з���try
        group=InetAddress.getByName("224.225.10.0");                            //����InetAdress��getbyname�������԰�group��ipʵ����
        socket=new MulticastSocket();                                           //ʵ�����㲥����socket
        socket.joinGroup(group);                                                //��socket����������
    } catch (Exception e)   {   System.out.println("�����36�б���");  }         //�쳣����ʾ
setBounds(100,50,360,380);                                                      //�趨���ڴ�С��λ��
setVisible(true);                                                               //���ô��ڿɼ�
}

public void run(){                                                              //���̶̹߳�run����
while (true) {                                                                  //����ѭ��
    byte data[]=new byte[1024];                                                 //�½�һ���ֽ�����
    DatagramPacket packet=null;                                                 //����һ���յ�UDP���ݰ�
    packet=new DatagramPacket(data, data.length, group, port);                  //UDP���ݰ�ʵ�������������ֽ����飬���ȣ�������󣬶˿�
    try {                                                                       //��������з���try
        socket.receive(packet);                                                 //�㲥���ֽ���UDP���ݰ�
        String message=new String(packet.getData(), 0, packet.getLength());     //��packet.getdata()�����ܵ��Ķ���ת��Ϊ�ַ�����0�ͳ���getlength
        inceAr.setText("���ڽ��ܽ����ܲ�����Ϣ: \n"+message);                      //���ı�����ʾĿǰ����
        inced.append(message+'\n');                                             //�����¼��ʾ
    } catch (Exception e)    {      System.out.println("���ܽ������ָʾ��Ϣʧ��");       }     //�쳣�ı���
    if(b==true)     break;                                                      //���ֹͣ���ܵĻ�����
}
}

public void actionPerformed(ActionEvent e){                                     //�¼���Ӧ����
if(e.getSource()==open){                                                        //����ǿ�ʼ��ť�ĵ��������ifģ��
    open.setBackground(Color.red);                                              //��ť��ɫ
    stop.setBackground(Color.yellow);                                           //��ť��ɫ
    if(!(thread.isAlive()))      thread=new Thread(this);                       //�����̹߳��ˣ����������߳�
    thread.start();                                                             //�����̣߳�����run()����
    b=false;                                                                    //���
    }
if(e.getSource()==stop){                                                        //�����ֹͣ��ť�ĵ��������ifģ��
    open.setBackground(Color.yellow);                                           //��ť��ɫ
    stop.setBackground(Color.red);                                              //��ť��ɫ
    b=true;                                                                     //���
    }
}

public static void main(String[] args) {                                        //��main���Ժ���
main rec=new main();                                                            //ʵ��������
rec.setSize(460,200);                                                           //���������ڴ�С
}

}

//���һ������ʵ���˶���ӿڣ�Ȼ�����Լ��ڲ�ʵ�ֲ�ͬ�����Ϳ���ֱ�����ڲ�this���룬�ܷ��㡣�������ڲ��ࡣ
//��������ӵĴ����У��ƺ�Ҫ�ϰ����ˡ�  ���ڴ�������Ҳ���˸������ʶ��
//����seTForground()��������ֱ���ı����������ɫ
//���﷢��һ���ǳ���Ҫ�ĵط����������¼���actionPerformed�����������ʹ��e��getsource()������ȡ��Դ������if���жϾͿ���ʹ�����ťʹ��ͬһ���¼��ӿڣ��ܷ��㣡����
