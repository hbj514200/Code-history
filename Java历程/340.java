class main {                                            //主类
private Object b;                                       //定义一个静态对象b

public Object getB()           {   return b;   }        //这是getB()函数， 返回本类中的对象b
public void setB(Object b)     {   this.b=b;   }        //这是setB()函数， 设定本类中的对象b

public static void main(String[] args) {                //主main测试函数
main t=new main();                                      //实例化创建一个main本类t
t.setB( new Boolean(true) );                            //调用它的setB()传入一个新的boolean对象。
System.out.println(t.getB());                           //调用它的getB()输出它内部储存的对象
t.setB(new Float(12.3));                                //调用它的setB()传入一个新的Float对象
Float f=(float) (t.getB());                             //调用它的getB()输出它内部储存的对象，同时强制转化为float
System.err.println(f);                                  //输出结果
}
    
}

//根据书上的说法：   第九行是向上转型， 第十二行是向下转型