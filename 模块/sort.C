#include<algorithm>
using namespace std;
bool cmp(int a,int b)   {   return a>b;   }

sort(z+1,z+n+1,cmp);

升序时候对数组a的a[1]到a[100]排序， sort(a+1,a+100+1);
降序的时候数组a的a[1]到a[100]排序， sort(a+1,a+100+1,cmp);   cmp函数如上。  可以自己定义
