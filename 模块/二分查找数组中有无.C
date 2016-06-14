int search(int key, int a[], int n){
    int low=0, high=n-1, mid;
    while(low<=high){								                        /*当查找范围不为0时执行循环体语句*/
        mid=(low+high)/2;						                        /*求出中间位置*/
        if(key<a[mid])	            high=mid-1;							/*当key小于中间值*/
        else if(key>a[mid])			low=mid+1;				/*当key大于中间值*/
        else if(key==a[mid])			{ return 1; break;  }
    }
        return 0;							
}

//输入三个int值: 查找元素key, 有序有序有序数组a[], 数组长度n。 
//发现该数组中含有key， 则返回1； 否则返回0；
//数组从0开始，   若从1开始， 修改第二行low=1; hight=n； 即可。