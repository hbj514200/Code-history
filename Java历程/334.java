class main implements Runnable {                                                         //���࣬ ֱ��ʵ��Runnable�ӿ�
int num=10;                                                                              //���ó�ʼ��Ʊ��Ϊ10

public void run(){                                                                       //�̶�����run
    while(num>0){                                                                        //������г�Ʊ��num>0����ѭ��
        try {   Thread.sleep(100);  } catch (Exception e) {    e.printStackTrace();   }  //����100ms
        System.out.println("Ʊ�� "+num--);                                               //����̶߳�Ʊ�������˲�����ͬʱ��ʾ����
    }
}

public static void main(String[] args) {                                                //��main���Ժ���
main t=new main();                                                                      //ʵ��������(Ҳ����new Runnable)����Ϊ����ʵ�����Ǹ��ӿ�
Thread tA=new Thread(t);                                                                //Ϊ����ThreadA�������t
Thread tB=new Thread(t);                                                                //Ϊ����ThreadB�������t
Thread tC=new Thread(t);                                                                //Ϊ����ThreadC�������t
Thread tD=new Thread(t);                                                                //Ϊ����ThreadD�������t
tA.start();                                                                             //�����߳�A
tB.start();                                                                             //�����߳�B
tC.start();                                                                             //�����߳�C
tD.start();                                                                             //�����߳�D
}
    
}

//�����˳��ϵ����⣬��ȷ�����е�ʱ���������˸�ֵ�������п���0 1 0�Ľ����������    ������Ҫ�����߳�ͬ��