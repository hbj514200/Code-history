import java.awt.*;
import javax.swing.*;
class main extends JFrame {                                   //����̳�JFrame��Ϊ����

public main(){
setSize(320,240);                                             //�����������С
setTitle("�Զ����е��ı�����Դ���");                         //���������ڵı�������
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   //���ùرմ���ʱʲôҲ����
Container cp=getContentPane();                                //����һ����������
JTextArea jt=new JTextArea("�ı���",6,6);                     //����һ���ı����趨��Ĭ�����ݺʹ�С
jt.setLineWrap(true);                                         //���ñ��ı����Զ�����
cp.add(jt);                                                   //���ı�������������
setVisible(true);                                             //����������Ϊ�ɼ�
}

public static void main(String[] arg)    {    new main();    }//��main���Ժ���

}