class main extends Thread {                     //��������̳�Thread
    
public void run() {                            //��Ҫ�󸲸���run()����
    int count=0;                               //������������count
while(true){                                   //����ѭ��
    try {   sleep(100);     System.out.println(count++);    } catch (Exception e) {       e.printStackTrace();      }
}                //����sleepÿ100ms���һ�仰
}
    
public static void main(String[] args) {      //��main���Ժ���
new main().start();                           //ֱ�ӵ���ͬ��ķ���
}

}