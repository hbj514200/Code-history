import static java.lang.System.out;                                              //ϵͳ�����

interface d     {    public String getDescription();    public int getI();     } //����һ���ӿڣ���������������getDescription��getI

class main {                                                                     //����
    
public enum AnyEnum implements d {        
Constants_A  {                                                                   //����һ��ö�ٳ�Ա��ʹ�õ����࣡��������
public String getDescription() {   return ("����ö�ٳ�ԱA");   }                  //��Աʵ��d�ӿ�getDescription()
public int getI()              {   return i;                  }                 //��Աʵ��d�ӿ��е�getI()
},
Constants_B  {
public String getDescription() {   return ("����ö�ٳ�ԱB");   }
public int getI()              {   return i;                  }
},
Constants_C  {
public String getDescription() {   return ("����ö�ٳ�ԱC");   }
public int getI()              {   return i;                  }
},
Constants_D  {
public String getDescription() {   return ("����ö�ٳ�ԱD");   }
public int getI()              {   return i;                  }
};
private static int i=5;                                                          //����һ����̬int����i=5
}

 
public static void main(String[] arg) {                                          //��main���Ժ���
for(int i=0; i<AnyEnum.values().length; i++){                                    //�����������AnyEnumö���������г�Ա
out.println(AnyEnum.values()[i]+"����getDescription����Ϊ�� "+AnyEnum.values()[i].getDescription());  //���ÿ��ö�ٳ�Ա��getDescription��������ֵ
out.println(AnyEnum.values()[i]+"����getI����Ϊ�� "+AnyEnum.values()[i].getI());                      //���ÿ��ö�ٳ�Ա��getI(���������ص�iֵ
}
}

}

//��Ȼ��������һ�����룬 ��һ���������ļ��룺ö�������е�ÿһ����Ա����һ������  ��������ȷ�ġ� ��������Զ����Java˼�롣
//�ڶ����ǣ� ö�����ͱ���Ҳ��һ������������̳�һ���ӿڵĻ�����ô����ÿһ��ö�ٳ�Ա����Ҫʹ����ķ�ʽ������ͬʱ�������ǽӿ��еķ��������������Ǻ����˵