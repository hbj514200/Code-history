import java.io.*;                                          //�������������io��
class main {
    
public static void main(String[] args) {                   //��main����
File file=new File("word.txt");                            //����һ��File�ļ�����
try{                                                       //�ļ������з���try
FileOutputStream out=new FileOutputStream(file);           //����FileOutSteam�ļ������out������file
byte buy[]="����һֻСë¿�� �Ҵ���Ҳ���".getBytes();      //����һ��byte�ֽ����飬�������ַ�����getBytes����
out.write(buy);   out.close();                             //writer������file��д��buy���飬 �ر��������
}
catch(Exception e)    {    e.printStackTrace();   }          //��������쳣����ʾ�쳣��Ϣ

try{                                                         //�ļ������з���try
FileInputStream in=new FileInputStream(file);                //����FileInputSteam�ļ���ȡ��in�� ����file
byte byt[]=new byte[1024];                                   //����һ����byt��byte�ֽ�����
int len=in.read(byt);                                        //����һ��int������ ��in��ȡ����read���������ض�ȡ���ֽ������������ݷ���byt�ֽ���������
System.out.println("�ļ��е���Ϣ�ǣ� "+new String(byt,0,len)); //��newString(�ֽ�������,��ʼ��,�ܳ���)��byte�ֽ��������ַ���
in.close();                                                  //�رն�ȡ��
}
catch(Exception e)  {    e.printStackTrace();     }          //��������쳣����ʾ�쳣��Ϣ
  
}
  
}

//Ϊ�˽�Լϵͳ����Դ��������ֶ��ر����� ��Ϊ���������ܴ�̫�������
//��������ļ��Ĳ���������ļ���ԭ�������ݣ�������
//�ļ��������ָ��һ�������ڵ��ļ��������ں������������ǲ�����ָ��һ�����ڱ���һ������ʹ�õ��ļ���