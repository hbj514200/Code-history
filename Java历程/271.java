import java.io.*;                      //�������İ�
class main {

public static void main(String[] args) {          		//������
File file=new File("word.txt");                       //����һ��File�ļ�����
if(file.exists()){                                    //��������ڣ�exists()
String name=file.getName();                           //getName������ȡ�ļ���(���к�׺)
long length=file.length();                            //length���������ļ�����
boolean hidden=file.isHidden();                       //isHidden���������Ƿ�Ϊ�����ļ�
System.out.println("�ļ����� "+name);  
System.out.println("�ļ����� "+length);
System.out.println("�ļ������ص��� "+hidden);
}
else    System.out.println("���ļ�������");          //�ļ���������ֱ����ʾ������ ������try catch���鷳�����˴������
}
    
}

//��ʵ�������Դ������������ǿ�ͷСд���м�ÿ���������ִ�д�����������ֱ