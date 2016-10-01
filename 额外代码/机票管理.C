#include<stdio.h>
#include<stdlib.h>
#define MAX 10000
#define DA  10005
struct jiegou1    {      int num, date, week, size, money, nowhas;  char arr[15];     };
struct jiegou2    {      int num, planenum, shounum;                                  };
struct jiegou3    {      int num, password;                                           };
struct jiegou1    plane[DA];
struct jiegou2    piao[DA];
struct jiegou3    ren[DA];

//********************************************** 文件读取模块 *********************************************************
void duqu(){
int end;   FILE *fp=NULL; 
fp=fopen("D:\\plane.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到plane.dat！                           \n");   return;  }  
for(end=1; end<=MAX; end++)            plane[end].num=-1; 	              end=1;
while(fscanf(fp,"%d %d %d %d %d %d %s", &plane[end].num, &plane[end].date, &plane[end].week, &plane[end].size, &plane[end].money, &plane[end].nowhas, plane[end].arr)!=EOF)	    	end++;
fclose(fp);
//*    *    *    *    *    *      *      *     *     *     *     *    *      *     *      *    *     *    *      *
fp=NULL;
fp=fopen("D:\\piao.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到piao.dat！                           \n");   return;  }  
for(end=1; end<=MAX; end++)            piao[end].num=-1; 	               end=1;
while(fscanf(fp,"%d %d, %d", &piao[end].num, &piao[end].planenum, &piao[end].shounum)!=EOF)	       end++;
fclose(fp);
//*    *    *    *    *    *      *      *     *     *     *     *    *      *     *      *    *     *    *      *
fp=NULL;
fp=fopen("D:\\ren.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到ren.dat！                           \n");    return;  }  
for(end=1; end<=MAX; end++)            ren[end].num=-1; 	                  end=1;
while(fscanf(fp,"%d %d", &ren[end].num, &ren[end].password)!=EOF)  	    	end++;
fclose(fp);
}

//********************************************** 文件写入模块 *********************************************************
void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\plane.dat","w+");
if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
for(i=1; i<=MAX; i++)  if(plane[i+1].num==-1)   break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%d %d %d %d %d %d %s\n", plane[i].num, plane[i].date, plane[i].week, plane[i].size, plane[i].money, plane[i].nowhas, plane[i].arr);   
fclose(fp);
//*    *    *    *    *    *      *      *     *     *     *     *    *      *     *      *    *     *    *      *
fp=NULL;
fp=fopen("D:\\piao.dat","w+");
if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
for(i=1; i<=MAX; i++)  if(piao[i+1].num==-1)    break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%d %d %d\n", piao[i].num, piao[i].planenum, piao[i].shounum);   
fclose(fp);
//*    *    *    *    *    *      *      *     *     *     *     *    *      *     *      *    *     *    *      *
fp=NULL;
fp=fopen("D:\\ren.dat","w+");
if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
for(i=1; i<=MAX; i++)  if(ren[i+1].num==-1)     break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%d %d\n", ren[i].num, ren[i].password);   
fclose(fp);
}

//**********************************************   价格快排模块  ***********************************************************
void kuaipai(struct jiegou1 s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&s[0].money<s[j].money)     j--;	
        if(i<j)                   {   s[i] = s[j];	 i++;	}
        while(i<j&&s[i].money<=s[0].money)    i++;	
        if(i<j)                   {  s[j]=s[i]; j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   kuaipai(s, start, j-1);	
    if(i<end)                     kuaipai(s, j + 1, end);
}

//************************************************* 显示所有航班 ***********************************************************
void showplane(){
	int end;
	system("cls");		printf("\n\n");
	for(end=1; end<=MAX; end++){
		if(plane[end].num==-1)		  {    puts("\n\n                                   显示完毕！");     break;   }
		printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[end].num, plane[end].arr, plane[end].date, plane[end].week, plane[end].size, plane[end].money, plane[end].nowhas);
	}
	puts("     **********************************************************************     ");
	getchar();        getchar();
}

