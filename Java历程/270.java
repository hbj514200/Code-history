import java.io.*;                               //���Ǵ����ļ����������ıر�������  io
class main {

public static void main(String[] arg){                          //��main���Ժ���
File file=new File("word.txt");                                //����һ��File�ļ����󣬴����ļ�ʵ�ʵ�ַ
if( file.exists() )     {   file.delete();         System.out.println("�ļ���ɾ��");  }  //���ļ������delete����ɾ���ļ�
else try                {   file.createNewFile();  System.out.println("�ļ��Ѵ���");  }  //createNewFile�������Դ������ļ�
     catch(Exception e) {   e.printStackTrace();                                     }  //��ʾ�쳣����ϸ��Ϣ
}

}

//������ļ����������ǻ����쳣���յģ�����try catch�õñȽ϶࣬�����ļ��Դ���createNewFile��delete����Ҳ��