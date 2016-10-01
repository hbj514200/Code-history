#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define MAX 10000
#define DA  10005
struct jiegou {  char num[20], name[20];     int yuanjia, yuannum, nowhas;  };
struct jiagou {  char num[20]; int jiedate,  zujienum;                      };
struct jiegou book[DA];
struct jiagou ren[DA];
//*********************************************  日期作差模块  *********************************************************
int dayu(int n){
	int year, m, d;
	int sum=0, i, j, k, a[12]={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };	
   int b[12]={ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	if(n/10000000==0)              n*=10;
	year=n/10000;  m=(n/100)%100;  d=n%100;
    if(year%4==0&&year%100!=0||year%400==0)
        for(i=0; i<m-1; i++)
            sum=sum+b[i];
    else
        for (i=0; i<m-1; i++)
            sum=sum+a[i];
    for (j=1900; j<year; j++)
        if (j%4==0&&j%100!=0||j%400==0)
            sum=sum+366;					
    else
        sum=sum+365;						
    sum=sum+d; 						
    return sum; 							
}

//*********************************************  书籍读写模块  *********************************************************
void xieruBook(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\Book.dat","w+");
if(fp==NULL)			  {     puts("\n\n\n       音像记录文件写入失败！！\n\n\n");    getchar();   }
for(i=1; i<=MAX; i++)  if(book[i+1].num[0]=='a')  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%s %s %d %d %d\n", book[i].num, book[i].name, book[i].yuanjia, book[i].yuannum, book[i].nowhas);   
fclose(fp);
}

void duquBook(){
int i;   FILE *fp=NULL;
for(i=1; i<=MAX; i++)   book[i].num[0]='a';
fp=fopen("D:\\Book.dat","r");
if(fp==NULL)   {  puts("\n                         在指定目录下找不到Book.dat！                           \n");   return;  }  i=1;
while(fscanf(fp,"%s %s %d %d %d", book[i].num, book[i].name, &book[i].yuanjia, &book[i].yuannum, &book[i].nowhas)!=EOF)		i++;
fclose(fp);
}

//*********************************************  出借读写模块  *********************************************************
void xieruRen(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\borrow.dat","w+");
if(fp==NULL)			  {     puts("\n\n\n       出借记录文件写入失败！！\n\n\n");    getchar();   }
for(i=1; i<=MAX; i++)  if(ren[i+1].num[0]=='a')  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%s %d %d\n", ren[i].num, ren[i].jiedate, ren[i].zujienum);   
fclose(fp);
}

void duquRen(){
int i;   FILE *fp=NULL;
for(i=1; i<=MAX; i++)   ren[i].num[0]='a';
fp=fopen("D:\\borrow.dat","r");
if(fp==NULL)   {  puts("\n                         在指定目录下找不到borrow.dat！                           \n");   return;  }  i=1;
while(fscanf(fp,"%s %d %d", ren[i].num, &ren[i].jiedate, &ren[i].zujienum)!=EOF)		i++;
fclose(fp);
}

//*********************************************  新建租借信息  *********************************************************
void zuBook(){
	int end, i;		char st[20];
	for(end=1; end<=MAX; end++)   if(ren[end].num[0]=='a')           break;
	if(end>=MAX)            {     puts("\n\n                         数据库已满，请联系系统管理员！！！\n\n");   getchar();  return;   }

system("cls");
puts("\n                                   租借登记                                       ");
puts(" ******************************************************************************\n\n");
loop: printf("请输入需要租借的影像图书的编号:  ");        scanf("%s", st);                   
		printf("请输入租借者的编号:              ");       scanf("%d", &ren[end].zujienum);
      printf("请输入租借日期:                  ");      scanf("%d", &ren[end].jiedate);

for(i=1; i<=MAX; i++)        if(strcmp(book[i].num, st)==0)    break; 
if(i>=MAX)              {    puts("\n\n                        无此音像图书！!\n\n");   getchar();  goto loop;  }
if(book[i].nowhas<1)    {    puts("本音像图书库存为零！！");     getchar();              return;                 }
printf("\n                          登记完毕， 应交押金为 %d 元\n\n\n\n",    book[i].yuanjia*3);	  book[i].nowhas--;
strcpy(ren[end].num, st);    
getchar();    getchar();
system("cls");
}
  
//*********************************************  购进书籍模块  *********************************************************
void addBook(){
	int end, i, tem, pos;	      	char hao[20];
	for(end=1; end<=MAX; end++)		if(book[end].num[0]=='a')	    break;      
	if(end>=MAX)	           {   	puts("                         添加失败！   数据库已满，请联系系统管理员!!!");    getchar();   return;  }
	printf("请输入新购进的音像图书编号:       ");			             scanf("%s", hao);		           
	for(i=1; i<=MAX; i++)		               if(strcmp(book[i].num, hao)==0)	 break;

	if(strcmp(book[i].num, hao)==0)  {
		printf("\n数据库中已有此音像图书， 请输入本次购进的数量:    ");
		scanf("%d", &pos);                     book[i].nowhas+=tem;
		printf("\n\n                         添加成功！   此音像图书目前共有 %d 件\n\n", book[i].nowhas);     
		getchar();     getchar();
		system("cls");
		return;  
	}
	
	printf("请输入新购进的影像图书名字:        ");                             scanf("%s", book[end].name);			
	printf("请输入新购进的影像图书原价:        ");                             scanf("%d", &book[end].yuanjia);	                             
	printf("请输入新购进的影像图书原数量:      ");                             scanf("%d", &book[end].yuannum);
	printf("请输入新购进的影像图书剩余数量:    ");                             scanf("%d", &book[end].nowhas);
	strcpy(book[end].num, hao);
	puts("\n\n                               添加完成！\n\n");
	getchar();			getchar();
	system("cls");
	return;
}

//*********************************************  删除书籍模块  *********************************************************
void del(){              
	char hao[20];   int end, i;	
	loop3: puts("请输入本次报废的音像图书编号：     ");
	scanf("%s", hao);
	for(end=1; end<=MAX; end++)		               {    if(strcmp(book[end].num, hao)==0)	                break;        }
	if(end>=MAX)		                              {    puts("\n\n不存在此书籍号， 请检查您的输入！\n\n");   goto loop3;   }  
	if(book[end].nowhas!=book[end].yuannum)		   {    puts("\n该影像图书仍有出借, 不可报废\n\n\n");       getchar();        return;       }
	for(i=end; i<=MAX; i++)		book[i]=book[i+1];		
	printf("                            此音像图书报废成功！ \n\n");
	getchar();     getchar();
	system("cls");
}

//*********************************************  归还书籍模块  *********************************************************
void huanBook(){
		char hao[20];   int end, end2, i, tian, huandate, qian, zujiehao;	
	loop3: puts("请输入本次归还的音像图书编号：     ");
	scanf("%s", hao);
			 puts("请输入本次归还的租借者编号：     ");
	scanf("%d", &zujiehao);       
	for(end=1; end<=MAX; end++)		               {    if(strcmp(book[end].num, hao)==0)	                break;        }
	if(end>=MAX)		                              {    puts("\n\n不存在此书籍号， 请检查您的输入！\n\n");   goto loop3;   }
	for(end2=1; end2<=MAX; end2++)		            {    if(ren[end2].zujienum==zujiehao)	                break;        }
	if(end2>=MAX)		                              {    puts("\n\n不存在此租借者号， 请检查您的输入！\n\n");  goto loop3;   }
	puts("请输入本次归还的日期：     ");                   scanf("%d", &huandate);

	tian=dayu(huandate)-dayu(ren[end].jiedate);	printf("天数： %d\n", tian);
	if(book[end].num[0]=='B')          qian=tian*1;
	if(book[end].num[0]=='V')          qian=tian*2;    
	if(book[end].num[0]=='R')          qian=tian*3;

	for(i=end2; i<=MAX; i++)		     ren[i]=ren[i+1];            ren[MAX].num[0]='a';
	if(book[end].yuanjia*3-qian>=0)	  printf("\n\n押金： %d 元     租金: %d 元     应退 %d 元\n", book[end].yuanjia*3, qian, book[end].yuanjia*3-qian);
	else                               printf("\n\n押金： %d 元     租金: %d 元     应退 0 元\n", book[end].yuanjia*3, qian);
	book[end].nowhas++;
	getchar();		getchar();
	system("cls");
}                               

//***********************************************  关于作者  *********************************************************
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
getchar();	getchar();		system("cls");
}

//************************************************  主菜单  *********************************************************
int main(void){
int i, choice;
do{
	duquBook();
	duquRen();
	puts("                           ………………………………                   ");
	puts("                           .请输入选项编号(0 ~ 6)：.      ");
	puts("                           ……………………………");
	puts("                           . 1——创建音像图书库 .          ");
	puts("                           . 2——租借音像图书   .          ");
	puts("                           . 3——归还音像图书   .          ");
	puts("                           . 4——购进音像图书   .          ");
	puts("                           . 5——报废音像图书库 .          ");
	puts("                           . 6——关于作者       .          ");
	puts("                           . 0——退出系统       .          ");
	puts("                           ………………………………");

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");    xieruBook(); puts("\n                                  创建成功！\n");   break;
	case 2 :		system("cls");    zuBook();	                                                        	   break;
	case 3 :		huanBook();	                                                                             	break;
	case 4 :		addBook();                                                                                break;
	case 5 :		del();	                                                                        	      break;
	case 6 :		me();	                                                                              	   break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}

xieruBook();
xieruRen();
}while(choice!=0);			       		 system("cls");		
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}