//************************************************  航班查询  **********************************************************
void search(){
	int choice, i, hao, end, flag=0;         char st[20];       
	puts("\n请选择查询类型:     1.按日期查询\n                    2.按星期查询\n                    3.按价格排序查询\n                    4.按航班号查询\n                    5.按目的地查询");
	loop:  scanf("%d", &choice);                                getchar();
	if(choice<1||choice>5)                   goto loop;
	printf("请输入你的查询条件:          ");
	if(choice==1||choice==2||choice==4)      scanf("%d", &hao);
	if(choice==5)                            scanf("%s",st);
	printf("\n\n  ***************************************************************************\n\n");   
	
	if(choice!=3)
	for(i=1; i<=MAX; i++){
		if(choice==1&&plane[i].date==hao)           {  printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[i].num, plane[i].arr, plane[i].date, plane[i].week, plane[i].size, plane[i].money, plane[i].nowhas);    flag=1;   }
		if(choice==2&&plane[i].week==hao)           {  printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[i].num, plane[i].arr, plane[i].date, plane[i].week, plane[i].size, plane[i].money, plane[i].nowhas);    flag=1;   }
		if(choice==4&&plane[i].num==hao)            {  printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[i].num, plane[i].arr, plane[i].date, plane[i].week, plane[i].size, plane[i].money, plane[i].nowhas);    flag=1;   }
		if(choice==5&&strcmp(plane[i].arr, st)==0)  {  printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[i].num, plane[i].arr, plane[i].date, plane[i].week, plane[i].size, plane[i].money, plane[i].nowhas);    flag=1;   } 
	}
	if(choice!=3&&flag==0)                            puts("\n\n                          没有找到符合条件的航班！\n");
 
	for(i=1; i<=MAX; i++)                             if(plane[i+1].num==-1)    break;               end=i;
	if(choice==3)                                 {   kuaipai(plane, 1, end);   showplane();     }
	getchar();getchar();
}

//************************************************  管理员航班  ********************************************************
void hangban(){
	int choice, end, hao;       
	puts("\n请选择操作类型:       1. 浏览所有航班信息    2. 添加航班信息  3.删除航班信息");
	loop:  scanf("%d", &choice);              if(choice<1||choice>3)        goto loop;
	if(choice==1)              showplane();
	
	if(choice==2){
		for(end=1; end<=MAX; end++)            if(plane[end].num==-1)                break;
		printf("请输入新航班的编号:    ");       scanf("%d", &plane[end].num);
		printf("请输入新航班的日期:    ");       scanf("%d", &plane[end].date);
		printf("请输入新航班的星期:    ");       scanf("%d", &plane[end].week);
		printf("请输入新航班的核载:    ");       scanf("%d", &plane[end].size);
		printf("请输入新航班的价格:    ");       scanf("%d", &plane[end].money);
		printf("请输入新航班的余票量:  ");       scanf("%d", &plane[end].nowhas);
		printf("请输入新航班的目的地:   ");      scanf("%s",  plane[end].arr);
		puts("\n\n               添加成功！\n");
		goto loop2;
	}

	if(choice==3){
	printf("请输入您要删除的航班编号:   ");     scanf("%d", &hao);
	for(end=1; end<=MAX; end++)              if(plane[end].num==hao)                 break;
	if(end>=MAX)                         {   puts("\n\n数据库中没有此航班的信息！\n");  goto loop2;  }
	while(end<MAX)                       {   plane[end]=plane[end+1];                 end++;      }
	puts("\n\n                    删除成功！\n");
	}

loop2: getchar();    getchar();
}

//************************************************  系统帮助  **********************************************************
void help(){
printf("    ***********************************************************************\n");
printf("                                 系统帮助                                 \n");
printf("                                                                          \n");
printf("      管理员：                                                              \n");
printf("      		管理员可以登录管理员菜单, 增加航班信息，删除航班信息，                \n");
printf("      		修改航班信息，查询航班信息                                        \n");
printf("      售票点：                                                               \n");
printf("          	航班信息浏览，按日期、星期查询，通过目的地查询，通过航                 \n");
printf("          	班号查询，按航班价格排序查询等，查看并统计本售票点订单。               \n");
printf("       顾客：                                                              \n");
printf("           	查询航班信息和订票情况。                                           \n");
printf("                                                                         \n");
printf("                                                                            \n");
printf("                                                                          \n");
printf("                                                        By 左手程式 右手诗   \n");
printf("    ***********************************************************************\n");
getchar();	getchar();		system("cls");
}

//**********************************************  增删售票点  *******************************************************
void editshoupiao(){
	int choice, hao, i, end;
	puts("\n请选择操作类型:     1. 新增售票点             2.删除售票点");  			scanf("%d", &choice);
	if(choice==1)          {   printf("请输入你要新增的售票点编号:    ");         scanf("%d", &hao);       }
	if(choice==2)          {   printf("请输入你要删除的售票点编号:    ");         scanf("%d", &hao);       }
 
	for(i=1; i<=MAX; i++)      if(ren[i].num==hao)      break;
	if(choice==1&&ren[i].num==hao)                   {  puts("添加失败， 已有此售票点账户！！");   goto loop;                             }
	for(i=1; i<=MAX; i++)      if(ren[i].num==-1)       break;
	if(choice==1)                                    {  printf("请输入它的密码:   ");            scanf("%d", &ren[i].password);  end=i;  }
	if(choice==1)                                    {   ren[end].num=hao;                      puts("\n\n               添加成功！");   }
	for(end=1; end<=MAX; end++)  if(ren[end].num==hao)              break;
	if(choice==2&&end>=MAX)                          {  puts("\n\n删除失败， 没有此售票点账户！！");   goto loop;                              }
	if(choice==2)                                    {  for(end=end; end<MAX; end++)  ren[end]=ren[end+1];      puts("\n删除完成！\n");  }
	loop: getchar();  getchar();
}

