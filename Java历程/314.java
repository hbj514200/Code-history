import java.util.*;                                                             //����һ������;�ӻ���
class main {                                                                    //����

public static void main(String[] args) {                                        //��main���Ժ���
HashMap<Integer,String> mu=new HashMap<>();                                     //����һ�����͵�HashMap�� ����ΪInteger��String��
for(int i=0; i<5; i++)   mu.put(i, "���Ǽ��ϳ�Ա "+i);                           //ѭ������HashMap�������ӳ���ϵ
for(int i=0; i<mu.size(); i++)      System.out.println(mu.get(i));             //HashMap����������size(���������Է����䴢�����ݵ�������get(key)��ȡ����ֵ
}

}

//�����������ʵ���� ���͵�����������Ч�����ֳ����� ����HashMap��ӳ���ϵ��ǰ���������ֻ������ʹ���ַ���ӳ�䵽�ַ�����������Ļ��������ɶ���ӳ����󣬷�����ҹ���ǿ��
//������Java�ġ�����Զ��󡱵ı��˼�룬 Ҳ�ǲ�����