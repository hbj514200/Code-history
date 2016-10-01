#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<string.h>
#include<stdlib.h>
using namespace std;
#define MAX 10000
#define DA  10005
struct jiegou  {   double num, inrice, outrice, innum, outnum, insum, nowhas, maoli;     char name[50];   };
struct jiegou thing[DA], temthing[DA];
int flag;
//***************************************************  文件模块  *******************************************************
void duqu(){
int i;   FILE *fp=NULL;
for(i=1; i<=MAX+3; i++)   thing[i].num=-1;
fp=fopen("D:\\chaoshi.dat                   ","r");
if(fp==NULL)   {  puts("\n                         在指定目录下找不到chaoshi.dat！                           \n");  flag=1;  return;  }  i=1;
while(fscanf(fp,"%lf %lf %lf %lf %lf %lf %lf %lf %s", &thing[i].num, &thing[i].inrice,  &thing[i].outrice, &thing[i].innum, &thing[i].outnum, &thing[i].insum, &thing[i].nowhas, &thing[i].maoli, thing[i].name)!=EOF)		i++;
fclose(fp);
}

void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\chaoshi.dat","w+");
if(fp==NULL)				 puts("       文件写入失败, 请检查磁盘访问权限！！\n");
for(i=1; i<=MAX; i++)  if(thing[i+1].num<0)  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%.0f %lf %lf %lf %lf %lf %lf %lf %s\n", thing[i].num, thing[i].inrice,  thing[i].outrice, thing[i].innum, thing[i].outnum, thing[i].insum, thing[i].nowhas, thing[i].maoli, thing[i].name);   
fclose(fp);
}
//******************************************  自定义结构体比较函数cmp  ***************************************************
bool xiaocmp(struct jiegou a, struct jiegou b)   {		if(a.insum<b.insum)   return true;      else   return false;		}
bool maocmp (struct jiegou a, struct jiegou b)   {		if(a.maoli<b.maoli)   return true;      else   return false;		}

//**************************************************  5.分屏显示  **********************************************************
void fenpin(int flag){
	int i, big;
	system("cls");
	printf("  ****************************************************************************\n     编号                名字                  销售额      剩余数     毛利\n");
	if(flag==1){
		for(i=1; i<=MAX; i++){
		if(temthing[i].num<0)		{    	printf("  ***************************************************************************\n                                  显示完毕！");        break;   }
		printf("  %13.0f     %23s     %7.1f   %7.0f     %7.1f\n", thing[i].num, thing[i].name, thing[i].insum, thing[i].nowhas, thing[i].maoli);
		}
	}
	else {
		for(big=1; big<=MAX; big++)			if(temthing[big+1].num<0)		break;
		for(i=big; i>=1; i--){
		if(temthing[i].num<0)		{    	printf("  ***************************************************************************\n                                  显示完毕！");        break;   }
		printf("  %13.0f     %23s     %7.1f   %7.0f     %7.1f\n", thing[i].num, thing[i].name, thing[i].insum, thing[i].nowhas, thing[i].maoli);
		}
	}
	getchar();	getchar();  	system("cls");
}

//*************************************************  原序显示(5)  *******************************************************
void yuansort(){
	system("cls");
	int i;
	for(i=1; i<=MAX; i++)		temthing[i]=thing[i];
	printf("\n                                 原来顺序显示                      \n\n");
	fenpin(1);
}
//*************************************************  销额显示(5)  *******************************************************
void xiaosort(){
   system("cls");
	int i;
	for(i=1; i<=MAX; i++)		temthing[i]=thing[i];
	for(i=1; i<=MAX; i++)		if(temthing[i+1].num<0)		break;
	sort(temthing+1, temthing+i+1, xiaocmp);
	printf("\n                                销售额顺序显示                      \n\n");
	fenpin(2);
}
//*************************************************  毛利显示(5)  *******************************************************
void maosort(){
	system("cls");
	int i;
	for(i=1; i<=MAX; i++)		temthing[i]=thing[i];
	for(i=1; i<=MAX; i++)		if(temthing[i+1].num<0)		break;
	sort(temthing+1, temthing+i+1, maocmp);
	printf("\n                                毛利顺序显示                      \n\n");
	fenpin(2);
}

