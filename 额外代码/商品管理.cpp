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
//***************************************************  �ļ�ģ��  *******************************************************
void duqu(){
int i;   FILE *fp=NULL;
for(i=1; i<=MAX+3; i++)   thing[i].num=-1;
fp=fopen("D:\\chaoshi.dat                   ","r");
if(fp==NULL)   {  puts("\n                         ��ָ��Ŀ¼���Ҳ���chaoshi.dat��                           \n");  flag=1;  return;  }  i=1;
while(fscanf(fp,"%lf %lf %lf %lf %lf %lf %lf %lf %s", &thing[i].num, &thing[i].inrice,  &thing[i].outrice, &thing[i].innum, &thing[i].outnum, &thing[i].insum, &thing[i].nowhas, &thing[i].maoli, thing[i].name)!=EOF)		i++;
fclose(fp);
}

void xieru(){ 
int i, end;
FILE *fp=NULL;
fp=fopen("D:\\chaoshi.dat","w+");
if(fp==NULL)				 puts("       �ļ�д��ʧ��, ������̷���Ȩ�ޣ���\n");
for(i=1; i<=MAX; i++)  if(thing[i+1].num<0)  break;          end=i;
for(i=1; i<=end; i++)		
fprintf(fp,"%.0f %lf %lf %lf %lf %lf %lf %lf %s\n", thing[i].num, thing[i].inrice,  thing[i].outrice, thing[i].innum, thing[i].outnum, thing[i].insum, thing[i].nowhas, thing[i].maoli, thing[i].name);   
fclose(fp);
}
//******************************************  �Զ���ṹ��ȽϺ���cmp  ***************************************************
bool xiaocmp(struct jiegou a, struct jiegou b)   {		if(a.insum<b.insum)   return true;      else   return false;		}
bool maocmp (struct jiegou a, struct jiegou b)   {		if(a.maoli<b.maoli)   return true;      else   return false;		}

//**************************************************  5.������ʾ  **********************************************************
void fenpin(int flag){
	int i, big;
	system("cls");
	printf("  ****************************************************************************\n     ���                ����                  ���۶�      ʣ����     ë��\n");
	if(flag==1){
		for(i=1; i<=MAX; i++){
		if(temthing[i].num<0)		{    	printf("  ***************************************************************************\n                                  ��ʾ��ϣ�");        break;   }
		printf("  %13.0f     %23s     %7.1f   %7.0f     %7.1f\n", thing[i].num, thing[i].name, thing[i].insum, thing[i].nowhas, thing[i].maoli);
		}
	}
	else {
		for(big=1; big<=MAX; big++)			if(temthing[big+1].num<0)		break;
		for(i=big; i>=1; i--){
		if(temthing[i].num<0)		{    	printf("  ***************************************************************************\n                                  ��ʾ��ϣ�");        break;   }
		printf("  %13.0f     %23s     %7.1f   %7.0f     %7.1f\n", thing[i].num, thing[i].name, thing[i].insum, thing[i].nowhas, thing[i].maoli);
		}
	}
	getchar();	getchar();  	system("cls");
}

//*************************************************  ԭ����ʾ(5)  *******************************************************
void yuansort(){
	system("cls");
	int i;
	for(i=1; i<=MAX; i++)		temthing[i]=thing[i];
	printf("\n                                 ԭ��˳����ʾ                      \n\n");
	fenpin(1);
}
//*************************************************  ������ʾ(5)  *******************************************************
void xiaosort(){
   system("cls");
	int i;
	for(i=1; i<=MAX; i++)		temthing[i]=thing[i];
	for(i=1; i<=MAX; i++)		if(temthing[i+1].num<0)		break;
	sort(temthing+1, temthing+i+1, xiaocmp);
	printf("\n                                ���۶�˳����ʾ                      \n\n");
	fenpin(2);
}
//*************************************************  ë����ʾ(5)  *******************************************************
void maosort(){
	system("cls");
	int i;
	for(i=1; i<=MAX; i++)		temthing[i]=thing[i];
	for(i=1; i<=MAX; i++)		if(temthing[i+1].num<0)		break;
	sort(temthing+1, temthing+i+1, maocmp);
	printf("\n                                ë��˳����ʾ                      \n\n");
	fenpin(2);
}

