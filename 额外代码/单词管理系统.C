#include<stdio.h>
#include<stdlib.h>
#define MAX 10000
#define DA  10005
struct jiegou    {      char en[25],   cn[25];      };
struct jiegou    word[DA];

//********************************************** 结构体排序 *********************************************************
void kuaipai(struct jiegou s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&strcmp(s[0].en, s[j].en)<0)     j--;	
        if(i<j)                   {  s[i]=s[j];	       i++;	  }
        while(i<j&&strcmp(s[i].en, s[0].en)<=0)    i++;	
        if(i<j)                   {  s[j]=s[i];        j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   kuaipai(s, start, j-1);
    if(i<end)                     kuaipai(s, j + 1, end);
}

//******************************************** 文件读写模块 *********************************************************
void duqu(){
int end;   FILE *fp=NULL;  
fp=fopen("D:\\DanJi.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到DanJi.dat！                           \n");   return;  }  
for(end=1; end<=MAX; end++)           word[end].en[0]='*'; 			end=1;
while(fscanf(fp,"%s %s", word[end].en, word[end].cn)!=EOF)	    	end++;
fclose(fp);
}

void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\DanJi.dat","w+");
if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
for(i=1; i<=MAX; i++)  if(word[i+1].en[0]=='*')  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%s %s\n", word[i].en, word[i].cn);   
fclose(fp);
}

//********************************************** 显示单词 ***********************************************************
void showall(int flag){
	int end;
	system("cls");		printf("\n\n");
	for(end=1; end<=MAX; end++){
		if(word[end].en[0]=='*')		  {    puts("\n\n                                   显示完毕！");     break;   }
		if(flag==1)     printf("%d: %12s          %12s\n", end, word[end].en, word[end].cn);
		if(flag==2)     printf("%d: %12s\n", end, word[end].cn);
		if(flag==3)     printf("%d: %12s\n", end, word[end].en);
	}
	puts("     **********************************************************************     ");
	printf("                              此类单词个数为 %d 个", end-1);
	getchar();     getchar();
}

//*********************************************** 添加新词 *********************************************************
void add(){
	long long end, i;     char hao[30];
	for(end=1; end<=MAX; end++)		         if(word[end].en[0]=='*')   	               break;
	if(end>=MAX)	                    {      puts("添加失败！   单词库已满!!!");            getchar();      return;  }
	printf("请输入新添加的英文单词:      ");     
	scanf("%s", &hao);		
	for(i=1; i<=MAX; i++)		               if(strcmp(word[i].en, hao)==0)	break;
	if(strcmp(word[i].en, hao)==0)     {      puts("\n添加失败！   单词库中已有此单词!\n");   getchar();       return; }
	printf("请输入该单词中文:            ");	   scanf("%s", word[end].cn);
	strcpy(word[end].en, hao);
	puts("\n\n                                   添加完成！\n\n");
	getchar();    getchar();
	system("cls");
}

//*********************************************** 删除旧词 *********************************************************
void del(){              
	int end, i;
	showall(1);
	loop: puts("\n请输入您要删除的编号:   ");    scanf("%d", &end);
	for(i=1; i<=MAX; i++)		           {    if(word[i+1].en[0]=='*')	                      break;         }
	if(end>i||end==0)		                 {    puts("\n不存在此单词， 请检查您的输入！\n");      goto loop;     }  
	while(end<=MAX-1)                     {    word[end]=word[end+1];                         end++;         }
	system("cls");
	printf("\n\n                                   删除成功！ \n\n  \n\n");
	getchar();       getchar();
	system("cls");
}

//********************************************** 3.编辑单词 *********************************************************
void change(){
	int end, i;
	showall(1);		
	puts("\n请输入您要修改的编号:   ");          scanf("%d", &end);
	for(i=1; i<=MAX; i++)		          {    if(word[i+1].en[0]=='*')	                break;                }
	if(end>i||end==0)                    {     puts("查找失败！   单词库中没有此单词!");    getchar();   return;  }
	printf("目前单词信息：   %13s    %13s\n\n", word[end].en, word[end].cn);
	printf("请输入新的英语:      ");            scanf("%s", word[end].en);
	printf("请输入新的中文:      ");            scanf("%s", word[end].cn);	
	puts("\n\n                                   修改完成！\n\n");
	getchar();      getchar();
	system("cls");
}

