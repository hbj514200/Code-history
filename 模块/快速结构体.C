void kuaipai(struct poin s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&s[0].key<s[j].key)     j--;	
        if(i<j)                   {   s[i] = s[j];	 i++;	}
        while(i<j&&s[i].key<=s[0].key)    i++;	
        if(i<j)                   {  s[j]=s[i]; j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   kuaipai(s, start, j-1);									/*对分割出的部分递归调用函数qusort()*/
    if(i<end)                     kuaipai(s, j + 1, end);
}

//输入和以前一样， 以结构体中的key为标准排序