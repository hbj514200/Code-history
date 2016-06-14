
FILE *fp;
fp=fopen("c:\\1.txt","w+");                   //开头部分，默认C盘

fprintf(fp,"\nHello world\n%d\n", x);   //用法和printf相同

fclose(fp);                             //程序结尾关闭文件  
