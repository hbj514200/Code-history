import java.io.*;                                                           //��������
import java.net.*;                                                          //�����
class main {                                                                //����
 private BufferedReader reader;                                             //����һ�������ȡ��BufferReader
 private ServerSocket server;                                               //����һ�����������ֶ���ServerSocket
 private Socket socket;                                                     //����һ�����ֶ���socket
   
 void getserver(){                                                         //ʹ��getSever()��������������������
     try {                                                                 //��������з���try
         server=new ServerSocket(8998);        System.out.println("�᳤���������������ִ����ɹ���");  //��ServerSocket����ʵ����������8898�˿�
         while(true){                                                                             //����ѭ��
             System.out.println("���ڵȴ���͵Ŀͻ������ӡ�������");     socket=server.accept();         //����ServerSocket���������ֶ����accept()��������һ���������֣��˴�ʹ��socket���нӡ�
             reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));           //����һ�������ȡ��BufferReader���������һ����ȡ�����ٴ������һ����socket���ֶ����getInputSteam()���صĻ�����ȡ��
             getClienMessage();                                                                   //����������Զ��巽����ȡ��Ϣ
         }
     } catch (Exception e) {       System.out.println("�����16�б���!");                          //�쳣��ʾ����
     }
}               //ʹ��getSever()��������������������

 private void getClienMessage() {                                                                //��ȡ�ͻ��˷�����Ϣ�ķ���
     try                   {   while(true)   System.out.println("��͵Ŀͻ����� "+reader.readLine());    }  //ʹ��������ѭ����ʹ��reader��readline()������ȡ�ӿͻ��˴������ַ���
     catch (Exception e)   {   System.out.println("�����22�б���");    }                                   //��ʾ�쳣
     try                   {      if(reader!=null)   reader.close();      if(socket!=null)   socket.close();      }   //�ر���������
     catch (Exception e)   {   System.out.println("�����24�б���");    }                                   //��ʾ�쳣
 }

public static void main(String[] args) {                  //��main���Ժ���
main tcp=new main();                                      //ʵ��������
tcp.getserver();                                          //����������
}
 
}

//С�����������
//ʹ���������ȫ�ֱ����ܷ��㣬ÿ���������������ɵز������� ����Ҳ��Java�ĳ���