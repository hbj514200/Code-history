class main {                                            //����
private Object b;                                       //����һ����̬����b

public Object getB()           {   return b;   }        //����getB()������ ���ر����еĶ���b
public void setB(Object b)     {   this.b=b;   }        //����setB()������ �趨�����еĶ���b

public static void main(String[] args) {                //��main���Ժ���
main t=new main();                                      //ʵ��������һ��main����t
t.setB( new Boolean(true) );                            //��������setB()����һ���µ�boolean����
System.out.println(t.getB());                           //��������getB()������ڲ�����Ķ���
t.setB(new Float(12.3));                                //��������setB()����һ���µ�Float����
Float f=(float) (t.getB());                             //��������getB()������ڲ�����Ķ���ͬʱǿ��ת��Ϊfloat
System.err.println(f);                                  //������
}
    
}

//�������ϵ�˵����   �ھ���������ת�ͣ� ��ʮ����������ת��