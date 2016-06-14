#include<stdio.h>
int ss(int i){
int j, num;
if(i<=1) 					return 0;
if(i==2) 			      return 1;
if(i==3) 			      return 1;
for(j=2; j<=i/2; j++)
if(i%j==0)  return 0;
return 1;
}

int main(void){
int i, g=0;
printf("={");
for(i=1000; i<=9999; i++){
if(ss(i)==1)  {  printf("%d,", i);  g++;  }
if(g==15)     {  putchar('\n');     g=0;  }
}
printf("};");

return 0;
}

//注意检查首尾的格式