//***************************************************  �����Ʒ  *******************************************************
void add(){
	long end, i, hao;
	for(end=1; end<=MAX; end++)   if(thing[end].num==-1)	break;
	if(end>=MAX)	        {   	puts("���ʧ�ܣ�   ���ݿ�����������ϵϵͳ����Ա!!!");    getchar();   return;  }
	printf("����������Ʒ���:  ");
	scanf("%lld", &hao);		
	for(i=1; i<=MAX; i++)		   if(thing[i].num==hao)	break;
	if(thing[i].num==hao)  {   	puts("���ʧ�ܣ�   ���ݿ������д���Ʒ��Ϣ!");    getchar();   return;  }
	       printf("��������Ʒ����:    ");		scanf("%s",  thing[end].name);		 
	loop1: printf("��������Ʒ����:    ");	   scanf("%lf", &thing[end].inrice);	 if(thing[end].inrice<0)	goto loop1;
	loop2: printf("��������Ʒ�ۼ�:    ");	   scanf("%lf", &thing[end].outrice);	 if(thing[end].outrice<0)	goto loop2;
	loop3: printf("��������Ʒ��������: ");	scanf("%lf", &thing[end].innum);		 if(thing[end].innum<0)  	goto loop3;
	loop4: printf("��������Ʒ��������: ");	scanf("%lf", &thing[end].outnum);    if(thing[end].outnum<0||thing[end].outnum>thing[end].innum)	goto loop4;
	thing[end].num=(double)hao;
	thing[end].nowhas=thing[end].innum-thing[end].outnum;
	thing[end].insum=thing[end].outrice*thing[end].outnum;
	thing[end].maoli=thing[end].insum-thing[end].inrice*thing[end].outnum;
	system("cls");        puts("                                  ������!\n\n");
	getchar();
	return;
}

//***************************************************  �޸���Ʒ  *******************************************************
void change(){
	long end, hao;
	printf("��������Ʒ���:  ");
	scanf("%lld", &hao);		
	for(end=1; end<=MAX; end++)		      if(thing[end].num==hao)	break;
	if(end>=MAX)                       {   puts("����ʧ�ܣ�   ���ݿ���û�д���Ʒ��Ϣ!");    getchar();   return;  }
	printf("\n                                 ԭ����Ʒ��Ϣ                      \n\n");
	printf("  ****************************************************************************\n\n");
	printf("   ���: %13.0f  ����: %17s  ������: %4.1f  ���ۼ�: %4.1f\n   ������: %4.0f   ������: %4.0f   ���۶�: %6.1f    ���: %4.0f  ë��: %6.1f\n\n", thing[end].num, thing[end].name, thing[end].inrice,  thing[end].outrice, thing[end].innum, thing[end].outnum, thing[end].insum, thing[end].nowhas, thing[end].maoli);    
	printf("\n\n\n                               �������µ���Ʒ��Ϣ                      \n");
	printf("  ****************************************************************************\n\n");
	loop:  printf("��������Ʒ���:    ");	   scanf("%lf", &thing[end].num);	 if(thing[end].num<0)	      goto loop;
	       printf("��������Ʒ����:    ");		scanf("%s",  thing[end].name);		 
	loop1: printf("��������Ʒ����:    ");	   scanf("%lf", &thing[end].inrice);	 if(thing[end].inrice<0)	goto loop1;
	loop2: printf("��������Ʒ�ۼ�:    ");	   scanf("%lf", &thing[end].outrice);	 if(thing[end].outrice<0)	goto loop2;
	loop3: printf("��������Ʒ��������: ");	scanf("%lf", &thing[end].innum);		 if(thing[end].innum<0)  	goto loop3;
	loop4: printf("��������Ʒ��������: ");	scanf("%lf", &thing[end].outnum);    if(thing[end].outnum<0||thing[end].outnum>thing[end].innum)	goto loop4;
	thing[end].num=(double)hao;
	thing[end].nowhas=thing[end].innum-thing[end].outnum;
	thing[end].insum=thing[end].outrice*thing[end].outnum;
	thing[end].maoli=thing[end].insum-thing[end].inrice*thing[end].outnum;
	system("cls");        puts("                                  ������!\n\n");
	getchar();
	return;
}

//***************************************************  ���ֲ���  *******************************************************
void chaname(){              
	long hao, end, flag=0;		char st[30];
	system("cls");
	printf("�����������Ʒ���֣�     ");
	scanf("%s", st);
	printf("\n                                  ���ҽ��                      \n\n");
	printf("  ****************************************************************************\n\n");
	for(end=1; end<=MAX; end++)  	 if(strstr(thing[end].name,st)!=NULL)	 {  printf("   ���: %13.0f  ����: %17s  ������: %4.1f  ���ۼ�: %4.1f\n   ������: %4.0f   ������: %4.0f   ���۶�: %6.1f    ���: %4.0f  ë��: %6.1f\n\n", thing[end].num, thing[end].name, thing[end].inrice,  thing[end].outrice, thing[end].innum, thing[end].outnum, thing[end].insum, thing[end].nowhas, thing[end].maoli);     flag++;     }    
	if(!flag)                        puts("\n                            �Ҳ�������Ҫ�����Ʒ��\n\n");  
	printf("  ****************************************************************************\n\n");
	xieru();
	getchar();	getchar();	system("cls");
}

