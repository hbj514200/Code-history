import static java.lang.System.out;                                                            //�������ϵͳ�����
class main  {                                                                                  //����
enum Constants2  {   Constants_A, Constants_B;   }                                             //��������CA��CB��ö������Constants2,

public static void compare(Constants2 c) {                                                     //ʵ�ֶԱȵĺ���������һ��Constants2��ö������
for(int i=0; i<Constants2.values().length; i++)                                                //ѭ����ֱ�Ӱ�valuse()����һ������
out.println(c+"��"+Constants2.values()[i]+"�ıȽϽ��Ϊ�� "+c.compareTo(Constants2.values()[i]));//����ȽϽ����������ö�������Լ���compareTo()�ķ���
}

public static void main(String[] args)  {   compare(Constants2.valueOf("Constants_B"));  }     //��main���Ժ���
    
}

//ö����������Ķ�������Ҫ�������ͣ���int��double�ȵȡ�
//compaeTo�Ƚ�ʱ�Լ��������򷵻�1����ͬ0�� ��������
