
import static java.lang.System.out;                                                               //ϵͳ�����
class main {                                                                                      //����
    
enum Constants2  {                                                                                //����һ��Constanst2��ö������
Constants_A("����ö�ٳ�ԱA"),Constants_B("����ö�ٳ�ԱB"),Constants_C("����ö�ٳ�ԱC"),Constants_D(3);//�����ĸ�ö�ٳ�Ա���еĴ�������
private String description;        private int i=4;                                               //��������˽�е��ַ���������i
private Constants2()                    {                                      }                  //�յ��޲������췽��
private Constants2(String description)  {   this.description=description;      }                  //���ַ��������Ĺ��췽�����趨�����ַ���
private Constants2(int i)               {   this();i=this.i+i;                 }                  //������i�Ĺ��췽�����趨i��ֵ��
public String getdescription()          {   return description;                }                  //���������ַ���
public int getI()                       {   return i;                          }                  //��������i
}

public static void main(String[] args) {                                                          //��main���Ժ���
for(int i=0; i<Constants2.values().length; i++)                                                   //ѭ��������Constants2ö�����������еĳ�Ա
out.print(Constants2.values()[i]+"����getDescription()��������Ϊ�� "+Constants2.values()[i].getdescription()+"\n");     //����ö�ٳ�Ա��getDescription()������ȡ���ǵ������ַ��������
out.print(Constants2.valueOf("Constants_D")+"����getDescription()��������Ϊ�� "+Constants2.valueOf("Constants_D").getdescription()+"\n");//����ö�ٳ�ԱD��getDescription()������ȡ���������ַ��������
}
    
} 

//������һ�����룬����ö�����ͺ����ܽ�Ϊǿ���ƺ���һ�ָ߼��ṹ�壬��Ϊ�Դ�������
//���У��ƺ���������Զ����Java��˵�� ÿ��ö�ٳ�Ա�ö���һ��������Ϊ���Ƕ����Դ��ķ������������Ǽ̳���ĳ���������ģ