double pow1(double base, double exp){
int i, sum=base;
exp=-exp; 
for(i=2; i<=exp; i++)
sum=sum*base;
sum=1.0/sum;
return sum;
}

//pow(a,b)的补充， a不为0， b可以小于0.
//double型