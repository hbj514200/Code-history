void charu(int *a, int n, int x){
	int*h, *l;	
	for(h=a;h<a+n; h++)
		if(*h>x)	          {  l=h;	break; }
	for(h=a+n;h>=l;h--)   *h=*(h-1);	
	*l=x;	
}

//输入第一个数组如a, 第二个为数组长度。第三个是插入数字。
//作用： 将一个有序有序有序数组中插入一个指定数字， 仍然有序。

