import static  java.lang.System.out;                             //ʹ����һ��ϵͳ�����
class main {                                                     //����
enum Constants2     {   Constants_A, Constants_B;    }           //����һ��ö�����ͣ� ����CA��CB��
 
public static void main(String[] args) {                         //��main���Ժ���
for(int i=0; i<Constants2.values().length; i++)                  //ѭ����Constants2.valuse()ֱ�Ӵ���һ�����顣
out.println("ö�����ͳ�Ա������ "+Constants2.values()[i]);         //���ÿһ������֡�
}

}

//ʹ�õ���ͦ�����