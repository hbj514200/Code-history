import static java.lang.System.out;                                        //�����ϲ�����ϵͳ�������static��ʾ����������еľ�̬����
class main {                                                               //ס��
enum Constants2  {    Constants_A, Constants_B, Constants_c;   }           //����һ��������������ö������Constants2

public static void main(String[] args) {                                   //��main���Ժ���
for(int i=0; i<Constants2.values().length; i++)                            //����values()��������ö�����͵����г�Ա
out.println(Constants2.values()[i]+"��ö��������λ������ֵ"+Constants2.values()[i].ordinal());  
}
    
}

//ÿһ��ö�����͵ĳ�Ա���������Դ���ordinal()����������һ������intֵ����������ö�����͵�����λ�ã�ע�������Ǵ�0��ʼ��