//*********************************************  没有票务权限  *********************************************************
void wuquan(){
printf("    ***********************************************************************\n");
printf("                                 系统提示                                  \n");
printf("                                                                           \n");
printf("      您目前是以顾客身份登录， 无法使用此功能， 如果您需要查看航班和相应         \n");
printf("      的售票情况，请选择 “航班查询” 功能 。		                               \n");
printf("      		                                                               \n");
printf("                                                                         \n");
printf("          	                                                            \n");
printf("      如果您是 管理员 或 售票点 用户请登录相应的操作菜单即可获取相应    	      \n");
printf("      的票务操作权限。                                                      \n");
printf("           	                                                             \n");
printf("                                                                         \n");
printf("                                                                           \n");
printf("                                                                          \n");
printf("                                                        By 左手程式 右手诗   \n");
printf("    ***********************************************************************\n");
getchar();	getchar();		system("cls");
}

//************************************************* 票务模块 **********************************************************
void piaowu(int shounum){
	int choice, i, end, hao, tem;
	puts("\n请选择操作类型:     1. 售票       2.退票");  			                scanf("%d", &choice);
	if(choice==1)          {   printf("请输入你要出售的航班编号:    ");        scanf("%d", &hao);      }
	if(choice==2)          {   printf("请输入你要退票的机票编号:    ");        scanf("%d", &hao);      }

	for(i=1; i<=MAX; i++)      if(plane[i].num==hao&&choice==1)              break;
	for(end=1;end<=MAX;end++)  if(piao[end].num==hao&&choice==2)             break;
	if(choice==1&&i>=MAX)  {   puts("\n\n查找失败, 没有此航班号！！！\n");      goto loop;             }
	if(choice==2&&end>=MAX){   puts("\n\n查找失败, 没有此机票号！！！\n");      goto loop;             }	

	if(choice==1){
		tem=i;
		for(i=1; i<=MAX; i++)     if(piao[i].num==-1)                           break;
		plane[tem].nowhas--;
		piao[i].planenum=hao;     piao[i].num=plane[tem].num*10+plane[tem].nowhas;    piao[i].shounum=shounum;  
		printf("\n\n                售票成功, 机票号码： %d, 价格: %d\n", piao[i].num, plane[tem].money);
	}
	
	if(choice==2){
		piao[end].num=-1;
		for(i=1; i<=MAX; i++)     if(plane[i].num==piao[end].planenum)           break;
		plane[i].nowhas++;
		printf("\n\n                退票成功, 机票原价： %d\n", plane[i].money);
	}
	
	loop: getchar();   getchar();
}

//************************************************* 票务查询 *********************************************************
void chapiaowu(){
	int i, hao, end;
	printf("请输入要查询的机票编号:          ");							scanf("%d", &hao);
	for(i=1; i<=MAX; i++)           if(piao[i].num==hao)        break;
	if(i>=MAX)                   {  puts("\n\n查找失败, 没有此机票号！！！\n");    goto loop;  }
	printf("\n\n机票号码：  %d     机票航班号： %d     售票点编号： %d\n\n", piao[i].num, piao[i].planenum, piao[i].shounum);
	for(end=1;end<=MAX;end++)       if(plane[end].num==piao[i].planenum)           break;
	printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[end].num, plane[end].arr, plane[end].date, plane[end].week, plane[end].size, plane[end].money, plane[end].nowhas);
	loop:  getchar();   getchar();
	
}

