int ss(int i)												/*自定义函数判断是否为素数*/
{
    int j;
    if(i<=1) 					return 0;
    if(i==2) 			      return 1;
    if(i==3) 			      return 1;
    for(j=2; j<=i/2; j++){
        if(i%j==0)         return 0;
        else if(i!=j+1)    continue;
        else               return 1;
    }
}

//输入一个int值， 判断是否素数， 是1否0。 没有进行sqrt优化.
//但是已经经过1/2对半优化处理。  但未修改前不适用大数值