#include<stdio.h>
#include<string.h>
#include<stdlib.h>
struct student {  double english,math,chinese,zhuanye,sum,xuehao,pinjun; };
struct student z[10010];    char c[300];   



void xuehaokuaipai(struct student s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&s[0].xuehao<s[j].xuehao)     j--;	
        if(i<j)                   {   s[i] = s[j];	 i++;	}
        while(i<j&&s[i].xuehao<=s[0].xuehao)    i++;	
        if(i<j)                   {  s[j]=s[i]; j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   xuehaokuaipai(s, start, j-1);									/*学号的快排*/
    if(i<end)                     xuehaokuaipai(s, j + 1, end);
}



void sumkuaipai(struct student s[], int start, int end){
    int i=start, j=end;
    s[0]=s[start];
    while(i<j){
        while(i<j&&s[0].sum<s[j].sum)     j--;	
        if(i<j)                   {   s[i] = s[j];	 i++;	}
        while(i<j&&s[i].sum<=s[0].sum)    i++;	
        if(i<j)                   {  s[j]=s[i]; j--;   }
    }
    s[i]=s[0];	
    if(start<i)                   sumkuaipai(s, start, j-1);									/*总分的快排*/
    if(i<end)                     sumkuaipai(s, j + 1, end);
}



double zhuanhuan(char c[]){
double sum=0;   int i;
for(i=0; i<strlen(c); i++){
	if(c[i]<'0'||c[i]>'9'||strlen(c)>17)    {  printf("您的输入非法或太长！ 请重新输入合理数字!\n\n");  return -1;  }
	sum*=10; sum+=c[i]-'0';
}
return sum;
}