//***************************************************  ������  *******************************************************
void chahas(){              
	long hao, end, flag=0, choice;
	system("cls");
	loop: printf("����������ɸѡ������   1. ���С��5    2. ������20\n");			
	scanf("%lld", &choice);																	if(choice!=1&&choice!=2)	goto loop;
	printf("\n                                  ���ҽ��                      \n\n");
	printf("  ****************************************************************************\n\n");
	for(end=1; end<=MAX; end++)  	 if((choice==1&&thing[end].nowhas<5&&thing[end].num>0)||(choice==2&&thing[end].nowhas>20))	 {  printf("   ���: %13.0f  ����: %17s  ������: %4.1f  ���ۼ�: %4.1f\n   ������: %4.0f   ������: %4.0f   ���۶�: %6.1f    ���: %4.0f  ë��: %6.1f\n\n", thing[end].num, thing[end].name, thing[end].inrice,  thing[end].outrice, thing[end].innum, thing[end].outnum, thing[end].insum, thing[end].nowhas, thing[end].maoli);     flag++;     }    
	if(!flag)                        puts("\n                            �Ҳ�������Ҫ�����Ʒ��\n\n");  
	printf("  ****************************************************************************\n\n");
	xieru();
	getchar();	getchar();	system("cls");
}

//************************************************  ��������  **********************************************************
void me(){
printf("               ************************************************\n");
printf("               *                   ����&����                  * \n");
printf("               *                                              * \n");
printf("               *  ˼άҲ�������ԵĲ���, �ڴ�˼��ʱ���������  *    \n");
printf("               *  ��֪����ı���, ȴҲ��ı��䡭��            *     \n");
printf("               *    �������, û�д�                        *  \n");
printf("               *  ͬ��                                        * \n");
printf("               *    ����, һ��û��Ϊʲô                  *   \n");
printf("               *  ͽ��                                        * \n");
printf("               *        ��֮����                              *  \n");
printf("               *  �ֻ�                                        * \n");
printf("               *        ��������                              *  \n");
printf("               *                                              * \n");
printf("               *                                              * \n");
printf("               *                          By ���ֳ�ʽ ����ʫ  *   \n");
printf("               ************************************************\n");
getchar();	getchar();		system("cls");
}

//**************************************************  3.ͳ��  **********************************************************
void showall(){
	int i;
	system("cls");
	printf("                                  ����ͳ��                      \n\n");
	printf("  ****************************************************************************\n     ���                ����                  ���۶�      ʣ����     ë��\n");
	for(i=1; i<=MAX; i++){
		if(thing[i].num==-1)		{    	printf("  ***************************************************************************\n                                  ��ʾ��ϣ�");        break;   }
		printf("  %13.0f     %23s     %7.1f   %7.0f     %7.1f\n", thing[i].num, thing[i].name, thing[i].insum, thing[i].nowhas, thing[i].maoli);
	}
	getchar();	getchar();  	system("cls");
}

//************************************************  ɾ����Ʒ  **********************************************************
void del(){              
	long hao, end, i;	
	loop3: puts("�����뱾��ɾ������Ʒ�ţ�");
	scanf("%lld", &hao);
	for(end=1; end<=MAX; end++)		{    if(thing[end].num==hao)	                 break;        }
	if(end>=MAX)		               {    puts("\n\n�����ڴ���Ʒ�ţ� �����������룡");   goto loop3;   }  
	for(i=end; i<=MAX; i++)		      thing[i]=thing[i+1];		
	system("cls");	printf("                              ����Ʒ��Ϣɾ���ɹ��� \n\n\n\n");
	xieru();
	getchar();
}

