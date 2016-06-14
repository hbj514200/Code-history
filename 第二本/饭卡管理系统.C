#include<stdio.h>
#include<stdlib.h>
#define MAX 10000
#define DA  10005
struct jiegou  {   long long num, guashi;  double money;   char name[20];   };
struct jiegou fanka[DA];

void duqu(){
int i;   FILE *fp=NULL;
for(i=1; i<=MAX; i++)   fanka[i].num=-1;
fp=fopen("D:\\card.dat","r");
if(fp==NULL)   {  puts("\n                         在指定目录下找不到card.dat！                           \n");   return;  }  i=1;
while(fscanf(fp,"%lld %s %lld %lf", &fanka[i].num, fanka[i].name,  &fanka[i].guashi, &fanka[i].money)!=EOF)		i++;
fclose(fp);
}

void show(){
	int i;
	system("cls");
	for(i=1; i<=MAX; i++){
		if(fanka[i].num==-1)		{    puts("\n显示完毕！");     break;   }
		printf("卡号: %13lld   姓名:   %7s   余额: %6.1f   状态: %lld\n", fanka[i].num, fanka[i].name, fanka[i].money, fanka[i].guashi);
	}
	getchar();	getchar();  	system("cls");
}

void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\card.dat","w+");
if(fp==NULL)				 puts("       文件写入失败！！\n");
for(i=1; i<=MAX; i++)  if(fanka[i+1].num<0)  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%lld %s %lld %.1f\n", fanka[i].num, fanka[i].name, fanka[i].guashi, fanka[i].money);   
fclose(fp);
}

void guashi(){              
	long long hao, end, choice;	
	loop4: puts("请选择本次操作类型：   1. 挂失      2. 解除挂失");
	scanf("%lld", &choice);					if(choice!=1&&choice!=2) 	{   puts("\n选择有误，请重新选择！\n");   goto loop4;  }
	loop5: puts("请输入饭卡号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		if(fanka[end].num==hao)		break;	
	if(end>=MAX)	   {    puts("不存在此饭卡号， 请检查您的输入！");                                     goto loop5;    }  
	if(choice==1)		{    fanka[end].guashi=0;   puts("\n                         成功， 此饭卡已处于锁定状态！\n");    }
	if(choice==2)		{    fanka[end].guashi=1;   puts("\n                         成功， 此饭卡已处于解锁状态！\n");    }
	xieru();
	getchar();
}

void addCard(){
	long long end, i, hao;
	for(end=1; end<=MAX; end++)		if(fanka[end].num==-1)	break;
	if(end>=MAX)	        {   	puts("添加失败！   数据库已满，请联系系统管理员!!!");    getchar();   return;  }
	puts("请输入新添加的饭卡号: ");
	scanf("%lld", &hao);		
	for(i=1; i<=MAX; i++)		if(fanka[i].num==hao)	break;
	if(fanka[i].num==hao)  {   	puts("添加失败！   数据库中已有此饭卡号!");    getchar();   return;  }
	puts("请输入新添加饭卡的持卡人姓名: ");
	scanf("%s", fanka[end].name);			
	fanka[end].num=hao;		fanka[end].guashi=1;
	puts("添加完成！");
	xieru();
	getchar();
	return;
}

void del(){              
	long long hao, end, i;	
	loop3: puts("请输入本次注销的饭卡号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(fanka[end].num==hao)	                 break;        }
	if(end>=MAX)		               {    puts("不存在此饭卡号， 请检查您的输入！");   goto loop3;   }  
	if(fanka[end].guashi==0)		   {    puts("本卡已冻结！");         getchar();   return;       }
	for(i=end; i<=MAX; i++)		fanka[i]=fanka[i+1];		
	printf("                            此饭卡注销成功！ \n\n  其原有余额为： %.1f 元\n\n", fanka[end].money);
	xieru();
	getchar();
	return;
}

void chongqian(){
	long long hao, end;		double qian;
	loop1: puts("请输入本次充值的饭卡号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(fanka[end].num==hao)		              break;        }
	if(end>=MAX)		               {    puts("不存在此饭卡号， 请检查您的输入！");   goto loop1;   }  
	if(fanka[end].guashi==0)		   {    puts("本卡已冻结！");     getchar();       return;       }
	loop2: puts("请输入本次充值的金额：");
	scanf("%lf", &qian);
	if(qian<0.1)		               {    puts("最少充值1分钱，请重新输入！！");	     goto loop2;   }
	fanka[end].money+=qian;
	puts("                            支付成功!\n\n");
	printf("充值前的余额： %.1f            充值后的余额： %.1f\n\n", fanka[end].money-qian, fanka[end].money); 
	xieru();
}

void buyFan(){ 
	long long hao, end;		double qian;
	loop: puts("请输入本次购买的饭卡号：");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		  if(fanka[end].num==hao)		              break;
	if(end>=MAX)		            {    puts("不存在此饭卡号， 请检查您的输入！");   goto loop;   }  
	if(fanka[end].guashi==0)		{    puts("本卡已冻结！");         getchar();   return;      }
	puts("请输入本次购买的金额：");
	scanf("%lf", &qian);
	if(fanka[end].money<5)        printf("余额不够，请续钱。\n");
	if(fanka[end].money<qian)     printf("余额不足，无法完成此次支付\n本次交易需要%.1f元      目前账户余额：  %.1f元\n", qian, fanka[end].money);
	if(fanka[end].money>=qian)    {     fanka[end].money-=qian;    printf("                            支付成功！\n\n交易前的余额： %.1f            交易后的余额： %.1f\n", fanka[end].money+qian, fanka[end].money); 
   }
	xieru();
}

int main(void){
int i, choice;
for(i=1; i<=MAX+3; i++)	  { 	fanka[i].num=-1;    fanka[i].guashi=0;   }
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                             .请输入选项编号(0~7):.           ");
	puts("                   …………………………………………………                       ");
	puts("                    .    1 ——建立饭卡文件             .       ");
	puts("                    .    2 ——买饭                     .      ");
	puts("                    .    3 ——续钱                     .      ");
	puts("                    .    4 ——添加新饭卡               .       ");
	puts("                    .    5 ——注销旧饭卡               .       ");
	puts("                    .    6 ——设置与解除挂失           .       ");
	puts("                    .    7 ——显示数据                 .       ");
	puts("                    .    0 ——退出系统                 .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		xieru();	   system("cls");   puts("\n                                 创建成功！\n");      break;
	case 2 :		buyFan();	                                                                        	   break;
	case 3 :		chongqian();	                                                                        	break;
	case 4 :		addCard();                                                                              	break;
	case 5 :		del();	                                                                        	      break;
	case 6 :		guashi();	                                                                        	   break;
	case 7 :		show();	                                                                            	   break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}

}while(choice!=0);			       		 system("cls");		
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}

//挂失变量1为可用，0为锁定。
//所有字符串不允许出现空格！