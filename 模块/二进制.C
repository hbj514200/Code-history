int c[100];

void fact(int n){ 
int i=0;
while(n>=1) {  i++;  if(n%2==0)  c[i]=0;  else c[i]=1; n/=2; }    i++;  c[i]=1;
while(--i)  printf("%d", c[i]);  putchar('\n');
}

//输入一个int整数， 函数直接输出它的二进制值， 反向保存在全局int数组c中