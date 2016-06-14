int ksm(int a,int b,int n){      
int t=1;  
if(b==0) return 1;  
if(b==1) return a%n;  
t=ksm(a,b>>1,n);    t=t*t%n;  
if(b&0x1) {   t=t*a%n;   }  
return t;  
}   

//输入三个int值a,b,n; 模块返回int表示:a的b次幂余n的值。
//根据实际需要可能要用long long。