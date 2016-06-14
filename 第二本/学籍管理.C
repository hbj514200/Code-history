#include<stdio.h>
#include<stdlib.h>
#define MAX 1000
#define DA  1005
struct jiegou1    {      long long num, math, en, wuli, java, maze, avg;   char name[15];  };
struct jiegou1    ren[DA], temren[DA];

void duqu(){
int end;   FILE *fp=NULL; 
fp=fopen("D:\\ren.dat","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到ren.dat！                           \n");   return;  }  
for(end=1; end<=MAX; end++)            ren[end].num=-1; 	              end=1;
while(fscanf(fp,"%lld %lld %lld %lld %lld %lld %lld %s", &ren[end].num, &ren[end].math, &ren[end].en, &ren[end].wuli, &ren[end].java, &ren[end].maze, &ren[end].avg, ren[end].name)!=EOF) end++;
fclose(fp);
}     //临时

//********************************************** 补考模块 *********************************************************
void bukao(){
	int i, date[10], flag;    char add[7][30];
	printf("请输入数学补考时间: ");    scanf("%d", &date[1]);		printf("请输入数学补考地点: ");  scanf("%s", add[1]);
	printf("请输入英语补考时间: ");    scanf("%d", &date[2]);		printf("请输入英语补考地点: ");  scanf("%s", add[2]);
	printf("请输入物理补考时间: ");    scanf("%d", &date[3]);		printf("请输入物理补考地点: ");  scanf("%s", add[3]);
	printf("请输入编程补考时间: ");    scanf("%d", &date[4]);		printf("请输入编程补考地点: ");  scanf("%s", add[4]);
	printf("请输入马哲补考时间: ");    scanf("%d", &date[5]);		printf("请输入马哲补考地点: ");  scanf("%s", add[5]);
	
	for(i=1; i<=MAX; i++){
		flag=0;
		if(ren[i].num < 0)        break;
		if(ren[i].math<60)       flag++;
		if(ren[i].en  <60)       flag++;
		if(ren[i].wuli<60)       flag++;
		if(ren[i].java<60)       flag++;
		if(ren[i].maze<60)       flag++;
		if(flag<4&&flag>0){
			puts("\n                                  补考通知单                                ");
			puts("   ************************************************************************  ");
			printf("    %s 同学:    %17lld                     \n", ren[i].name, ren[i].num     );
			printf("          鉴于你在本学期考试中有不及格的考试， 请做好补考的准备。             \n");
			if(ren[i].math<60)       printf("   数学: %lld分  补考时间: %8d 补考地点: %s\n",   ren[i].math, date[1], add[1]);
			if(ren[i].en  <60)       printf("   英语: %lld分  补考时间: %8d 补考地点: %s\n  ", ren[i].en,   date[2], add[2]);
			if(ren[i].wuli<60)       printf("   物理: %lld分  补考时间: %8d 补考地点: %s\n  ", ren[i].wuli, date[3], add[3]);
			if(ren[i].java<60)       printf("   编程: %lld分  补考时间: %8d 补考地点: %s\n  ", ren[i].java, date[4], add[4]);
			if(ren[i].maze<60)       printf("   马哲: %lld分  补考时间: %8d 补考地点: %s\n  ", ren[i].maze, date[5], add[5]);
			printf("\n          这是一个艰难的决定，\n");
			printf("          你的任课老师天打五雷轰, 草他妈比, 害你要补考! !\n");
			puts("   ************************************************************************  ");
		}
	}
	puts("\n\n                                  打印完毕！！");
	getchar();    getchar();
}

