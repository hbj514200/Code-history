import java.io.*;                                                                     //数据流文件io包
class main {
    
public static void main(String[] args){                                               //主main测试函数
String content[]={"小祥帅","小祥帅帅","小祥帅帅帅"};                                     //定义一个字符串数组
File file=new File("word.txt");                                                       //创建一个word.txt文件对象
try {                                                                                 //文件操作有风险try
FileWriter fw=new FileWriter(file);                                                   //创建关于file的FileWriter写入器(传入file) fw
BufferedWriter bufw=new BufferedWriter(fw);                                           //创建缓存写入器，传入FilerWriter， bufw
for(int k=0;k<content.length; k++)    {  bufw.write(content[k]);   bufw.newLine();   }//把content字符串数组内的所有字符串传入bufw缓存写入器，每写一个字符串就newLine()换行
bufw.close();    fw.close();                                                          //关闭文件流，都要关闭一次，范围从小到大
}
catch(Exception e)    {  e.printStackTrace();   }                                     //发生异常catch，显示异常的详细信息

try {                                                                                 //文件操作有风险try
FileReader fr=new FileReader(file);                                                   //创建关于file的FileReader读取器(传入file) fr
BufferedReader bufr=new BufferedReader(fr);                                           //创建缓存读取器，传入FilerReader， bufr
String s=null;    int i=0;                                                            //定义s字符串和整数i;
while((s=bufr.readLine())!=null)  {  i++;  System.out.println("第"+i+"行:"+s);   }     //利用readLine()方法读取文件中的一行字符串，此格式规定通用，同时显示出来
bufr.close();   fr.close();                                                            //关闭文件流，都要关闭一次，范围从小到大
}catch(Exception e)    {   e.printStackTrace();  }                                     //发生异常catch，显示异常的详细信息

}

}

//看来File   FileWriter和FileReader    BufferWriter和BufferReader   都是传入上一级的对象创建的。