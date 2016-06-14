void zhiyinshu(int n){
int i=2;
while(n>1){
if(n%i==0)  {   printf("    %lld\n", i);    n=n/i;    }
else        {     i++;     if(i*i>n){   printf("    %lld\n", n);   break;   }     }
}
}

输入一个n，在屏幕上输出它的质因数，速度很快，但是有个例外1
 