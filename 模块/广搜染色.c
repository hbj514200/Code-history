
int next[8][2]={{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
char a[105][105], cha;  int book[105][105], n, m;  struct poin { int x, y; };

void bfs(int startx, int starty){
struct poin z[3000];   int i, j, head=1, tail=1, tx, k, ty;
z[1].x=startx, z[1].y=starty; 
while(head<=tail){
for(k=0; k<=7; k++){
tx=z[head].x+next[k][0];  ty=z[head].y+next[k][1];
if(tx<0||ty<0||tx>=n||ty>=m)   continue;
if(a[tx][ty]=='@'&&book[tx][ty]==0)  {  z[++tail].x=tx, z[tail].y=ty; book[tx][ty]=1;  }
}
head++;
}
return;
}

//��Ҫ������չ��ʼ��x,y�� ����char��ͼ��@��Ⱦɫ�� ��Ҫa[105][105]��ͼ�� ���б��book[105][105]. 
//ȫ�ֱ�����ͼn, m�� ��ͼ��0��ʼ