//********************************************** 退学模块 *********************************************************
void tuixue(){
	int i, j=1, flag, end;
	system("cls");
	for(i=1; i<=MAX; i++){
		flag=0;
		if(ren[i].num < 0)        break;
		if(ren[i].math<60)       flag++;
		if(ren[i].en  <60)       flag++;
		if(ren[i].wuli<60)       flag++;
		if(ren[i].java<60)       flag++;
		if(ren[i].maze<60)       flag++;
		if(flag>3){
			puts("\n                                  退学通知单                                ");
			puts("   ************************************************************************  ");
			printf("    %s 同学:    %17lld                     \n", ren[i].name, ren[i].num);
			printf("          鉴于你在本学期考试中不及格考试超过三门， 现决定对你予以退学处理。\n");      
			if(ren[i].math<60)       printf("   数学: %lld分  ", ren[i].math);
			if(ren[i].en  <60)       printf("   英语: %lld分  ", ren[i].en);
			if(ren[i].wuli<60)       printf("   物理: %lld分  ", ren[i].wuli);
			if(ren[i].java<60)       printf("   编程: %lld分  ", ren[i].java);
			if(ren[i].maze<60)       printf("   马哲: %lld分  ", ren[i].maze);
			printf("\n          这是一个艰难的决定，\n");
			printf("          学校教务处的老师天打五雷轰, 从此生个孩子没屁眼, 永世不得超生!!!\n");
			puts("   ************************************************************************  ");
		}
	}
	puts("\n\n                                  打印完毕！！");
	getchar();     getchar();
}
//******************************************** 统计图表模块 *********************************************************
void tongji(){
int z[7][7]={0}, i;
system("cls");

for(i=1; i<=MAX; i++){
	if(ren[i].num<0)       break;
	if(ren[i].math>=90)                    z[1][1]++;			if(ren[i].en>=90)                  z[2][1]++;
	if(ren[i].math>=80&&ren[i].math<=89)   z[1][2]++;			if(ren[i].en>=80&&ren[i].en<=89)   z[2][2]++;
	if(ren[i].math>=70&&ren[i].math<=79)   z[1][3]++;			if(ren[i].en>=70&&ren[i].en<=79)   z[2][3]++;
	if(ren[i].math>=60&&ren[i].math<=69)   z[1][4]++;			if(ren[i].en>=60&&ren[i].en<=69)   z[2][4]++;
	if(ren[i].math<60)                     z[1][5]++;			if(ren[i].en<60)                   z[2][5]++;

	if(ren[i].wuli>=90)                    z[3][1]++;			if(ren[i].java>=90)                    z[4][1]++;
	if(ren[i].wuli>=80&&ren[i].wuli<=89)   z[3][2]++;			if(ren[i].java>=80&&ren[i].java<=89)   z[4][2]++;
	if(ren[i].wuli>=70&&ren[i].wuli<=79)   z[3][3]++;			if(ren[i].java>=70&&ren[i].java<=79)   z[4][3]++;
	if(ren[i].wuli>=60&&ren[i].wuli<=69)   z[3][4]++;			if(ren[i].java>=60&&ren[i].java<=69)   z[4][4]++;
	if(ren[i].wuli<60)                     z[3][5]++;			if(ren[i].java<60)                     z[4][5]++;

	if(ren[i].maze>=90)                    z[5][1]++;
	if(ren[i].maze>=80&&ren[i].maze<=89)   z[5][2]++;
	if(ren[i].maze>=70&&ren[i].maze<=79)   z[5][3]++;
	if(ren[i].maze>=60&&ren[i].maze<=69)   z[5][4]++;
	if(ren[i].maze<60)                     z[5][5]++;
}

printf("\n                           各门课、各分数段学生的人数\n");
printf("      ……………………………………………………………………………………\n");
printf("   .      90以上.     80~89分.    70~79分.    60~69分.    60分以下.        \n\n"                                         );
printf("高数.      %d      .     %d      .     %d     .     %d     .     %d     .\n\n", z[1][1],z[1][2],z[1][3],z[1][4],z[1][5] );
printf("英语.      %d      .     %d      .     %d     .     %d     .     %d     .\n\n", z[2][1],z[2][2],z[2][3],z[2][4],z[2][5] );
printf("物理.      %d      .     %d      .     %d     .     %d     .     %d     .\n\n", z[3][1],z[3][2],z[3][3],z[3][4],z[3][5] );
printf("编程.      %d      .     %d      .     %d     .     %d     .     %d     .\n\n", z[4][1],z[4][2],z[4][3],z[4][4],z[4][5] );
printf("马哲.      %d      .     %d      .     %d     .     %d     .     %d     .\n\n", z[5][1],z[5][2],z[5][3],z[5][4],z[5][5] );
printf("      ……………………………………………………………………………………");

getchar();    getchar();
}

