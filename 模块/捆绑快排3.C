void kuaipai(long long a[], long long b[], long long c[], long long start, long long end){
long long i=start, j=end;
a[0]=a[start];     b[0]=b[start];      c[0]=c[start];       //类比
while(i<j){
while(i<j&&a[0]<a[j])     j--;	
if(i<j)                   {   a[i]=a[j];	b[i]=b[j];  c[i]=c[j];  i++;	 }      //类比
while(i<j&&a[i]<=a[0])    i++;	
if(i<j)                   {   a[j]=a[i];  b[j]=b[i];  c[j]=c[i];  j--;  }      //类比
} 
a[i]=a[0];	     b[i]=b[0];      c[i]=c[0];             //类比
if(start<i)                   kuaipai(a, b, c, start, j-1);	  //类比
if(i<end)                     kuaipai(a, b, c, j+1, end);      //类比
} 

//输入a,b,c， 以数组a为标准快速排序，  同时捆绑数组b,c，  两个数组一一对应。