//******************************************** 3.编辑词库菜单 *********************************************************
int editwin(){
int choice, password;    
printf("\n\n\n请输入操作密码:  ");     scanf("%d", &password);        if(password!=514200)  {    printf("\n\n密码错误！！！\n");   return 1;   }
do{
	duqu();
	puts("                   …………………………………………………                    ");
	puts("                             .请输入选项编号(0~4).         ");
	puts("                   …………………………………………………                    ");
	puts("                     .        1 ——添加新词        .       ");
	puts("                     .        2 ——删除旧词        .        ");
	puts("                     .        3 ——修改旧词        .       ");
	puts("                     .        4 ——返回            .       ");
	puts("                     .        0 ——退出系统        .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		add();	                                                                                 break;
	case 2 :		del();                                                                                  	break;
	case 3 :		change();	                                                                         	      break;
	case 4 :		system("cls");      return 1;	                                                            break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
} 
xieru();
}while(choice!=0);		   
return choice;
}

//************************************************* 查找单词 *********************************************************
void search(){
	int i, end, flag=0;   char hao[30];
	puts("\n                                    查找单词");
	puts("     **********************************************************************     ");
	puts("\n请输入您要查找的单词:   ");       scanf("%s", hao);
	puts("\n");
	for(i=1; i<=MAX; i++)		             if(strcmp(word[i].en, hao)==0||strcmp(word[i].cn, hao)==0)   	{  printf("%d: %12s          %12s\n", i, word[i].en, word[i].cn);  flag=1; }
	if(flag>0)      puts("\n\n                                显示完毕！\n");
	else            puts("\n\n                            没有找到符合条件的结果！\n");
	getchar();    getchar();     system("cls");
}


//******************************************** 2.显示词库菜单 *********************************************************
int chakanwin(){
int choice;    
do{
	puts("                   …………………………………………………                       ");
	puts("                             .请输入选项编号(0~4).            ");
	puts("                   …………………………………………………                       ");
	puts("                     .        1 ——显示所有单词      .       ");
	puts("                     .        2 ——显示中文单词      .        ");
	puts("                     .        3 ——显示英文单词      .       ");
	puts("                     .        4 ——返回              .       ");
	puts("                     .        0 ——退出系统          .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		showall(1);	        system("cls");                                                        break;
	case 2 :		showall(2);         system("cls");                                                       	break;
	case 3 :		showall(3);	        system("cls");                                                        break;
	case 4 :		system("cls");      return 1;	                                                            break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
} 
}while(choice!=0);		   
return choice;
}

//******************************************** 学习之道 *********************************************************
void me(){
printf("               ************************************************\n");
printf("               *                   作者&艺术                  * \n");
printf("               *                                              * \n");
printf("               *           简单， 真不是一件简单的事          *    \n");
printf("               *                                              *  \n");
printf("               *  很庆幸, 我走过的路上有我喜欢的风景……      *     \n");
printf("               *                                              * \n");
printf("               *                                              *   \n");
printf("               *                                              * \n");
printf("               *        但……                                *  \n");
printf("               *        这一切                                * \n");
printf("               *                                              *  \n");
printf("               *        终是物是人非, 终是枯叶成堆            * \n");
printf("               *                                              * \n");
printf("               *                               记于  肇庆学院 *   \n");
printf("               ************************************************\n\n\n\n");
printf("         紧张能让你更清楚地做出选择， 即使在混乱中， 也有规律可循\n\n");
printf("         同样的动作， 却希望有不同结果， 这无异于缘木求鱼…………");
getchar();	getchar();		system("cls");
}

//*************************************************** 主菜单 *********************************************************
int main(void){
int i, choice;
for(i=1; i<=MAX; i++)	   	word[i].en[0]='*';     
duqu();  
do{
	puts("                   …………………………………………………                       ");
	puts("                             .请输入选项编号(0~5).            ");
	puts("                   …………………………………………………                       ");
	puts("                     .        1 ——创建生词库         .       ");
	puts("                     .        2 ——显示词库           .        ");
	puts("                     .        3 ——编辑词库           .       ");
	puts("                     .        4 ——查找生词           .       ");
	puts("                     .        5 ——学习之道           .       ");
	puts("                     .        0 ——退出系统           .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");       puts("\n                                  创建成功\n");	            break;
	case 2 :		system("cls");       choice=chakanwin();                                                 	break;
	case 3 :		system("cls");       choice=editwin();                                            	      break;
	case 4 :		system("cls");       search();	                                                         break;
	case 5 :		system("cls");       me();	                                                               break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
for(i=1; i<=MAX; i++)	   	if(word[i+1].en[0]=='*')     break;      kuaipai(word, 1, i);
xieru(); 
}while(choice!=0);			       		 system("cls");		   
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}