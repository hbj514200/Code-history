#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#define MAX 10000
#define DA  10005
struct jiegou  {   long long num, money, shangjiflag;   char name[20];   time_t kaishi; };
struct jiegou ren[DA];
time_t jieshu;

//*************************************************  文件读写模块  ******************************************************
void duqu(){
int i;   FILE *fp=NULL;
for(i=1; i<=MAX+3; i++)	  { 	ren[i].num=-1;        ren[i].money=0;   ren[i].shangjiflag=0;   }
fp=fopen("D:\\duli16.3.dat","r");
if(fp==NULL)   {  puts("\n                         在指定目录下找不到duli16.3.dat！                        \n");   return;  }  i=1;
while(fscanf(fp,"%lld %lld %s %lld %lld", &ren[i].num, &ren[i].money, ren[i].name, &ren[i].kaishi, &ren[i].shangjiflag)!=EOF)		        i++;
fclose(fp);
}

void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\duli16.3.dat","w+");
if(fp==NULL)			  puts("\n       文件写入失败！！\n");
for(i=1; i<=MAX; i++)  if(ren[i+1].num<0)  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%lld %lld %s %lld %lld\n", ren[i].num, ren[i].money, ren[i].name, ren[i].kaishi, ren[i].shangjiflag);   
fclose(fp);
}

//*************************************************  添加新档案  ******************************************************
void addRen(){
	long long end, i, hao;
	for(end=1; end<=MAX; end++)		       if(ren[end].num==-1)	break;
	if(end>=MAX)	                   {   	 puts("\n\n      添加失败！   数据库已满，请联系系统管理员!!!\n\n");    getchar();   return;  }
	printf("请输入新添加的学号:          ");
	scanf("%lld", &hao);		
	for(i=1; i<=MAX; i++)	                if(ren[i].num==hao)	   break;
	if(ren[i].num==hao)              {   	 puts("\n\n添加失败！   数据库中已有此学号!\n\n");                     getchar();   return;  }
	printf("请输入新添加档案的学生姓名:  ");
	scanf("%s", ren[end].name);			
	ren[end].num=hao;		
	puts("\n\n\n\n                                   添加完成！");
	getchar();       getchar();
	system("cls");
	return;
}

//*************************************************  删除旧档案  ******************************************************
void del(){              
	long long hao, end, i;	
	loop3: printf("请输入本次注销档案的学号：    ");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(ren[end].num==hao)	            break;        }
	if(end>=MAX)		               {    puts("\n\n                        不存在此学号， 请检查您的输入！\n\n");     goto loop3;   }  
	printf("\n\n\n                        此档案注销成功！   其原有余额为： %lld 元\n\n\n", ren[end].money);
	for(i=end; i<=MAX; i++)	              ren[i]=ren[i+1];		
	getchar();    getchar();
	system("cls");
	return;
}

//*************************************************  充值模块  ******************************************************
void chongqian(){
	long long hao, end, qian;
	loop1: printf("请输入本次充值的学号：   ");                                           scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(ren[end].num==hao)		                     break;        }
	if(end>=MAX)		               {    puts("\n\n不存在此学号， 请检查您的输入！\n");   goto loop1;   }  
	loop2: printf("请输入本次充值的金额：   ");                                           scanf("%lld", &qian);
	if(qian<1)		                  {    puts("\n\n最少充值1元，请重新输入！！\n");	      goto loop2;   }
	ren[end].money+=qian;
	puts("                            支付成功!\n\n");
	printf("充值前的余额： %lld            充值后的余额： %lld\n\n", ren[end].money-qian, ren[end].money); 
	getchar();      getchar();
	system("cls");
}

//*************************************************  遍历显示模块  ******************************************************
void show(){
	int i;
	system("cls");
	for(i=1; i<=MAX; i++){
		if(ren[i].num==-1)		{    puts("\n显示完毕！");     break;   }
		printf("学号: %13lld   姓名:   %8s   余额: %6lld   \n", ren[i].num, ren[i].name, ren[i].money);
	}
	getchar();	getchar();  	system("cls");
}

//***************************************************  上机模块  *********************************************************
void shangji(){ 
	long long hao, end;
	loop: puts("请输入本次上机的学号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		  if(ren[end].num==hao)		                       break;
	if(end>=MAX)		            {    puts("\n\n不存在此学号， 请检查您的输入！\n\n");   goto loop;   }  
	if(ren[end].money<6)               printf("余额不够，请续钱。\n");
	printf("                                上机成功！\n\n"); 
	ren[end].shangjiflag=1;            ren[end].kaishi=time(NULL);
	getchar();   getchar();
	system("cls");
}

//***************************************************  下机模块  *********************************************************
void xiaji(){ 
	long long hao, end, yongshi, hour, min, sec, g=1;
	loop: puts("请输入本次下机的学号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		  if(ren[end].num==hao)		                              break;
	if(end>=MAX)		            {    puts("\n\n不存在此学号， 请检查您的输入！\n\n");          goto loop;   }  
	if(ren[end].shangjiflag==0)   {    puts("\n\n此学号用户没有在上机， 请检查您的输入！\n\n");   goto loop;   }
	printf("                           下机成功！\n\n"); 
	ren[end].shangjiflag=0;           jieshu=time(NULL);        yongshi=(long long)difftime(jieshu, ren[end].kaishi);
	hour=yongshi/3600;                min=yongshi%3600/60;      sec=yongshi%60;
	printf("\n上机时长为  %lld时  %lld分  %lld秒\n", hour, min, sec);
	while(yongshi>1800)           g++;
   printf("收费为 %lld 元\n", g);
	ren[end].money-=g;
	printf("\n本次消费前余额 %lld 元       目前余额 %lld 元\n", ren[end].money+g, ren[end].money);
	getchar();   getchar();
	system("cls");
}

//***************************************************  主菜单  *********************************************************
int main(void){
int i, choice;
for(i=1; i<=MAX+3; i++)	  { 	ren[i].num=-1;    ren[i].money=0;   ren[i].shangjiflag=0;   } 
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                             .请输入选项编号(0~7):.           ");
	puts("                   …………………………………………………                       ");
	puts("                    .    1 ——建立上机档案             .       ");
	puts("                    .    2 ——开始上机                 .      ");
	puts("                    .    3 ——离开机房                 .      ");
	puts("                    .    4 ——添加新档案               .       ");
	puts("                    .    5 ——注销旧档案               .       ");
	puts("                    .    6 ——续钱                     .       ");
	puts("                    .    7 ——显示数据                 .       ");
	puts("                    .    0 ——退出系统                 .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		xieru();	   system("cls");   puts("\n                                 创建成功！\n");     break;
	case 2 :		shangji();	                                                                        	   break;
	case 3 :		xiaji();	                                                                              	break;
	case 4 :		addRen();                                                                              	break;
	case 5 :		del();	                                                                        	      break;
	case 6 :		chongqian();	                                                                       	   break;
	case 7 :		show();	                                                                            	   break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}

xieru();
}while(choice!=0);			       		 system("cls");		
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}