//**********************************************  升学模块 *********************************************************
void shenxue(){
	int i, j=1, flag, end;
	FILE *fp=NULL;
	for(i=1; i<=MAX; i++)       temren[i].num=-1;
	for(i=1; i<=MAX; i++){
		flag=0;
		if(ren[i].num < 0)        break;
		if(ren[i].math<60)       flag++;
		if(ren[i].en  <60)       flag++;
		if(ren[i].wuli<60)       flag++;
		if(ren[i].java<60)       flag++;
		if(ren[i].maze<60)       flag++;
		if(flag<=3)              temren[j++]=ren[i]; 
	}

	fp=fopen("D:\\next.dat","w+");
	if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
	for(i=1; i<=MAX; i++)  if(temren[i+1].num==-1)   break;          end=i;
	for(i=1; i<=end; i++)		
	fprintf(fp,"%lld %lld %lld %lld %lld %lld %lld %s\n", temren[i].num, temren[i].math, temren[i].en, temren[i].wuli, temren[i].java, temren[i].maze, temren[i].avg, temren[i].name);   
	fclose(fp);

	puts("\n\n                    升学名单生成完毕！  请查看next.dat文件！\n");
	getchar();         getchar();
}

//**********************************************  录入成绩 *********************************************************
void input(){
	int i, end;                                                      loop: 
	for(i=1; i<=MAX; i++)     if(ren[i].num==-1)    break;
	puts("                                      录入成绩");
	puts("      ********************************************************************\n");
   printf("请输入学号:         ");         scanf("%lld", &ren[i].num);       if(ren[i].num==-1)     return;
   printf("请输入姓名:         ");         scanf("%s", &ren[i].name);
   printf("请输入数学成绩:     ");          scanf("%lld", &ren[i].math);
   printf("请输入英语成绩:     ");          scanf("%lld", &ren[i].en);
   printf("请输入物理成绩:     ");          scanf("%lld", &ren[i].wuli);
   printf("请输入编程成绩:     ");          scanf("%lld", &ren[i].java);
   printf("请输入马哲成绩:     ");          scanf("%lld", &ren[i].maze);         end=i;
	ren[i].avg=(ren[i].math+ren[i].en+ren[i].wuli+ren[i].java+ren[i].maze)/5;
	
	for(i=1; i<end; i++)         if(ren[i].num==ren[end].num)    {    puts("\n     学号重复,  本次输入无效！");   ren[end].num=-1;    }
	goto loop;                   getchar();    getchar();
}

