#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
struct jiegou {  int i, j;       };
struct kuansou { int i, j, turn; };
struct jiegou z[20005], food;		int end, head, jiange=200, yanshi=0, foodfari, foodfarj;    char choice;
void gameover();

//*************************************************  蛇身移动  ******************************************************
void move(){
	z[head+1]=z[head];	head++;		    end++;
	if(choice=='w')		z[head].i--;
	if(choice=='a')		z[head].j--;
	if(choice=='s')		z[head].i++;
	if(choice=='d')		z[head].j++;
}

//*********************************************  蛇身判断(回收)  ******************************************************
int zhence(int x, int y){
	int i, flag=0;
	for(i=end; i<=head; i++)		if(z[i].i==x&&z[i].j==y)	  {	 flag=1;    break;    }
	return flag;
}

//*************************************************  光标移动  ********************************************************
void gotoxy(int y, int x){
COORD pos={x*2, y};
SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),pos);
}

//***********************************************  显示模块  ******************************************************
void show(){  
   gotoxy(z[head].i,   z[head].j);		 printf("■");		
	gotoxy(z[end-1].i,  z[end-1].j );    printf("  ");	
}

//***********************************************  人工智能  ******************************************************
char bfs(int leixin){
	#define temi s[tou].i
	#define temj s[tou].j
	int tou=1, wei=1, jilu[28][43], i, j;         struct kuansou s[1000];     char choice='w';
	if(leixin==1||leixin==2||leixin==4)     {     s[1].i=z[head].i;           s[1].j=z[head].j;     }
	if(leixin==3)                           {     s[1].i=food.i;              s[1].j=food.j;        }
	for(i=1; i<=24; i++)
	for(j=1; j<=39; j++)
	if(zhence(i,j)==0)        jilu[i][j]=0;       else        jilu[i][j]=1;   
	while(tou<=wei){		
		if(s[tou].i==foodfari&&s[tou].j==foodfarj&&leixin==4)                                             break; 
		if(s[tou].i==food.i&&s[tou].j==food.j&&leixin==1)                                                 break;
		if(s[tou].i==z[end-1].i&&s[tou].j==z[end-1].j&&leixin==2)                                         break;		
		if(zhence(temi-1, temj)==0&&temi-1>=1&&temi-1<=24&&temj>=1&&temj<=39&&jilu[temi-1][temj]==0)   {  wei++;  s[wei].i=temi-1;  s[wei].j=temj;    jilu[temi-1][temj]=1;   if(tou!=1)   s[wei].turn=s[tou].turn;   else s[wei].turn=8; }
		if(zhence(temi+1, temj)==0&&temi+1>=1&&temi+1<=24&&temj>=1&&temj<=39&&jilu[temi+1][temj]==0)   {  wei++;  s[wei].i=temi+1;  s[wei].j=temj;    jilu[temi+1][temj]=1;   if(tou!=1)   s[wei].turn=s[tou].turn;   else s[wei].turn=2; }
		if(zhence(temi, temj-1)==0&&temi>=1&&temi<=24&&temj-1>=1&&temj-1<=39&&jilu[temi][temj-1]==0)   {  wei++;  s[wei].i=temi;    s[wei].j=temj-1;  jilu[temi][temj-1]=1;   if(tou!=1)   s[wei].turn=s[tou].turn;   else s[wei].turn=4; }
		if(zhence(temi, temj+1)==0&&temi>=1&&temi<=24&&temj+1>=1&&temj+1<=39&&jilu[temi][temj+1]==0)   {  wei++;  s[wei].i=temi;    s[wei].j=temj+1;  jilu[temi][temj+1]=1;   if(tou!=1)   s[wei].turn=s[tou].turn;   else s[wei].turn=6; }
		tou++;
	}
	if(leixin==3)		{    foodfari=s[wei].i;   foodfarj=s[wei].j;  return bfs(4);   }
	if(leixin==4){
		if(s[tou].i==foodfari&&s[tou].j==foodfarj)
		switch(s[tou].turn){
			case 8 :            choice='w';			break;
			case 2 :            choice='s';			break;
			case 4 :            choice='a';			break;
			case 6 :            choice='d';			break;
		}
		else choice=bfs(2);
		return choice;
	}
	if(leixin==1){
		if((s[tou].i==food.i&&s[tou].j==food.j)&&bfs(2)!='n')
		switch(s[tou].turn){
			case 8 :            choice='w';			break;
			case 2 :            choice='s';			break;
			case 4 :            choice='a';			break;
			case 6 :            choice='d';			break;
		}
		else
			choice=bfs(3);  //离食物最远的地方走去
	}
	
	if(leixin==2)	 {
		if(s[tou].i==z[end-1].i&&s[tou].j==z[end-1].j)
			switch(s[tou].turn){
				case 8 :            choice='w';			break;
				case 2 :            choice='s';			break;
				case 4 :            choice='a';			break;
				case 6 :            choice='d';			break;
		} 
		else     return 'n'; 
  }
	return choice;
}

//*************************************************  投放食物  ******************************************************
void newFood(){
	int x, y;
	if(food.i!=-10)               return;
	srand(time(NULL));   
	while(1)  {  x=rand()%24+1;   y=rand()%39+1;    if(zhence(x,y)==0)    break;     }
	food.i=x;	 food.j=y;
	gotoxy(food.i,   food.j);	   printf("■");	
}

