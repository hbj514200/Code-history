interface Constants {                                                             //����һ����Constants�Ľӿ�
public static final int Constants_A=1;                                            //���幫���ĵ�CAֵ(���ɱ䶯)
public static final int Constants_B=12;                                           //���幫���ĵ�CBֵ(���ɱ䶯)
}

class main {                                                                      //����
enum Constants2{   Constants_A, Constants_B  }                                    //��CA��CB����ö������ת��

public static void doit(int c){                                                   //����int��doit()����
switch(c){                                                                        //�Դ��������c�����ж�
case Constants.Constants_A :    System.out.println("doit() Constants_A");  break; //��������c����CA�����doit A�� ���˴���CA�Ǳ���ö�ٵ�Constants2��
case Constants.Constants_B :    System.out.println("doit() Constants_B");  break; //��������c����CB�����doit B�� ���˴���CA�Ǳ���ö�ٵ�Constants2��
}
}

public static void doit2(Constants2 c){                                           //����Constants2ö�����͵Ĵ���ʵ��
switch(c){                                                                        //�Դ��������c�����ж�
case Constants_A :    System.out.println("doit2() Constants_A");  break;          //��������c����CA�����doit2 A�� ���˴���CA�Ǳ���ö�ٵ�Constants2��
case Constants_B :    System.out.println("doit2() Constants_B");  break;          //��������c����CB�����doit2 B�� ���˴���CA�Ǳ���ö�ٵ�Constants2��
}
}

public static void main(String[] args) {                                          //��main���Ժ���
main.doit(Constants.Constants_A);                                                 //���ñ���doit����������CA     ���˴���CA�ǽӿڵ�Constants��
main.doit2(Constants2.Constants_A);                                               //���ñ���doit2����������CA    ���˴���CA�Ǳ���ö�ٵ�Constants2��
main.doit2(Constants2.Constants_B);                                               //���ñ���doit2����������CA    ���˴���CA�Ǳ���ö�ٵ�Constants2��                               
main.doit(3);                                                                     //���ñ���doit��������������3         
}

}