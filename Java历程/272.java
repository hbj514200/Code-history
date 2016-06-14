import java.io.*;                                          //又是这个数据流io包
class main {
    
public static void main(String[] args) {                   //主main函数
File file=new File("word.txt");                            //创建一个File文件对象
try{                                                       //文件操作有风险try
FileOutputStream out=new FileOutputStream(file);           //创建FileOutSteam文件输出流out，关于file
byte buy[]="我有一只小毛驴， 我从来也不骑。".getBytes();      //创建一个byte字节数组，运用了字符串的getBytes方法
out.write(buy);   out.close();                             //writer方法在file中写入buy数组， 关闭输出流。
}
catch(Exception e)    {    e.printStackTrace();   }          //如果发生异常，显示异常信息

try{                                                         //文件操作有风险try
FileInputStream in=new FileInputStream(file);                //创建FileInputSteam文件读取流in， 关于file
byte byt[]=new byte[1024];                                   //定义一个叫byt的byte字节数组
int len=in.read(byt);                                        //创建一个int整数， 由in读取流的read方法，返回读取的字节数，都区内容放在byt字节数组里面
System.out.println("文件中的信息是： "+new String(byt,0,len)); //用newString(字节数组名,开始处,总长度)把byte字节数组变成字符串
in.close();                                                  //关闭读取流
}
catch(Exception e)  {    e.printStackTrace();     }          //如果发生异常，显示异常信息
  
}
  
}

//为了节约系统流资源，用完后手动关闭流， 因为编译器不能打开太多的流。
//好像这个文件的操作会清空文件内原本的内容！！！！
//文件输出流可指定一个不存在的文件，他会在后来创建。但是不允许指定一个正在被另一个程序使用的文件。