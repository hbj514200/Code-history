#include<stdio.h>
#include<string.h>
#include<stdlib.h>
struct jiegou  {   long long num, sex, old, money, mobi;  char name[15], address[50], xueli[10];  struct jiegou *next; };
struct jiegou *head=NULL, *p=NULL, *tem;
int size;

//************************************************ 文件读写模块 *********************************************************
void duqu(){
FILE *fp=NULL;  
fp=fopen("D:\\Ren.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到Ren.dat！                           \n");   return;  }  
p=head;                              tem=(struct jiegou *)malloc(size);
while(fscanf(fp,"%lld %lld %lld %lld %lld %s %s %s", &tem->num, &tem->sex, &tem->old, &tem->money, &tem->mobi, tem->name, tem->address, tem->xueli)!=EOF){
	p->next=tem;
	p=tem;
	tem=(struct jiegou *)malloc(size);  
} 
p->next=NULL;
fclose(fp);
}

void xieru(){ 
FILE *fp=NULL;
fp=fopen("D:\\Ren.dat","w+");
if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
p=head;
while(1){
	if(p->num==-1&&p->next==NULL)       break;    
	if(p->num==-1)    {   p=p->next;    continue;    }
	fprintf(fp,"%lld %lld %lld %lld %lld %s %s %s\n", p->num, p->sex, p->old, p->money, p->mobi, p->name, p->address, p->xueli);  
	if(p->next==NULL)     break;
	p=p->next;
}
fclose(fp);
}

//************************************************ 添加员工信息 *********************************************************
void add(){
	tem=(struct jiegou *)malloc(size);     p=head;
	printf("请输入新添加的工号:     ");	   scanf("%lld", &tem->num);
	while(p->next!=NULL)                {  if(p->num==tem->num)    {  puts("\n添加失败！   数据库中已有此工号!\n");   goto loop; } p=p->next; }
 	printf("请输入性别:(0.女 1.男)  ");	   scanf("%lld", &tem->sex);
	printf("请输入年龄:             ");	   scanf("%lld", &tem->old);
   printf("请输入工资:             ");		scanf("%lld", &tem->money);
   printf("请输入电话:             ");		scanf("%lld", &tem->mobi);
   printf("请输入姓名:             ");		scanf("%s", tem->name);
   printf("请输入地址:             ");	   scanf("%s", tem->address);
	printf("请输入学历:             ");	   scanf("%s", tem->xueli);
	while(p->next!=NULL)                   p=p->next;
	p->next=tem;                           tem->next=NULL;
	puts("\n\n                                   添加完成！\n\n");
	loop: getchar();    getchar();
}

//************************************************ 修改员工信息 *********************************************************
void change(){ 
	long long hao;            p=head;
	printf("请输入要修改的工号:     ");	   scanf("%lld", &hao);
	while(1)                            {  if(p->num==hao)   break;             if(p->next==NULL) break;   p=p->next; }
	if(p->num!=hao)                     {  puts("\n数据库中没有此员工号！\n");     goto loop;                           }
 	printf("请输入性别:(0.女 1.男)  ");	   scanf("%lld", &p->sex);
	printf("请输入年龄:             ");	   scanf("%lld", &p->old);
   printf("请输入工资:             ");		scanf("%lld", &p->money);
   printf("请输入电话:             ");		scanf("%lld", &p->mobi);
   printf("请输入姓名:             ");		scanf("%s", p->name);
   printf("请输入地址:             ");	   scanf("%s", p->address);
	printf("请输入学历:             ");	   scanf("%s", p->xueli);
	puts("\n\n                                   修改完成！\n\n");
	loop: getchar();    getchar();
}

//************************************************ 员工浏览模块 *********************************************************
void show(){
	int end;
	system("cls");		       printf("\n                                 员工信息浏览\n");
	puts("     **********************************************************************\n");
	p=head;
	while(1){
	if(p->num==-1&&p->next==NULL)      break;  
	if(p->num==-1)	               {    p=p->next;   continue;   }
	printf("号码：%12lld 姓名: %s 性别: %lld 年龄: %lld 工资: %lld 电话: %lld\n学历: %s 地址: %s\n\n", p->num, p->name, p->sex, p->old, p->money, p->mobi, p->xueli, p->address);
	if(p->next==NULL)             {    puts("\n\n                                   显示完毕！");     break;   }
	p=p->next;
	}
getchar();    getchar();
}