//***************************************************  添加商品  *******************************************************
void add(){
	long end, i, hao;
	for(end=1; end<=MAX; end++)   if(thing[end].num==-1)	break;
	if(end>=MAX)	        {   	puts("添加失败！   数据库已满，请联系系统管理员!!!");    getchar();   return;  }
	printf("请输入新商品编号:  ");
	scanf("%lld", &hao);		
	for(i=1; i<=MAX; i++)		   if(thing[i].num==hao)	break;
	if(thing[i].num==hao)  {   	puts("添加失败！   数据库中已有此商品信息!");    getchar();   return;  }
	       printf("请输入商品名字:    ");		scanf("%s",  thing[end].name);		 
	loop1: printf("请输入商品进价:    ");	   scanf("%lf", &thing[end].inrice);	 if(thing[end].inrice<0)	goto loop1;
	loop2: printf("请输入商品售价:    ");	   scanf("%lf", &thing[end].outrice);	 if(thing[end].outrice<0)	goto loop2;
	loop3: printf("请输入商品进货数量: ");	scanf("%lf", &thing[end].innum);		 if(thing[end].innum<0)  	goto loop3;
	loop4: printf("请输入商品销售数量: ");	scanf("%lf", &thing[end].outnum);    if(thing[end].outnum<0||thing[end].outnum>thing[end].innum)	goto loop4;
	thing[end].num=(double)hao;
	thing[end].nowhas=thing[end].innum-thing[end].outnum;
	thing[end].insum=thing[end].outrice*thing[end].outnum;
	thing[end].maoli=thing[end].insum-thing[end].inrice*thing[end].outnum;
	system("cls");        puts("                                  添加完成!\n\n");
	getchar();
	return;
}

//***************************************************  修改商品  *******************************************************
void change(){
	long end, hao;
	printf("请输入商品编号:  ");
	scanf("%lld", &hao);		
	for(end=1; end<=MAX; end++)		      if(thing[end].num==hao)	break;
	if(end>=MAX)                       {   puts("查找失败！   数据库中没有此商品信息!");    getchar();   return;  }
	printf("\n                                 原有商品信息                      \n\n");
	printf("  ****************************************************************************\n\n");
	printf("   编号: %13.0f  名字: %17s  进货价: %4.1f  零售价: %4.1f\n   进货量: %4.0f   总销量: %4.0f   销售额: %6.1f    库存: %4.0f  毛利: %6.1f\n\n", thing[end].num, thing[end].name, thing[end].inrice,  thing[end].outrice, thing[end].innum, thing[end].outnum, thing[end].insum, thing[end].nowhas, thing[end].maoli);    
	printf("\n\n\n                               请输入新的商品信息                      \n");
	printf("  ****************************************************************************\n\n");
	loop:  printf("请输入商品编号:    ");	   scanf("%lf", &thing[end].num);	 if(thing[end].num<0)	      goto loop;
	       printf("请输入商品名字:    ");		scanf("%s",  thing[end].name);		 
	loop1: printf("请输入商品进价:    ");	   scanf("%lf", &thing[end].inrice);	 if(thing[end].inrice<0)	goto loop1;
	loop2: printf("请输入商品售价:    ");	   scanf("%lf", &thing[end].outrice);	 if(thing[end].outrice<0)	goto loop2;
	loop3: printf("请输入商品进货数量: ");	scanf("%lf", &thing[end].innum);		 if(thing[end].innum<0)  	goto loop3;
	loop4: printf("请输入商品销售数量: ");	scanf("%lf", &thing[end].outnum);    if(thing[end].outnum<0||thing[end].outnum>thing[end].innum)	goto loop4;
	thing[end].num=(double)hao;
	thing[end].nowhas=thing[end].innum-thing[end].outnum;
	thing[end].insum=thing[end].outrice*thing[end].outnum;
	thing[end].maoli=thing[end].insum-thing[end].inrice*thing[end].outnum;
	system("cls");        puts("                                  添加完成!\n\n");
	getchar();
	return;
}

