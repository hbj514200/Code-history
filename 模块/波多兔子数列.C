long long boduo(long long n){
 if(n==1||n==2) 
  return 1;
 else
  return boduo(n-1)+boduo(n-2);
}

//输入一个long long的值n， 返回波多兔子数列第n项的值， 注：n不要太大， 其数列递增特别快