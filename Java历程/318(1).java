class main {                                                                    //����
enum Constants2     {   Constants_A, Constants_B    }                           //����һ��ö�����Ͱ���CA��CB
         
public static void doit2(Constants2 c) {                                        //���Ժ���������һ��ö������
switch (c) {                                                                    //switch�ж�
case Constants_A:       System.out.println("doit2() Constants_A");  break;      //����CA�������Ϣ
case Constants_B:       System.out.println("doit2() Constants_B");  break;      //����CB�������Ϣ
}
}
	
public static void main(String[] args) {                                        //��main���Ժ���
main.doit2(Constants2.Constants_A);                                             //����doit2()����������ö�ٳ�ԱCA
main.doit2(Constants2.Constants_B);                                             //����doit2()����������ö�ٳ�ԱCA
}

}

//����Ŀ���ǿ���