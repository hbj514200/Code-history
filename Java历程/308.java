import static java.lang.System.out;                                              //系统输出包

interface d     {    public String getDescription();    public int getI();     } //创建一个接口，里面有两个方法getDescription和getI

class main {                                                                     //主类
    
public enum AnyEnum implements d {        
Constants_A  {                                                                   //定义一个枚举成员，使用的是类！！！？？
public String getDescription() {   return ("我是枚举成员A");   }                  //成员实现d接口getDescription()
public int getI()              {   return i;                  }                 //成员实现d接口中的getI()
},
Constants_B  {
public String getDescription() {   return ("我是枚举成员B");   }
public int getI()              {   return i;                  }
},
Constants_C  {
public String getDescription() {   return ("我是枚举成员C");   }
public int getI()              {   return i;                  }
},
Constants_D  {
public String getDescription() {   return ("我是枚举成员D");   }
public int getI()              {   return i;                  }
};
private static int i=5;                                                          //创建一个静态int整数i=5
}

 
public static void main(String[] arg) {                                          //主main测试函数
for(int i=0; i<AnyEnum.values().length; i++){                                    //利用数组遍历AnyEnum枚举类型所有成员
out.println(AnyEnum.values()[i]+"调用getDescription方法为： "+AnyEnum.values()[i].getDescription());  //输出每个枚举成员的getDescription描述返回值
out.println(AnyEnum.values()[i]+"调用getI方法为： "+AnyEnum.values()[i].getI());                      //输出每个枚举成员的getI(）方法返回的i值
}
}

}

//显然，经过这一个代码， 上一次中做出的假想：枚举类型中的每一个成员都是一个对象。  看来是正确的。 这是万物皆对象的Java思想。
//第二个是： 枚举类型本身也是一个对象，如果他继承一个接口的话，那么他的每一个枚举成员都需要使用类的方式创建，同时单独覆盖接口中的方法。代码量还是很吓人的