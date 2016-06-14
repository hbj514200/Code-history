import java.io.*;                      //数据流的包
class main {

public static void main(String[] args) {          		//主函数
File file=new File("word.txt");                       //创建一个File文件对象。
if(file.exists()){                                    //如果它存在，exists()
String name=file.getName();                           //getName方法获取文件名(带有后缀)
long length=file.length();                            //length方法返回文件长度
boolean hidden=file.isHidden();                       //isHidden方法返回是否为隐藏文件
System.out.println("文件名是 "+name);  
System.out.println("文件长度 "+length);
System.out.println("文件是隐藏的吗 "+hidden);
}
else    System.out.println("该文件不存在");          //文件不存在则直接显示出来， 避免了try catch的麻烦，简化了代码过程
}
    
}

//其实有许多的自带方法命名都是开头小写，中间每个单词首字大写，便于清晰分辨