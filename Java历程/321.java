import java.lang.*;                                                                       //java�����Ի�����
class main extends Thread {                                                               //�������࣬�̳ж��̴߳��Thread
private int count=10;                                                                     //����˽�г�Ա����count=10

public void run(){                                                                        //���Ƕ��̳߳�������е�ִ��run������������ȫ������
while(true){        System.out.println(count+" ");      if(--count==0)      return;     } //ѭ���������
}

public static void main(String[] args) {                                                  //��main���Ժ���
new main().start();                                                                       //���������start()�������������Ը���Thread���������
}
    

}

//������ Thread����Ƕ��̵߳ĳ������࣬���̳����Ļ���Ҫ�Լ�ʵ�ֶ�Ӧ�Ľӿڣ��ӿ���һ�ж����˹淶��   