//************************************************  关于作者  *******************************************************
void me(){ 
system("cls");
printf("               ************************************************\n");
printf("               *                   作者&诗                   * \n");
printf("               *                                              * \n");
printf("               *           简单， 真不是一件简单的事          *    \n");
printf("               *                                              *  \n");
printf("               *  很庆幸, 我走过的路上有我喜欢的风景……      *     \n");
printf("               *                                              * \n");
printf("               *                                              *   \n");
printf("               *                                              * \n");
printf("               *     当生活让我们忘记最初的样子, 有没有一     *  \n");
printf("               *     个人藏在心里最纯净的角落, 不经意想起     * \n");
printf("               *                                              *  \n");
printf("               *     便勾勒成整个青春的模样…………           * \n");
printf("               *                                              * \n");
printf("               *                               记于  肇庆学院 *   \n");
printf("               ************************************************\n\n\n\n");
printf("        成长是一种交易, 我们都是用朴素的童真与未经人事的洁白换取长大的勇气\n\n");
getchar();	getchar();
}

//************************************************ 员工查询模块 *********************************************************
void search(){
	long long hao, choice, flag=0;    char xueli[15];
	puts("\n请选择您的查询类型:    1.按工号查询    2.按学历查询");       scanf("%lld", &choice);
	if(choice==1)    {   printf("\n请输入您要查找的员工号:        ");   scanf("%lld", &hao);       }
	if(choice==2)    {   printf("\n请输入您要查找的学历  :        ");   scanf("%s", xueli);        }
	p=head;     
	while(1){
	if(p->num==-1&&p->next==NULL)    {    puts("\n数据库中没有此员工号！\n");     break;    }
	if(p->num==-1)                   {    p=p->next;   continue;                          }
	if(strcmp(p->xueli, xueli)==0)   {    printf("\n号码：%12lld 姓名: %s 性别: %lld 年龄: %lld 工资: %lld 电话: %lld\n学历: %s 地址: %s\n\n", p->num, p->name, p->sex, p->old, p->money, p->mobi, p->xueli, p->address);   flag=1; }
	if(p->num==hao&&choice==1)       {    printf("\n号码：%12lld 姓名: %s 性别: %lld 年龄: %lld 工资: %lld 电话: %lld\n学历: %s 地址: %s\n\n", p->num, p->name, p->sex, p->old, p->money, p->mobi, p->xueli, p->address);   flag=1; }
	if(p->next==NULL)                {         break;    }
	p=p->next;
	}
	if(flag==0)                           puts("\n数据库中没有找到符合条件的结果！\n");
	getchar();     getchar();
}

//************************************************ 员工删除模块 *********************************************************
void del(){              
	long long hao;	
	printf("请输入要删除的号码：      ");
	scanf("%lld", &hao);
		p=head;    
	while(1){
	if(p->num==-1&&p->next==NULL) {    puts("\n数据库中没有此员工号！\n");                   goto loop;    }
	if(p->num==-1)                {    p=p->next;                           tem=head;      continue;     }
	if(p->num==hao)               {    tem->next=p->next;                                  break;        }
	if(p->next==NULL)             {    puts("\n数据库中没有此员工号！\n");                   goto loop;    }
	tem=tem->next;    p=p->next;
	}
	puts("\n\n                                   删除成功！\n\n");
	loop: getchar();     getchar();
}

int main(void){
int i, choice;       size=sizeof(struct jiegou);     
head=(struct jiegou *)malloc(size);          head->next=NULL;     head->num=-1;
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                             .请输入选项编号(0~6).                 ");
	puts("                   …………………………………………………                       ");
	puts("                     .       1 ——职工信息录入       .       ");
	puts("                     .       2 ——职工信息浏览       .        ");
	puts("                     .       3 ——职工信息查询       .       ");
	puts("                     .       4 ——职工信息修改       .       ");
	puts("                     .       5 ——职工信息删除       .       ");
	puts("                     .       6 ——关于作者           .       ");
	puts("                     .       0 ——退出系统           .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		add();	               system("cls");                                                    break;
	case 2 :		show();                 system("cls");                                                   	break;
	case 3 :		search();	            system("cls");                                             	      break;
	case 4 :		change();	            system("cls");                                                    break;
	case 5 :		del();                  system("cls");                                                    break;
	case 6 :		me();	                  system("cls");                                                    break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
xieru(); 
}while(choice!=0);			       		 system("cls");		   
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}