//***************************************************  名字查找  *******************************************************
void chaname(){              
	long hao, end, flag=0;		char st[30];
	system("cls");
	printf("请输入查找商品名字：     ");
	scanf("%s", st);
	printf("\n                                  查找结果                      \n\n");
	printf("  ****************************************************************************\n\n");
	for(end=1; end<=MAX; end++)  	 if(strstr(thing[end].name,st)!=NULL)	 {  printf("   编号: %13.0f  名字: %17s  进货价: %4.1f  零售价: %4.1f\n   进货量: %4.0f   总销量: %4.0f   销售额: %6.1f    库存: %4.0f  毛利: %6.1f\n\n", thing[end].num, thing[end].name, thing[end].inrice,  thing[end].outrice, thing[end].innum, thing[end].outnum, thing[end].insum, thing[end].nowhas, thing[end].maoli);     flag++;     }    
	if(!flag)                        puts("\n                            找不到符合要求的商品！\n\n");  
	printf("  ****************************************************************************\n\n");
	xieru();
	getchar();	getchar();	system("cls");
}

//***************************************************  库存查找  *******************************************************
void chahas(){              
	long hao, end, flag=0, choice;
	system("cls");
	loop: printf("请输入您的筛选条件：   1. 库存小于5    2. 库存大于20\n");			
	scanf("%lld", &choice);																	if(choice!=1&&choice!=2)	goto loop;
	printf("\n                                  查找结果                      \n\n");
	printf("  ****************************************************************************\n\n");
	for(end=1; end<=MAX; end++)  	 if((choice==1&&thing[end].nowhas<5&&thing[end].num>0)||(choice==2&&thing[end].nowhas>20))	 {  printf("   编号: %13.0f  名字: %17s  进货价: %4.1f  零售价: %4.1f\n   进货量: %4.0f   总销量: %4.0f   销售额: %6.1f    库存: %4.0f  毛利: %6.1f\n\n", thing[end].num, thing[end].name, thing[end].inrice,  thing[end].outrice, thing[end].innum, thing[end].outnum, thing[end].insum, thing[end].nowhas, thing[end].maoli);     flag++;     }    
	if(!flag)                        puts("\n                            找不到符合要求的商品！\n\n");  
	printf("  ****************************************************************************\n\n");
	xieru();
	getchar();	getchar();	system("cls");
}

//************************************************  关于作者  **********************************************************
void me(){
printf("               ************************************************\n");
printf("               *                   作者&艺术                  * \n");
printf("               *                                              * \n");
printf("               *  思维也许是神性的残留, 在纯思的时间里更容易  *    \n");
printf("               *  认知事物的本质, 却也真的冰冷……            *     \n");
printf("               *    许多问题, 没有答案                        *  \n");
printf("               *  同样                                        * \n");
printf("               *    许多答案, 一样没有为什么                  *   \n");
printf("               *  徒留                                        * \n");
printf("               *        求之不得                              *  \n");
printf("               *  抑或                                        * \n");
printf("               *        弃而不舍                              *  \n");
printf("               *                                              * \n");
printf("               *                                              * \n");
printf("               *                          By 左手程式 右手诗  *   \n");
printf("               ************************************************\n");
getchar();	getchar();		system("cls");
}

//**************************************************  3.统计  **********************************************************
void showall(){
	int i;
	system("cls");
	printf("                                  销售统计                      \n\n");
	printf("  ****************************************************************************\n     编号                名字                  销售额      剩余数     毛利\n");
	for(i=1; i<=MAX; i++){
		if(thing[i].num==-1)		{    	printf("  ***************************************************************************\n                                  显示完毕！");        break;   }
		printf("  %13.0f     %23s     %7.1f   %7.0f     %7.1f\n", thing[i].num, thing[i].name, thing[i].insum, thing[i].nowhas, thing[i].maoli);
	}
	getchar();	getchar();  	system("cls");
}