//************************************************  输入模块  ******************************************************
void input(){
	char key;
	if(_kbhit()&&(key=getch())!=0)		
	if(key=='w'||key=='a'||key=='s'||key=='d')	choice=key;  
}

//*************************************************  头部侦测  ******************************************************
int pantou(){
	int i, sum=0;
	if(food.i==z[head].i&&food.j==z[head].j)                {     end--;     food.i=-10;     return 0;  }
	if(z[head].i<1||z[head].i>24||z[head].j<1||z[head].j>39)                 return 1;
	for(i=end; i<=head; i++)    if(z[i].i==z[head].i&&z[i].j==z[head].j)     sum++;
	if(sum==1)                                                               return 0;
	return 1;
}

//***********************************************  游戏主模块  ******************************************************
void begin(){
int flag=0;       
end=1; head=2;		z[head].i=12;	 z[head].j=38;		z[end].i=12;	 z[end].j=39;   choice='a';		food.i=-10; 
while(1){
	newFood();
	if(yanshi==1)	          choice=bfs(1);
	Sleep(jiange);
	move(); 
	flag=pantou();
	show();                        
	input();
   if(flag==1)	        {	 gameover();		break;   }
	}	
}

//************************************************  游戏演示  *******************************************************
void cat(){
	puts("\n\n\n\n        这是 小祥 最新训练的 AlpCat 小宠物， 我会让着你哦， 我给你演示下，");
	puts("\n           先走吃70个给你看吧，  小祥 教我广度优先搜索哦！！                 \n\n\n\n");
	getchar();    getchar();     system("cls"); 
	jiange=5;
	yanshi=1;
	begin();
}

//************************************************  游戏失败  *******************************************************
void gameover(){
getchar();
system("cls");
Sleep(200);
printf("               ************************************************\n");
printf("               *                   你输了                     * \n");
printf("               *                                              * \n");
printf("               *                你的长度:  %d                 *\n", head-end+1);
printf("               *                                              *  \n");
printf("               *                                              *  \n");
printf("               *                                              * \n");
printf("               *                  记住                        *     \n");
printf("               *                                              *   \n");
printf("               *        打败你的不是别人                      *  \n");
printf("               *        而是                                  * \n");
printf("               *         因为欲望而不断膨胀的自己！！！！     * \n");
printf("               *                                              * \n");
printf("               *                                              * \n");
printf("               *                                  贪吃蛇      *   \n");
printf("               ************************************************\n\n\n\n");
printf("         紧张能让你更清楚地做出选择， 即使在混乱中， 也有规律可循\n\n");
printf("         同样的动作， 却希望有不同结果， 这无异于缘木求鱼…………");
getchar();	getchar();		system("cls");
}

//************************************************  关于作者  *******************************************************
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
printf("         紧张能让你更清楚地做出选择， 即使在混乱中， 也有规律可循\n\n");
printf("         同样的动作， 却希望有不同结果， 这无异于缘木求鱼…………");
getchar();	getchar();		system("cls");
}

//*************************************************  主菜单  *******************************************************
int main(void){
int choice; 		
do{
	puts("                   …………………………………………………                      ");
	puts("                                .小祥 贪吃蛇.                ");
	puts("                   …………………………………………………                      ");
	puts("                    .         1 ——开始游戏          .        ");
	puts("                    .         2 ——AlpCat 演示       .        ");
	puts("                    .         3 ——关于作者          .        ");
	puts("                    .         0 ——退出游戏          .         ");
	puts("                   …………………………………………………");  
puts("                                                 ┏┛┻━━━┛┻┓           ");
puts("                                                 ┃｜｜｜｜｜｜｜┃      ");
puts("                                                 ┃　　　━　　　┃       ");
puts("                                                 ┃　┳┛　┗┳　┃         ");
puts("                                                 ┃　　　　　　　┃      ");
puts("                                                 ┃　　　┻　　　┃       ");
puts("                                                 ┃　　　　　　　┃       ");
puts("                                                 ┗━┓　　　┏━┛          ");
puts("                                                     ┃　　　┃           ");
puts("                                                     ┃　　　┃           ");
puts("                                                     ┃　　　┃            ");
puts("                                                     ┃　　　┗━━━┓       ");
puts("                                                     ┃ 你妹与我同在 ┣┓    ");
puts("                                                     ┃ 舍长专属宠物 ┃     ");
puts("                                                     ┗┓┓┏━┳┓┏┛        ");
puts("                                                       ┃┫┫　┃┫┫        ");
printf("                                                       ┗┻┛　┗┻┛        ");

scanf("%d", &choice);
switch(choice){
	case 1 :		system("cls");       jiange=200;      yanshi=0;    begin();                                  break;
	case 2 :		system("cls");		   cat();	                                                               break;                                                                        	   break;
	case 3 :		system("cls");       me();	                                                      	         break;
	case 0 :		                                                                                             break;
	default:		system("cls");       puts("\n\n                           您的输入有误, 请重新选择！\n\n\n");   break;
}
}while(choice!=0);			         system("cls");		
puts("\n\n\n\n\n\n\n\n                  感谢使用本游戏。已正常退出，按任意键结束。\n\n");	
puts("\n\n\n\n\n\n\n\n\n                                                            By  左手程式 右手诗");
return 0;
}