void kuaipai(long long s[], long long t[], long long start, long long end){
long long i=start, j=end;
s[0]=s[start];     t[0]=t[start];             //类比
while(i<j){
while(i<j&&s[0]<s[j])     j--;	
if(i<j)                   {   s[i]=s[j];	t[i]=t[j];   i++;	 }      //类比
while(i<j&&s[i]<=s[0])    i++;	
if(i<j)                   {   s[j]=s[i];   t[j]=t[i];   j--;  }      //类比
} 
s[i]=s[0];	     t[i]=t[0];                   //类比
if(start<i)                   kuaipai(s, t, start, j-1);	  //类比
if(i<end)                     kuaipai(s, t, j+1, end);      //类比
} 

//输入s， t， 以数组s为标准快速排序，  同时捆绑数组t，  两个数组一一对应。