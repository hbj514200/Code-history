import java.awt.*;                                                                   //�����
import javax.swing.*;                                                                //���������
class main extends JFrame {                                                          //���࣬�̳�JFrame
             
public static void main(String[] args)   {    main frame=new main();      }          //��main���Է���
    
public  main(){                                                                      //���캯����������
setTitle("���Թ����ı�񴰿�");                                                        //���������ڵı�������
setSize(480,320);                                                                    //���������ڵĴ�С
setDefaultCloseOperation(EXIT_ON_CLOSE);                                             //���������ڵĹرշ�ʽ
String[] columName={"A","B"};                                                        //���ǡ��������� Ҳ�����������ѡ���STring����
String[][] tableValue={{"A1","B1"},{"A2","B2"},{"A3","B3"},{"A4","B4"},{"A5","B5"}}; //����������ݣ�ʹ�õ��Ƕ�ά���飬��������
JTable table=new JTable(tableValue,columName);                                       //����һ��JTable���ӱ��
JScrollPane mianban=new JScrollPane(table);                                          //����һ������С��岢�ѵ��ӱ�����
getContentPane().add(mianban,BorderLayout.CENTER);                                   //�ѹ���С�������������
setVisible(true);                                                                    //���ô��ڿɼ�
}

}

//�������ӱ���ʱ��ע���ȴ�����Ƕ�λ�������ݣ�Ȼ�����ѡ���������Ŀ�����һ��������ͦ�����
//��������С���ʱֱ�Ӱ�������ù��췽���ӽ�ȥ��û��Ҫadd�����׳�����