//******************************************** 1.管理人员菜单 *********************************************************
int adminwin(){
int choice, password;    
printf("\n\n请输入管理人员登录密码:     ");     scanf("%d", &password);     if(password!=514200)    {   puts("\n\n密码错误！！\n"); getchar(); return 1; } 
system("cls");
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                  【管理员用户】  .请输入选项编号(0~5).           ");
	puts("                   …………………………………………………                       ");
	puts("                     .       1 ——航班信息           .       ");
	puts("                     .       2 ——售票点增加删除      .        ");
	puts("                     .       3 ——航班查询           .       ");
	puts("                     .       4 ——票务信息           .       ");
	puts("                     .       5 ——系统帮助           .       "); 
	puts("                     .       0 ——退出系统           .       ");
	puts("                   …………………………………………………");   

scanf("%d", &choice);
switch(choice){
	case 1 :		    hangban();	        system("cls");                                                        break;
	case 2 :		    editshoupiao();    system("cls");                                                       	break;
	case 3 :		    search();	        system("cls");                                                        break;
	case 4 :		    chapiaowu();	     system("cls");                                                        break;
	case 5 :		    system("cls");     help();                                                               break;
	case 0 :		                                                                                             break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		   break;
} 
xieru();
}while(choice!=0);		   
return choice;
}

//**********************************************  票务统计 *********************************************************
void tongpiao(int zhanghao){
	int end, hao, j;
	for(end=1; end<=MAX; end++)      
	if(piao[end].num>0&&piao[end].shounum==zhanghao){
		printf("\n\n机票号码：  %d     机票航班号： %d     售票点编号： %d\n", piao[end].num, piao[end].planenum, piao[end].shounum);
		hao=piao[end].planenum;
		for(j=1; j<=MAX; j++)   if(plane[j].num==hao)
		printf("航班号:%6d 目的地:%6s 日期: %8d 星期: %d  核载: %3d 价格:%4d 余票:%3d\n", plane[j].num, plane[j].arr, plane[j].date, plane[j].week, plane[j].size, plane[j].money, plane[j].nowhas);
	}
	getchar();     getchar();
}

//********************************************  2.售票点菜单 *********************************************************
int shoupiaowin(){
int i, choice, password, zhanghao, flag=0;    
printf("\n\n请输入售票点登录账号:     ");     scanf("%d", &zhanghao);
printf("\n请输入售票点登录密码:     ");       scanf("%d", &password);
for(i=1; i<=MAX; i++)                       if(ren[i].num==zhanghao&&ren[i].password==password)   {  flag=1;  break;  }
if(flag==0)                             {   puts("\n\n账号或密码错误！！\n");                   getchar();             return 1;  } 
system("cls");
do{
	duqu();
	puts("                   …………………………………………………                       ");
  printf("                     【售票点%d】 .请输入选项编号(0~4).      \n",i);
	puts("                   …………………………………………………                       ");
	puts("                     .       1 ——航班信息           .       ");
	puts("                     .       2 ——航班查询           .       ");
	puts("                     .       3 ——票务信息           .       ");
	puts("                     .       4 ——系统帮助           .       "); 
	puts("                     .       5 ——统计票务           .       "); 
	puts("                     .       0 ——退出系统           .       ");
	puts("                   …………………………………………………");   

scanf("%d", &choice);
switch(choice){
	case 1 :		    showplane();	         system("cls");                                                    break;
	case 2 :		    search();              system("cls");                                                    break;
	case 3 :		    piaowu(zhanghao);      system("cls");                                                    break;
	case 4 :		    help();	               system("cls");                                                    break;
	case 5 :		    tongpiao(zhanghao);	   system("cls");                                                    break;
	case 0 :		                                                                                             break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		   break;
} 
xieru();
}while(choice!=0);		   
return choice;
}

//*************************************************** 登录分支 ********************************************************
int fenzhi(){
	int choice;       
	puts("\n请选择登录类型:       1. 管理员登录    2. 售票点用户");
	loop:  scanf("%d", &choice);
	if(choice!=1&&choice!=2)      goto loop;
	if(choice==1)                 choice=adminwin();
		else                       choice=shoupiaowin();
	return choice;
}

//*************************************************** 主菜单 *********************************************************
int main(void){
int i, choice;
for(i=1; i<=MAX; i++)	  { 	plane[i].num=-1;      piao[i].num=-1;  ren[i].num=-1;    }
do{
	duqu();
	puts("                   …………………………………………………                       ");
	puts("                   【当前用户】  .请输入选项编号(0~4).           ");
	puts("                   …………………………………………………                       ");
	puts("                     .       1 ——用户登录           .       ");
	puts("                     .       2 ——航班查询           .        ");
	puts("                     .       3 ——票务信息           .       ");
	puts("                     .       4 ——系统帮助           .       ");   
	puts("                     .       0 ——退出系统           .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");       choice=fenzhi();	                                                   break;
	case 2 :		system("cls");       search();              system("cls");                              	break;
	case 3 :		system("cls");       wuquan();              system("cls");             	                  break;
	case 4 :		system("cls");       help();                                                              break;
	case 0 :		                                                                                          break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		break;
}
xieru(); 
}while(choice!=0);			       		 system("cls");		   
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}