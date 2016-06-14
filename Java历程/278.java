import java.io.*;                                         //文件数据io包
class main {
    
public static void main(String[] args) {                  //主main测试函数
try {                                                     //文件操作有风险try
FileOutputStream fs=new FileOutputStream("word.txt");     //创建一个对word.txt的文件输出流fs
DataOutputStream ds=new DataOutputStream(fs);             //创建关于fs的Data输出流
ds.writeUTF("使用writeUTF()方法写入数据");                  //使用ds的writeUTF向txt写入数据
ds.writeBytes("使用writeBytes()方法写入数据");              //使用ds的writeBytes向txt写入数据
ds.writeChars("使用writeChar()方法写入数据");               //使用ds的writeChars向txt写入数据
ds.close();                                               //关闭data的输出流
FileInputStream fis=new FileInputStream("word.txt");      //创建一个关于word.txt的文件读取流fis
DataInputStream dis=new DataInputStream(fis);             //创建一个关于fis的Data文件读取流dis
System.out.println(dis.readUTF());                        //利用ds的readUTF方法读取一个字符串
}catch(Exception e)  {   e.printStackTrace();   }         //发生异常时显示异常的详细信息
}
    
}

//使用Data数据流的UTF有较好的兼容性， 回读文件比较好。 同时txt文本中的中文似乎被加密是乱码。  但回读后依然显示正常