void nixv(int *x, int n){
    int *p, temp, *i, *j, m=(n-1)/2;
    i=x;  j=x+n-1; m p=x+m;
    for(;i<=p; i++, j--)
{ temp=*i;  *i=*j;  *j=temp;  }
    return 0;
}

//输入一个数组名如a， 还有它的数组长度（由于是
//指针表示， 长度表示元素个数）。
//这是一个void函数， 逆序排列数组中所有元素。
//可修改为字符数组