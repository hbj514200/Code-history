import java.io.*;                                                                     //�������ļ�io��
class main {
    
public static void main(String[] args){                                               //��main���Ժ���
String content[]={"С��˧","С��˧˧","С��˧˧˧"};                                     //����һ���ַ�������
File file=new File("word.txt");                                                       //����һ��word.txt�ļ�����
try {                                                                                 //�ļ������з���try
FileWriter fw=new FileWriter(file);                                                   //��������file��FileWriterд����(����file) fw
BufferedWriter bufw=new BufferedWriter(fw);                                           //��������д����������FilerWriter�� bufw
for(int k=0;k<content.length; k++)    {  bufw.write(content[k]);   bufw.newLine();   }//��content�ַ��������ڵ������ַ�������bufw����д������ÿдһ���ַ�����newLine()����
bufw.close();    fw.close();                                                          //�ر��ļ�������Ҫ�ر�һ�Σ���Χ��С����
}
catch(Exception e)    {  e.printStackTrace();   }                                     //�����쳣catch����ʾ�쳣����ϸ��Ϣ

try {                                                                                 //�ļ������з���try
FileReader fr=new FileReader(file);                                                   //��������file��FileReader��ȡ��(����file) fr
BufferedReader bufr=new BufferedReader(fr);                                           //���������ȡ��������FilerReader�� bufr
String s=null;    int i=0;                                                            //����s�ַ���������i;
while((s=bufr.readLine())!=null)  {  i++;  System.out.println("��"+i+"��:"+s);   }     //����readLine()������ȡ�ļ��е�һ���ַ������˸�ʽ�涨ͨ�ã�ͬʱ��ʾ����
bufr.close();   fr.close();                                                            //�ر��ļ�������Ҫ�ر�һ�Σ���Χ��С����
}catch(Exception e)    {   e.printStackTrace();  }                                     //�����쳣catch����ʾ�쳣����ϸ��Ϣ

}

}

//����File   FileWriter��FileReader    BufferWriter��BufferReader   ���Ǵ�����һ���Ķ��󴴽��ġ