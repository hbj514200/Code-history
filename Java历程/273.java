import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class main extends JFrame {                                     //��JFrame��
JTextArea wenzi=new JTextArea(15,40);                           //����һ���ı��༭�򣬴��������С
   
public main(){                                                  //�����ں���
Container cp=getContentPane();                                  //��ȡһ����������
cp.setLayout(new FlowLayout());                                 //���ɲ��ֹ������������
JButton jb1=new JButton("д���ļ�");    JButton jb2=new JButton("��ȡ�ļ�");   jb1.setBounds(10,10,10,10);    jb2.setBounds(10,10,10,10);  jb1.addActionListener(new xieru());    jb2.addActionListener(new duqu());  //����������ť���趨��С�Ͷ��������¼�
cp.add(wenzi);      cp.add(jb1);       cp.add(jb2);             //�����������˳������������
setVisible(true);   setSize(460,340);   setTitle("С�����ֱ༭ϵͳ");   setResizable(false);   setDefaultCloseOperation(EXIT_ON_CLOSE);     //��������������������
}

class xieru implements ActionListener {                        //д�밴ť�����¼�
public void actionPerformed(ActionEvent e){                    //Actionlister�ӿڹ̶���Ӧ����
File file=new File("word.txt");                                //����һ���ļ�����
try{                                                           //�ļ������з���try
FileWriter out=new FileWriter(file);                           //����һ��FileWriterд�����
String s=wenzi.getText();                                      //��ȡ�ı����е�����
out.write(s);      out.close();                                //���ı�д�����֣� �ر���
}catch(IOException a)  {  System.out.println("�ļ������ڣ��Ѵ���");   }  //�׳��쳣����Ӧ
}
}

class duqu implements ActionListener {                          //��ȡ��ť�����¼�
public void actionPerformed(ActionEvent e){                     //Actionlister�ӿڹ̶���Ӧ����
File file=new File("word.txt");                                 //����һ���ļ�����
try{                                                            //�ļ������з���try
FileReader in=new FileReader(file);                             //����һ��FileReader��ȡ����
char byt[]=new char[1024];                                      //����һ���ַ�����
int len=in.read(byt);                                           //��ȡ��byt���飬ͳ�Ƽ�¼����
wenzi.setText(new String(byt,0,len));                           //ת��Ϊ�ַ�����ͬʱ��ʾ���ı�����
}catch(Exception a)  {  System.out.println("�ļ������ڣ��Ѵ���");   }   //�׳��쳣����Ӧ
}
}

public static void main(String[] args)    {  new main();   }       //��main���Ժ���

}

//������Ի��У�������txt�в�û�л��У����Ƕ�ȡʱ��Ȼ���л���
