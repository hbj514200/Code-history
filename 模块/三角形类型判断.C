double sanjiao(double a, double b, double c){
    double s, area;
   if(a>b){ s=a; a=b; b=a; }
   if(b>c){ s=b; b=c; c=s; }
   if(a>b){ s=a; a=b; b=a; }
    if(a+b>c&&b+c>a&&a+c>b)
    {
        if(a==b&&a==c) return 3;
        else if(a==b||a==c||b==c)  return 2;
        else if(a*a+b*b==c*c)      return 1;
        else if(a*a+b*b>c*c)       return 4;	
        else                       return 5;	
    }
    else
        return 6;
}

//1. 直角 2.等腰 3.等边。 4. 锐角  5.钝角    6.不可组成三角形
//输入double三边a, b, c。 返回三角形类型。 见上表。
//需要math.h头文件支持。