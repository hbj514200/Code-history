int sa(int n){
int i, num;
if(n<=1) 					return 0;
if(n==2) 			      return 1;
if(n==3) 			      return 1;
if(n%2==0)              return 0;
for(i=3; i<=sqrt((double)n); i=i+2)
if(n%i==0)  return 0;
return 1;
}
