double xiao(double str[]){
double min, n;
n=strlen(str);
int i;   min=str[//0];    //数组开始处
for(i=//1; i<=//n; i++)     //数组开始处+1, 数组结束处
if(str[i]<min)  min=str[i]; 
return min;
}

//输入一个double数组， 返回其最小值