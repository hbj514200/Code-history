import java.io.*;                                         //�ļ�����io��
class main {
    
public static void main(String[] args) {                  //��main���Ժ���
try {                                                     //�ļ������з���try
FileOutputStream fs=new FileOutputStream("word.txt");     //����һ����word.txt���ļ������fs
DataOutputStream ds=new DataOutputStream(fs);             //��������fs��Data�����
ds.writeUTF("ʹ��writeUTF()����д������");                  //ʹ��ds��writeUTF��txtд������
ds.writeBytes("ʹ��writeBytes()����д������");              //ʹ��ds��writeBytes��txtд������
ds.writeChars("ʹ��writeChar()����д������");               //ʹ��ds��writeChars��txtд������
ds.close();                                               //�ر�data�������
FileInputStream fis=new FileInputStream("word.txt");      //����һ������word.txt���ļ���ȡ��fis
DataInputStream dis=new DataInputStream(fis);             //����һ������fis��Data�ļ���ȡ��dis
System.out.println(dis.readUTF());                        //����ds��readUTF������ȡһ���ַ���
}catch(Exception e)  {   e.printStackTrace();   }         //�����쳣ʱ��ʾ�쳣����ϸ��Ϣ
}
    
}

//ʹ��Data��������UTF�нϺõļ����ԣ� �ض��ļ��ȽϺá� ͬʱtxt�ı��е������ƺ������������롣  ���ض�����Ȼ��ʾ����