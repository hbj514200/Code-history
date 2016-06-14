int yearsum(int year, int m, int d)    
{
    int sum=0, i, a[12]={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };	
    int b[12] ={ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };				
    if(runnian(year)==1)								
        for(i=0; i<m-1; i++)    sum=sum+b[i];								
    else
        for(i=0; i<m-1; i++)    sum=sum+a[i];								
    sum=sum+d;										
    return sum;										
}

//输入三个int数: 年 月 日， 返回此日是该年第几天，  需要调用闰年判断模块runnian。
//三个形参: year m d。
