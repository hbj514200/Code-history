import java.util.*;                                     //�����������;����List�����
class main<T extends List> {                            //�������࣬ Ҫ���Ͷ������ʵ��List�ӿڣ�����������
public static void main(String[] args) {                //��main���Ժ���
             
main<ArrayList> ar=new main<>();                        //ʵ����main�����趨����ΪArrayList
main<LinkedList> lr=new main<>();                       //ʵ����main�����趨����ΪLinkedList
    
}
}

//�޷��趨����ΪHashMap����ΪMap��Ķ�����û�а�Ҫ��ʵ��List�ӿڣ� ��Ϊͬһ�淶�ṩ�˷���