#include<stdio.h>
void chapai(int a[], int n){  
int i, j, temp;  
for(i=2; i<=n; i++)  
if (a[i]<a[i-1])  
{  
temp=a[i];  
for(j=i-1; j>=1&&a[j]>temp; j--)       a[j+1]=a[j];  
a[j+1]=temp;  
}  
}  

//插入排序， 从1开始， n为长度末尾，  有序度较高时可用