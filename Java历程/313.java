class main <T> {                                                                //һ����������<T>
private T[] array;                                                              //�����Ա��������array

public void setT(T[] array)     {   this.array=array;   }                       //����紫��Ķ������鴢�浽��Ա�������棬setT()
public T[] getT()               {   return array;       }                       //����緵�ر����Ա���󴢴�Ķ������飬getT()

public static void main(String[] args) {                                        //��main���Ժ���
main<String> a=new main<String>();                                              //����һ��main���� �����ķ��Ͷ�λString
String[] array={"��Ա 1","��Ա 2","��Ա 3","��Ա 4","��Ա 5"};                     //����һ���ַ������顣
a.setT(array);                                                                  //��array����main���Ͷ���
for(int i=0; i<a.getT().length; i++)       System.out.println(a.getT()[i]);     //����Ϊ�����getT()��������ֱ�ӵ������飬����main����������ݡ�
}
    
}

//��ʵ���Ϳ���˵����һ��Object�Ķ�����ֻ����Ҫ������ʹ��ǰ������һ�£������Ͳ�����������ת���ˡ�
//���з���Ϊ����ĺ����ڵ����ƺ�����ֱ�ӵ������������ʹ�ã���������Ҳ�ǣ�ͦ�õģ���������Զ����Java��ȷΪ��������������˺ܶడ