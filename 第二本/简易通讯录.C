#include<stdio.h>
#include<stdlib.h>
#define MAX 5000
#define DA  5005
struct jiegou  {   long long num, youbian;    char name[20], address[60], mail[30];   };
struct jiegou ren[DA];

void duqu(){
int end;   FILE *fp=NULL;  
fp=fopen("D:\\TongXun.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到TongXun.dat！                           \n");   return;  }  
for(end=1; end<=MAX; end++)   ren[end].num=-1; 					end=1;
while(fscanf(fp,"%lld %lld %s %s %s", &ren[end].num, &ren[end].youbian, ren[end].name, ren[end].address, ren[end].mail)!=EOF)		end++;
fclose(fp);
}

void show(){
	int end;
	system("cls");		printf("\n\n");
	for(end=1; end<=MAX; end++){
		if(ren[end].num==-1)		  {    puts("\n\n                                   显示完毕！");     break;   }
		printf("号码：%12lld  姓名: %s  邮编: %6lld\n地址: %s  邮箱: %s\n\n", ren[end].num, ren[end].name, ren[end].youbian, ren[end].address, ren[end].mail);
	}
}

void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\TongXun.dat","w+");
if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
for(i=1; i<=MAX; i++)  if(ren[i+1].num<0)  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%lld %lld %s %s %s\n", ren[i].num, ren[i].youbian, ren[i].name, ren[i].address, ren[i].mail);   
fclose(fp);
}

void change(){
	long long end, hao;
	printf("请输入需要修改的电话号码:      ");
	scanf("%lld", &hao);		
	for(end=1; end<=MAX; end++)		if(ren[end].num==hao)	break;
	if(end>=MAX)  {   	puts("查找失败！   数据库中没有此号码!");    getchar();   return;  }
	printf("目前信息：\n\n号码：%lld  姓名: %s  邮编: %lld\n  地址: %s  邮箱: %s\n\n", ren[end].num, ren[end].name, ren[end].youbian, ren[end].address, ren[end].mail);
	printf("请输入号码:      ");         scanf("%lld", &ren[end].num);
	printf("请输入姓名:      ");			scanf("%s", ren[end].name);
	printf("请输入邮编:      ");		   scanf("%lld", &ren[end].youbian);
   printf("请输入地址:      ");		   scanf("%s", ren[end].address);
   printf("请输入邮箱:      ");		   scanf("%s", ren[end].mail);
	puts("\n\n                                   修改完成！\n\n");
	getchar();
	return;
}

void add(){
	long long end, i, hao;
	for(end=1; end<=MAX; end++)		  if(ren[end].num==-1)	break;
	if(end>=MAX)	           {      puts("添加失败！   数据库已满，请联系系统管理员!!!");    getchar();   return;  }
	printf("请输入新添加的电话号码:      ");
	scanf("%lld", &hao);		
	for(i=1; i<=MAX; i++)		      if(ren[i].num==hao)	break;
	if(ren[i].num==hao)       {      puts("\n添加失败！   数据库中已有此号码!\n"); getchar();                  return; }
	printf("请输入姓名:      ");	   scanf("%s", ren[end].name);
	ren[end].num=hao;
	printf("请输入邮编:      ");	   scanf("%lld", &ren[end].youbian);
   printf("请输入地址:      ");		scanf("%s", ren[end].address);
   printf("请输入邮箱:      ");		scanf("%s", ren[end].mail);
	puts("\n\n                                   添加完成！\n\n");
	getchar();
	return;
}

void del(){              
	long long hao, end;	
	loop3: printf("请输入要删除的号码：      ");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(ren[end].num==hao)	                          break;       }
	if(end>=MAX)		               {    puts("\n不存在此电话号码， 请检查您的输入！\n");   goto loop3;   }  
	ren[end].num=-1;	
	while(end<=MAX-1)                {    ren[end]=ren[end+1];                            end++;        }
	system("cls");
	printf("\n\n                                   删除成功！ \n\n  \n\n");
	getchar();
	return;
}

int main(void){
int i, choice;
for(i=1; i<=MAX; i++)	   	ren[i].num=-1;     
duqu();  
do{
	puts("                   …………………………………………………                       ");
	puts("                              .简易通讯录系统.                 ");
	puts("                   …………………………………………………                       ");
	puts("                     .        1 ——添加信息           .       ");
	puts("                     .        2 ——修改信息           .        ");
	puts("                     .        3 ——删除信息           .       ");
	puts("                     .        4 ——显示数据           .       ");
	puts("                     .        0 ——退出系统           .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		add();	                                                                                 break;
	case 2 :		change();                                                                              	break;
	case 3 :		del();	                                                                        	      break;
	case 4 :		show();	                                                                                 break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
xieru(); 
}while(choice!=0);			       		 system("cls");		   
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}