//************************************************  关于作者  *******************************************************
void me(){ 
system("cls");
printf("               ************************************************\n");
printf("               *                   关于作者                   * \n");
printf("               *                                              * \n");
printf("               *          很多时候， 成长并不是一个过程       *    \n");
printf("               *                                              *  \n");
printf("               *  而是在一个刹那…………                      *     \n");
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

//*******************************************  按平均分排序模块 *********************************************************
void kuaipaiavg(struct jiegou1 s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&s[0].avg<s[j].avg)     j--;	
        if(i<j)                   {   s[i] = s[j];	 i++;	}
        while(i<j&&s[i].avg<=s[0].avg)    i++;	
        if(i<j)                   {  s[j]=s[i]; j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   kuaipaiavg(s, start, j-1);
    if(i<end)                     kuaipaiavg(s, j + 1, end);
}

void avgpai(){
	int i, end;     FILE *fp=NULL;
	fp=fopen("D:\\sort.dat","w+");
	if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
	for(i=1; i<=MAX; i++)  if(ren[i+1].num==-1)     break;        end=i;
	for(i=1; i<=end; i++)  temren[i]=ren[i];        kuaipaiavg(temren, 1, end);
	for(i=end; i>=1; i--)		
	fprintf(fp,"%17lld %3lld %3lld %3lld %3lld %3lld %3lld %s\n", temren[i].num, temren[i].math, temren[i].en, temren[i].wuli, temren[i].java, temren[i].maze, temren[i].avg, temren[i].name);   
	fclose(fp);
	puts("\n\n                    按学号排序完毕！  请查看sort.dat文件！\n");
	getchar();     getchar();
}

//*******************************************  按学号排序模块 *********************************************************
void kuaipaixue(struct jiegou1 s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&s[0].num<s[j].num)     j--;	
        if(i<j)                   {   s[i] = s[j];	 i++;	}
        while(i<j&&s[i].num<=s[0].num)    i++;	
        if(i<j)                   {  s[j]=s[i]; j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   kuaipaixue(s, start, j-1);
    if(i<end)                     kuaipaixue(s, j + 1, end);
}

void xuehaopai(){
	int i, end;     FILE *fp=NULL;
	fp=fopen("D:\\std.dat","w+");
	if(fp==NULL)   {  puts("\n                      写入失败, 请检查程序访问磁盘权限！                          \n");   return;  }  
	for(i=1; i<=MAX; i++)  if(ren[i+1].num==-1)     break;        end=i;
	for(i=1; i<=end; i++)  temren[i]=ren[i];        kuaipaixue(temren, 1, end);
	for(i=1; i<=end; i++)		
	fprintf(fp,"%lld %lld %lld %lld %lld %lld %lld %s\n", temren[i].num, temren[i].math, temren[i].en, temren[i].wuli, temren[i].java, temren[i].maze, temren[i].avg, temren[i].name);   
	fclose(fp);
	puts("\n\n                    按学号排序完毕！  请查看std.dat文件！\n");
	getchar();     getchar();
}

//*******************************************  3.处理学籍菜单 *********************************************************
int chuwin(){
int i, choice, flag=0;
system("cls");
do{
	puts("                   …………………………………………………                     \n");
   puts("                              请输入选项编号(0~4).          ");
	puts("                   …………………………………………………                     ");
	puts("                     .   1 ——生成并打印补考通知单   .       ");
	puts("                     .   2 ——生成并打印退学通知单   .       ");
	puts("                     .   3 ——生成并打印新名册       .       ");
	puts("                     .   4 ——返回                   .       "); 
	puts("                     .   0 ——退出系统               .       ");
	puts("                   …………………………………………………");   

scanf("%d", &choice);
switch(choice){
	case 1 :		    bukao();	            system("cls");                                                    break;
	case 2 :		    tuixue();              system("cls");                                                    break;
	case 3 :		    shenxue();             system("cls");                                                    break;
	case 4 :		    return 1;	                                                                              break;
	case 0 :		                                                                                             break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		   break;
} 
}while(choice!=0);		   
return choice;
}

//*******************************************  2.统计成绩菜单 *********************************************************
int tongwin(){
int i, choice, flag=0;
system("cls");
do{
	puts("                   …………………………………………………                       ");
   puts("                              请输入选项编号(0~4).          ");
	puts("                   …………………………………………………                       ");
	puts("                     .      1 ——按学号排序           .       ");
	puts("                     .      2 ——计算平均分并排序     .       ");
	puts("                     .      3 ——统计分数段           .       ");
	puts("                     .      4 ——返回                 .       "); 
	puts("                     .      0 ——退出系统             .       ");
	puts("                   …………………………………………………");   

scanf("%d", &choice);
switch(choice){
	case 1 :		    xuehaopai();	         system("cls");                                                    break;
	case 2 :		    avgpai();              system("cls");                                                    break;
	case 3 :		    tongji();              system("cls");                                                    break;
	case 4 :		    return 1;                                                                                break;
	case 0 :		                                                                                             break;
	default:		system("cls");   puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");		   break;
} 
}while(choice!=0);		   
return choice;
}

/*
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
*/

//*************************************************** 主菜单 *********************************************************
int main(void){
int i, choice;
for(i=1; i<=MAX; i++)	   	ren[i].num=-1;        duqu();//临时
do{
	puts("                   …………………………………………………                       ");
	puts("                              请输入选项编号(0~4).             ");
	puts("                   …………………………………………………                       ");
	puts("                     .       1 ——录入成绩           .       ");
	puts("                     .       2 ——统计成绩           .        ");
	puts("                     .       3 ——处理学籍           .       ");
	puts("                     .       4 ——关于作者           .       ");   
	puts("                     .       0 ——退出系统           .       ");
	puts("                   …………………………………………………");  

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");         input();	             system("cls");                              break;
	case 2 :		system("cls");         choice=tongwin();      system("cls");                              break;
	case 3 :		system("cls");         choice=chuwin();       system("cls");             	               break;
	case 4 :		system("cls");         me();                  system("cls");                              break;
	case 0 :		                                                                                          break;
	default:		system("cls");      puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");	break;
} 
}while(choice!=0);			       		 system("cls");		   
puts("\n\n\n\n\n\n\n\n                  感谢使用本软件。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}