//************************************************  删除商品  **********************************************************
void del(){              
	long hao, end, i;	
	loop3: puts("请输入本次删除的商品号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(thing[end].num==hao)	                 break;        }
	if(end>=MAX)		               {    puts("\n\n不存在此商品号， 请检查您的输入！");   goto loop3;   }  
	for(i=end; i<=MAX; i++)		      thing[i]=thing[i+1];		
	system("cls");	printf("                              此商品信息删除成功！ \n\n\n\n");
	xieru();
	getchar();
}

//**************************************************  5显示菜单  *******************************************************
int showwin(){
int i, choice;       
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                           .请输入选项编号(0 ~ 4):.           ");
	puts("                   …………………………………………………                       ");
	puts("                    .      1 ——按原来顺序显示             .    ");
	puts("                    .      2 ——按销售额高低显示            .   ");
	puts("                    .      3 ——按毛利高低显示              .   ");
	puts("                    .      4 ——返回                       .   ");
	puts("                    .      0 ——退出系统                   .    ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		yuansort();	                                                                          break;
	case 2 :		xiaosort(); 	                                                                          break;
	case 3 :		maosort();                                                                           break;
	case 0 :		                                                                                          return 0;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
xieru();
}while(choice!=0);
return 1;	
}

//**************************************************  4查找菜单  *******************************************************
int chawin(){
int i, choice;       
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                           .请输入选项编号(0 ~ 3):.           ");
	puts("                   …………………………………………………                       ");
	puts("                    .      1 ——按品名查询            .       ");
	puts("                    .      2 ——按剩余数查            .       ");
	puts("                    .      3 ——返回                  .       ");
	puts("                    .      0 ——退出系统              .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		chaname();	                                                                              break;
	case 2 :		chahas();  	                                                                              break;
	case 3 :		system("cls");   return 1;                                                                break;
	case 0 :		                                                                                          return 0;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
xieru();
}while(choice!=0);
return 1;	
}

//**************************************************  2编辑菜单  *******************************************************
int editwin(){
int i, choice;       
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                           .请输入选项编号(0 ~ 4):.           ");
	puts("                   …………………………………………………                       ");
	puts("                    .      1 ——添加新商品             .       ");
	puts("                    .      2 ——删除原有商品           .       ");
	puts("                    .      3 ——修改原有商品信息       .       ");
	puts("                    .      4 ——返回                  .       ");
	puts("                    .      0 ——退出系统               .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		add();	                                                                                 break;
	case 2 :		del();  	                                                                           	   break;
	case 3 :		change();	                                                                           	break;
	case 4 :		system("cls");   return 1;                                                                break;
	case 0 :		                                                                                          return 0;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
xieru();
}while(choice!=0);
return 1;	
}

//****************************************************  主菜单  *******************************************************
int main(void){
int i, choice;
for(i=1; i<=MAX+3; i++)	   	thing[i].num=-1;       
do{
	duqu();
	flag=0;
	puts("                   …………………………………………………                      ");
	puts("                           .请输入选项编号(0 ~ 6):.          ");
	puts("                   …………………………………………………                      ");
	puts("                    .      1 ——创建商品文件         .        ");
	puts("                    .      2 ——编辑商品             .        ");
	puts("                    .      3 ——统计销售情况         .         ");
	puts("                    .      4 ——查询商品信息         .         ");
	puts("                    .      5 ——显示商品信息         .         ");
	puts("                    .      6 ——关于作者             .        ");
	puts("                    .      0 ——退出系统             .         ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");       xieru();             printf("\n                                   创建");   if(!flag) printf("成功!\n\n\n"); else printf("失败!\n\n\n");       break;
	case 2 :		system("cls");		   choice=editwin();	                                                      break;                                                                        	   break;
	case 3 :		system("cls");       showall();	                                                      	   break;
	case 4 :		system("cls");		   choice=chawin();                                                    	   break;
	case 5 :		system("cls");		   choice=showwin();	                                           	         break;
	case 6 :		system("cls");       me();	                                                                  break;
	case 0 :		                                                                                             break;
	default:		system("cls");       puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");   break;
}
xieru();
}while(choice!=0);			         system("cls");		
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}