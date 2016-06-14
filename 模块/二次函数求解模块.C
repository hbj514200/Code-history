#include <math.h>

double gen(double a, double b, double c, double *x1, double *x2){ 
    double p;		p=b*b-4*a*c;
    if(p<0)    return 0;   
    *x1=(-b+sqrt(p))/(2*a); *x2=(-b-sqrt(p))/(2*a);
return 1;
}

//需要数学函数头文件math.h的支持。  输入三个double值: a, b, c. 后面放两个x1和x2的地址&x1, &x2；
//函数有返回值， 1为有解已处理， 0表示无解。
