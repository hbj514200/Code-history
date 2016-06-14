int dayu(int year, int m, int d){
    int sum=0, i, j, k, a[12]={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };	
    int b[12]={ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if(run(year)==1)
        for(i=0; i<m-1; i++)
            sum=sum+b[i];
    else
        for (i=0; i<m-1; i++)
            sum=sum+a[i];
    for (j=1900; j<year; j++)
        if (runnian(j)==1)
            sum=sum+366;					
    else
        sum=sum+365;						
    sum=sum+d; 						
    return sum; 							
}

//输入三个int值: year m d。 返回该年该月该天距离1900年1月1日的天数， 需配合闰年判断模块runnian使用。
//仅可处理距离那一年的1月1日。