package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class AIcontrol {
    private ChessBoard mChessBoard;
    private static int[][] pan = new int[20][20];
    private static Nei[] data = new Nei[1000005];
    private int step = 0, zuo = 0, you = 1;
    public int comColor = ChessBoard.BAI;        //电脑执子记号
    public int userColor = ChessBoard.HEI;
    private int[] map = new int[2500];

    public AIcontrol(ChessBoard chessBoard) {
        mChessBoard = chessBoard;
        for(int i=0; i<1000005; i++)   data[i] = new Nei();
        clean();
    }

    public void work(int oldX, int oldY, int[][] oldPan){
        if(ChessBoard.userColor==ChessBoard.BAI)  { comColor = ChessBoard.HEI;  userColor = ChessBoard.BAI; }
        for(int i=0; i<20; i++)     System.arraycopy(oldPan[i], 0, pan[i], 0, 20);

        //不做搜索，直接利用评分模块进行走子。 使用时去除注释符号即可。
        /*int maxX = 1, maxY = 1;
        for(int i=oldX-6; i<=oldX+6; i++)
            for(int j=oldY-6; j<=oldY+6; j++){
                if(i<1 || i>19 || j<1 || j>19)  continue;
                    if(pan[i][j]==0&&jiazhi(i, j, comColor, 1, true)>jiazhi(maxX, maxY, comColor, 1,true)){
                        maxX = i;   maxY = j;
                    }
            }
        Frame.jiBuLable.setText("目前双方已下 " + (++Frame.bushu) + " 步");
        mChessBoard.addQiZi(maxX, maxY, (ChessBoard.userColor==1)?2:1);
        mChessBoard.checkWin(maxX, maxY);
        clean();
        System.out.println(maxX+"  "+maxY);
        if(maxX>Integer.MIN_VALUE)  return;*/

        data[zuo].x[0] = (byte) oldX;    data[zuo].y[0] = (byte) oldY;
        data[zuo].bu = 0;
        while (zuo<you){
            step = data[zuo].bu;
            BFS(data[zuo].x[step], data[zuo].y[step], (step%2==0)?comColor:userColor);
        }
        for(int i=0; i<=2400; i++)  if(map[i]==Integer.MAX_VALUE)   map[i] = Integer.MIN_VALUE;
        int max = 100;
        for(int i=100; i<=2400; i++)  if(map[i]>map[max])     max = i;

        Frame.jiBuLable.setText("目前双方已下 " + (++Frame.bushu) + " 步");
        mChessBoard.addQiZi(max/100, max%100, comColor);
        mChessBoard.checkWin(max/100, max%100);
        clean();
    }

    private void clean(){
        Arrays.fill(map, Integer.MAX_VALUE);
        step = 0; zuo = 0; you = 1;
        for(int i=0; i<1000005; i++)   data[i].reset();
    }

    private class Nei {
        byte[] x = {100,100,100,100,100,100,100};
        byte[] y = {100,100,100,100,100,100,100};
        int fen = -10;
        byte bu = 0;
        void reset(){
            Arrays.fill(x, (byte)100);  fen = -10;
            Arrays.fill(y, (byte)100);  bu = 0;
        }
    }

    private static int[][] a = new int[5][11];
    private int jiazhi(int X, int Y, int flag, int jieshu, boolean zhen){
        int index = 1, i, j;
        for(i=X-4; i<=X+4; i++){
            if(i<1 || i>19)  a[1][index++] = 100;          //竖
            else             a[1][index++] = pan[i][Y];
        }
        index = 1;
        for(i=Y-4; i<=Y+4; i++){
            if(i<1 || i>19)  a[2][index++] = 100;          //横
            else             a[2][index++] = pan[X][i];
        }
        index = 1;
        for(i=X-4,j=Y-4; i<=X+4; i++,j++){
                if(i<1 || i>19 || j<1 || j>19)  a[3][index++] = 100;   //右上
                else             a[3][index++] = pan[i][j];
        }
        index = 1;
        for(i=X-4,j=Y+4; i<=X+4; i++,j--){
                if(i<1 || i>19 || j<1 || j>19)  a[4][index++] = 100;   //右下
                else             a[4][index++] = pan[i][j];
            }

        int num=1, si=0, fen=0;
        for(int k=1; k<=4; k++){
            i=1;    while(a[k][5-i]==flag)  {   num++;  i++;    }    if(a[k][5-i]!=0)   si++;
            i=1;    while(a[k][5+i]==flag)  {   num++;  i++;    }    if(a[k][5+i]!=0)   si++;
            fen += Sorce.getFen(num, si);
            num = 1;    si = 0;
        }

        if(jieshu!=0)   fen += jiazhi(X, Y, (flag==1)?2:1, 0, true);
        return (zhen)?fen:-fen;
    }

    //这一段本事利用博弈树进行多步搜索的，伴随着各种优化剪枝，但可能由于位置评分模块并非对整个局面评分的缘故或者其他未知原因，
    //工作结果并不理想甚至会使得棋力下降。暂时保留，先算了吧。
    private void BFS(int X, int Y, final int meColor){
        int oldYou = you;
        for(int k=0; k<=step; k++)   pan[data[zuo].x[k]][data[zuo].y[k]] = (step%2==1)?comColor:userColor;
        for(int i=X-8; i<=X+8; i++)
        for(int j=Y-8; j<=Y+8; j++){
            if(i<1 || i>19 || j<1 || j>19 || pan[i][j]!=0)  continue;
            data[you].x[step+1] = (byte) i;
            data[you].y[step+1] = (byte) j;
            data[you].bu = (byte) (step+1);
            for(int k=0; k<=step; k++){
                data[you].x[k] = data[zuo].x[k];    data[you].y[k] = data[zuo].y[k];
            }
            data[you].fen = data[zuo].fen + jiazhi(i,j,meColor, 1, (meColor == comColor));
            you++;
            if(data[zuo].bu==5){        //最后一轮不存入数组
                you--;
                zuihou(data[you].fen, data[you].x[1]*100 + data[you].y[1]);
            }
        }
        for(int k=0; k<=step; k++)   pan[data[zuo].x[k]][data[zuo].y[k]] = 0;
        if(data[zuo].bu==5)     {    zuo++;   return;    }
        Arrays.sort(data, oldYou, you-1, new Comparator<Nei>() {
            @Override
            public int compare(Nei nei, Nei t1) {
                if(meColor==comColor)    return t1.fen-nei.fen;      //电脑逆序挑大的
                else                     return nei.fen-t1.fen;      //用户顺序调小的
            }
        });
        if(meColor==comColor)   if(you-oldYou>8)    you = oldYou + 8;
        if(meColor==userColor)  if(you-oldYou>4)    you = oldYou + 4;
        zuo++;
    }

    private void zuihou(int fen, int key){
        if(fen < map[key])    map[key] = fen;
    }

}