//**************************************************  5��ʾ�˵�  *******************************************************
int showwin(){
int i, choice;       
do{
	duqu();
	puts("                   ��������������������������������������                       ");
	puts("                           .������ѡ����(0 ~ 4):.           ");
	puts("                   ��������������������������������������                       ");
	puts("                    .      1 ������ԭ��˳����ʾ             .    ");
	puts("                    .      2 ���������۶�ߵ���ʾ            .   ");
	puts("                    .      3 ������ë���ߵ���ʾ              .   ");
	puts("                    .      4 ��������                       .   ");
	puts("                    .      0 �����˳�ϵͳ                   .    ");
	puts("                   ��������������������������������������");  

scanf("%d", &choice);
switch(choice){
	case 1 :		yuansort();	                                                                          break;
	case 2 :		xiaosort(); 	                                                                          break;
	case 3 :		maosort();                                                                           break;
	case 0 :		                                                                                          return 0;
	default:		system("cls");   puts("\n\n                           ������������, ������ѡ��\n\n\n");		break;
}
xieru();
}while(choice!=0);
return 1;	
}

//**************************************************  4���Ҳ˵�  *******************************************************
int chawin(){
int i, choice;       
do{
	duqu();
	puts("                   ��������������������������������������                       ");
	puts("                           .������ѡ����(0 ~ 3):.           ");
	puts("                   ��������������������������������������                       ");
	puts("                    .      1 ������Ʒ����ѯ            .       ");
	puts("                    .      2 ������ʣ������            .       ");
	puts("                    .      3 ��������                  .       ");
	puts("                    .      0 �����˳�ϵͳ              .       ");
	puts("                   ��������������������������������������");  

scanf("%d", &choice);
switch(choice){
	case 1 :		chaname();	                                                                              break;
	case 2 :		chahas();  	                                                                              break;
	case 3 :		system("cls");   return 1;                                                                break;
	case 0 :		                                                                                          return 0;
	default:		system("cls");   puts("\n\n                           ������������, ������ѡ��\n\n\n");		break;
}
xieru();
}while(choice!=0);
return 1;	
}

//**************************************************  2�༭�˵�  *******************************************************
int editwin(){
int i, choice;       
do{
	duqu();
	puts("                   ��������������������������������������                       ");
	puts("                           .������ѡ����(0 ~ 4):.           ");
	puts("                   ��������������������������������������                       ");
	puts("                    .      1 �����������Ʒ             .       ");
	puts("                    .      2 ����ɾ��ԭ����Ʒ           .       ");
	puts("                    .      3 �����޸�ԭ����Ʒ��Ϣ       .       ");
	puts("                    .      4 ��������                  .       ");
	puts("                    .      0 �����˳�ϵͳ               .       ");
	puts("                   ��������������������������������������");  

scanf("%d", &choice);
switch(choice){
	case 1 :		add();	                                                                                 break;
	case 2 :		del();  	                                                                           	   break;
	case 3 :		change();	                                                                           	break;
	case 4 :		system("cls");   return 1;                                                                break;
	case 0 :		                                                                                          return 0;
	default:		system("cls");   puts("\n\n                           ������������, ������ѡ��\n\n\n");		break;
}
xieru();
}while(choice!=0);
return 1;	
}

//****************************************************  ���˵�  *******************************************************
int main(void){
int i, choice;
for(i=1; i<=MAX+3; i++)	   	thing[i].num=-1;       
do{
	duqu();
	flag=0;
	puts("                   ��������������������������������������                      ");
	puts("                           .������ѡ����(0 ~ 6):.          ");
	puts("                   ��������������������������������������                      ");
	puts("                    .      1 ����������Ʒ�ļ�         .        ");
	puts("                    .      2 �����༭��Ʒ             .        ");
	puts("                    .      3 ����ͳ���������         .         ");
	puts("                    .      4 ������ѯ��Ʒ��Ϣ         .         ");
	puts("                    .      5 ������ʾ��Ʒ��Ϣ         .         ");
	puts("                    .      6 ������������             .        ");
	puts("                    .      0 �����˳�ϵͳ             .         ");
	puts("                   ��������������������������������������");  

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");       xieru();             printf("\n                                   ����");   if(!flag) printf("�ɹ�!\n\n\n"); else printf("ʧ��!\n\n\n");       break;
	case 2 :		system("cls");		   choice=editwin();	                                                      break;                                                                        	   break;
	case 3 :		system("cls");       showall();	                                                      	   break;
	case 4 :		system("cls");		   choice=chawin();                                                    	   break;
	case 5 :		system("cls");		   choice=showwin();	                                           	         break;
	case 6 :		system("cls");       me();	                                                                  break;
	case 0 :		                                                                                             break;
	default:		system("cls");       puts("\n\n                           ������������, ������ѡ��\n\n\n");   break;
}
xieru();
}while(choice!=0);			         system("cls");		
puts("\n\n\n\n\n\n\n\n                  ��лʹ�ñ�������������˳����������������\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  ���ֳ�ʽ ����ʫ");
return 0;
}