void add(void){
int i, flag=0;
for(i=1; i<=10005; i++){
	if(z[i].xuehao<0){
		while(1){   puts("\n请输入此学生的学号");       gets(c);   if(zhuanhuan(c)<0)  continue; else  {  z[i].xuehao=zhuanhuan(c);  break;   } }
		while(1){   puts("\n请输入此学生的英语成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].english=zhuanhuan(c);  break;  } }
		while(1){   puts("\n请输入此学生的数学成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].math=zhuanhuan(c);  break;     } }
		while(1){   puts("\n请输入此学生的语文成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].chinese=zhuanhuan(c);  break;  } }
		while(1){   puts("\n请输入此学生的专业成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].zhuanye=zhuanhuan(c);  break;  } }
		flag++;
	}
	if(flag==1)  break;
}
z[i].sum=z[i].english+z[i].math+z[i].chinese+z[i].zhuanye;
z[i].pinjun=z[i].sum/4.0;
printf("\n\n\n\n                                添加成功信息!!\n                                回车以继续\n\n\n\n");	
getchar();   system("cls");
}



void show(){
int i;
system("cls");
puts("\n                                 学生信息列表                         \n");
puts("********************************************************************************\n");
for(i=1; i<=10000; i++){
if(z[i].xuehao>0)
printf("学号：%.0f  英语:%.0f 数学:%.0f 语文:%.0f 专业：%.0f 总成绩:%.0f 平均分:%.0f\n", z[i].xuehao, z[i].english, z[i].math, z[i].chinese, z[i].zhuanye, z[i].sum, z[i].pinjun);
}
puts("\n\n\n********************************************************************************\n");
printf("                                所有信息显示完毕！\n\n回车以继续\n\n\n");
getchar();   system("cls");     
}



void del(){
double num;  int i, j, flag=0;
system("cls");
puts("\n                                 学生信息删除                         \n");
puts("********************************************************************************");
while(1){   puts("请输入需要删除的学生的学号：");       gets(c);   if(zhuanhuan(c)<0)  continue; else  {  num=zhuanhuan(c);  break;   } }
for(i=1; i<=10000; i++){
	if(z[i].xuehao==num)  {    for(j=i; j<=10000; j++) z[j]=z[j+1];  flag++;   }
	if(flag==1)   break;
}
if(flag==1)		puts("\n                                 删除成功！\n");
else           puts("\n                             数据库中没有此学生信息！\n");
puts("\n\n                                 按回车以继续……\n\n");
getchar();     system("cls");
}


void change(){
int i, flag=0;    double num;
system("cls");
puts("\n                                 学生信息修改                         \n");
puts("********************************************************************************");
while(1){   puts("请输入需要修改的学生的学号：");       gets(c);   if(zhuanhuan(c)<0)  continue; else  {  num=zhuanhuan(c);  break;   } }
for(i=1; i<=10000; i++){
	if(z[i].xuehao==num){   
		puts("\n                                 此学生原本信息                         \n");
		puts("********************************************************************************");
		printf("学号： %.0f\n英语： %.0f  数学： %.0f  语文： %.0f  专业： %.0f  总成绩： %.0f  平均分： %.0f\n\n", z[i].xuehao, z[i].english, z[i].math, z[i].chinese, z[i].zhuanye, z[i].sum, z[i].pinjun);
		puts("********************************************************************************");
		puts("                                 准备更新此学生信息                         \n");
		while(1){   puts("\n请输入此学生的学号");       gets(c);   if(zhuanhuan(c)<0)  continue; else  {  z[i].xuehao=zhuanhuan(c);  break;   } }
		while(1){   puts("\n请输入此学生的英语成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].english=zhuanhuan(c);  break;  } }
		while(1){   puts("\n请输入此学生的数学成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].math=zhuanhuan(c);  break;     } }
		while(1){   puts("\n请输入此学生的语文成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].chinese=zhuanhuan(c);  break;  } }
		while(1){   puts("\n请输入此学生的专业成绩");   gets(c);   if(zhuanhuan(c)<0)  continue;  else {  z[i].zhuanye=zhuanhuan(c);  break;  } }
		z[i].sum=z[i].english+z[i].math+z[i].chinese+z[i].zhuanye;
		z[i].pinjun=z[i].sum/4.0;
		flag++;
  }
}
if(flag==1)		puts("\n                                 学生信息修改成功！                         \n");
else           puts("\n                             数据库中没有此学生信息！\n");
puts("\n\n                                 按回车以继续……\n\n");
getchar();   system("cls");
}


void sreach(){
double num;  int i, flag=0;
system("cls");
puts("\n                                 学生信息查询                         \n");
puts("********************************************************************************\n");
while(1){   puts("\n请输入此学生的学号");       gets(c);   if(zhuanhuan(c)<0)  continue; else  {  num=zhuanhuan(c);  break;   } }
for(i=1; i<=10000; i++){
	if(z[i].xuehao==num){
		system("cls");
		puts("\n                                 此学生的信息                         \n");
		puts("********************************************************************************");
		printf("学号： %.0f\n英语： %.0f  数学： %.0f  语文： %.0f  专业： %.0f  总成绩： %.0f  平均分： %.0f\n\n", z[i].xuehao, z[i].english, z[i].math, z[i].chinese, z[i].zhuanye, z[i].sum, z[i].pinjun);
		puts("********************************************************************************");
		flag++;
	}
}
if(flag==0)    puts("\n                             数据库中没有此学生信息！\n");
puts("\n\n                                 按回车以继续……\n\n");
getchar();   system("cls");
}



void xuehao(int flag){
int i, end, j;
for(i=1; i<=10000; i++)  if(z[i+1].xuehao<0)  break;          end=i;
xuehaokuaipai(z,1,end);
if(flag<0)		for(i=1,j=end; i<=end; i++)   {   z[0]=z[i]; z[i]=z[j]; z[j]=z[0];  j--;  if(i==j) break;  }
if(flag<0)		puts("\n                            学生信息已按学号递减排序！                         \n");
else           puts("\n                            学生信息已按学号递增排序！                         \n");
puts("\n\n                                 按回车以继续……\n\n");
getchar();   system("cls");
}


void chenji(int flag){
int i, end, j;
for(i=1; i<=10000; i++)  if(z[i+1].xuehao<0)  break;          end=i;
sumkuaipai(z,1,end);
if(flag<0)		for(i=1,j=end; i<=end; i++)   {   z[0]=z[i]; z[i]=z[j]; z[j]=z[0];  j--;  if(i==j) break;  }
if(flag<0)		puts("\n                            学生信息已按总分递减排序！                         \n");
else           puts("\n                            学生信息已按总分递增排序！                         \n");
puts("\n\n                                 按回车以继续……\n\n");
getchar();   system("cls");
}


void xieru(){
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\XueShen.txt","w+");
if(fp==NULL)     puts("\n                          在目录下找不到XueShen.txt！                           \n");   
for(i=1; i<=10000; i++)  if(z[i+1].xuehao<0)  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%lf %lf %lf %lf %lf %lf %lf\n", z[i].xuehao, z[i].english, z[i].math, z[i].chinese, z[i].zhuanye, z[i].sum, z[i].pinjun);   
puts("\n                            写入文件成功！     ");
puts("\n\n                                 按回车以继续……\n\n");
getchar();   system("cls");
fclose(fp);
}


void duqu(){
int i;   FILE *fp=NULL;
for(i=1; i<=10005; i++)   z[i].xuehao=-1;
fp=fopen("D:\\XueShen.txt","r");
if(fp==NULL)   {  puts("\n                          在目录下找不到XueShen.txt！                           \n");   return;  }
i=1;
while(fscanf(fp,"%lf%lf%lf%lf%lf%lf%lf", &z[i].xuehao, &z[i].english, &z[i].math, &z[i].chinese, &z[i].zhuanye, &z[i].sum, &z[i].pinjun)!=EOF)
i++;
puts("\n                            读取文件成功！     ");
puts("\n\n                                 按回车以继续……\n\n");
getchar();   system("cls");
fclose(fp);
}



int main(void){
char choice, cha;      int i;
for(i=1; i<=10005; i++)   z[i].xuehao=-1;
do{
   puts("\n                            小祥学生信息管理系统                         ");
	puts("                 *********************************************         ");
	puts("                 *            1. 添加学生信息                *          ");        
	puts("                 *            2. 显示所有学生信息            *          ");     
	puts("                 *            3. 删除学生信息                *          "); 
	puts("                 *            4. 修改学生信息                *          "); 
	puts("                 *            5. 查询学生信息                *          "); 
	puts("                 *            6. 按总成绩递减排序            *           "); 
	puts("                 *            7. 按总成绩递增排序            *           "); 
	puts("                 *            8. 按学号递增排序              *           "); 
	puts("                 *            9. 按学号递增排序              *           "); 
	puts("                 *            W. 写入文件                    *           "); 
	puts("                 *            R. 读取文件                    *           "); 
	puts("                 *            0. 退出系统                    *           "); 
	puts("                 *********************************************          ");
	puts("\n                                请输入您的选择:                            ");
choice=getchar();   cha=getchar();
switch(choice){
	case '1' : add();                    break;
	case '2' : show();                   break;
	case '3' : del();                    break;
	case '4' : change();                 break;
	case '5' : sreach();                 break;
	case '6' : chenji(-1);               break;
	case '7' : chenji(1);                break;
	case '8' : xuehao(-1);               break;
	case '9' : xuehao(1);                break;
	case '0' : system("cls");    printf("\n\n\n\n\n\n\n\n                       系统已退出，  谢谢您的使用！\n\n\n\n\n\n\n\n\n");   break;
	case 'W' : xieru();                  break;
	case 'R' : duqu();                   break;
	default  : printf("您的输入有误，请重新输入！\n");   break;
}
if(choice=='0') break;
}while(1);
return 0;
}