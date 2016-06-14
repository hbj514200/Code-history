    void maopao(int s[], int wei){
    int i, j, t;
    for(i=1; i<=wei; i++)							
    for(j=1; j<wei+1-i; j++)					
    if(s[j]>s[j+1])  { t=s[j];	s[j]=s[j+1];  s[j+1]=t; }
    }

//冒泡排序模块， 输入为一个int的数组名， void型调用函数。