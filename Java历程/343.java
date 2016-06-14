import java.net.*;                                                         //网络包
class main {                                                               //主类
            
public static void main(String[] args) {                                  //主main测试方法
InetAddress ip;                                                           //创建一个InetAddress对象，叫ip
    try {                                                                 //网路操作有风险try
        ip=InetAddress.getLocalHost();                                    //ip对象使用InetAddress的getLocalHost获得实际内容
        String localname=ip.getHostName();                                //利用ip的getHostName返回本机名字
        String localIP=ip.getHostAddress();                               //利用ip的getHostAdress获得本机的IP
        System.out.println("本机的名字是： "+localname);                   //输出显示本机名字
        System.out.println("本机的IP地址是  "+localIP);                    //输出显示本机的IP
    } catch (UnknownHostException e) {             e.printStackTrace();   //发生异常，则显示详细信息
    
    }
}

}

//在这台电脑(Win10)上， 经测试如果没有联网， 你们本机的IP显示为127.0.0.0