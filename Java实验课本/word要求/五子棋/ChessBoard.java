package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * JPanel， 绘制棋盘部分。
 */

public class ChessBoard extends JPanel implements MouseListener {
    public boolean working;     //棋盘是否应该响应点击，
    private Image boardImg;
    private int x, y;           //棋盘左上角的坐标
    private Image heiImg, baiImg;
    private int span_x, span_y; //两线间隔
    static final int BAI = 1, HEI = 2;
    static int userColor = HEI;     //用户执子颜色
    private final int ROWS = 20;    //线条行数
    public int[][] pan = new int[20][20];  //二维棋盘数据
    public static AIcontrol control;

    public ChessBoard() {
        boardImg = Toolkit.getDefaultToolkit().getImage("d:\\chessboard2.png");
        heiImg = Toolkit.getDefaultToolkit().getImage("d:\\hei.png");
        baiImg = Toolkit.getDefaultToolkit().getImage("d:\\bai.png");
        if(boardImg==null || heiImg==null || baiImg==null)
            JOptionPane.showMessageDialog(this, "加载棋盘图片失败！");
        addMouseListener(this);
        control = new AIcontrol(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int imgWidth = boardImg.getHeight(this);      //得到xy，绘制居中棋盘图片位置（左上角）
        int imgHeight = boardImg.getWidth(this);
        int FWidth = getWidth();
        int FHeight= getHeight();
        x=(FWidth-imgWidth)/2;
        y=(FHeight-imgHeight)/2;
        g.drawImage(boardImg, x, y, null);

        span_x = imgWidth/ ROWS;                  //棋盘两线间隔
        span_y = imgHeight/ ROWS;
        for(int i=0; i<=ROWS; i++){
            if(i!=0&&i!=20)
                g.drawString(((i>10)?"0":"")+Integer.toString(20-i), x-20 ,y+5+i*span_y);    //绘制横线
            g.drawLine(x, y+i*span_y, FWidth-x,y+i*span_y);
        }
        char ch = 'a'-1;
        for(int i=0; i<=ROWS; i++,ch++){
            if(ch!='a'-1&&ch!='t')
                g.drawString(String.valueOf(ch), x-3+i*span_y ,FHeight-y+20);                 //绘制竖线
            g.drawLine(x+i*span_x, y, x+i*span_x,FHeight-y);
        }

        addQiZi(1,1,HEI);   addQiZi(1,1,BAI);     pan[1][1] = 0;    //没办法，第二次调用才会显示……
    }

    public void addQiZi(int newX, int newY, int flag){
        if(newX<1 || newX>19 || newY<1 || newY>19 || (flag!=BAI&&flag!=HEI) )  return;
        if(flag==HEI)
        getGraphics().drawImage(heiImg, x+newX*span_x-heiImg.getWidth(this)/2, y+(20-newY)*span_y-heiImg.getHeight(this)/2, null);
        else
        getGraphics().drawImage(baiImg, x+newX*span_x-baiImg.getWidth(this)/2, y+(20-newY)*span_y-baiImg.getHeight(this)/2, null);
        pan[newX][newY] = flag;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        int minY = 1, minX = 1;
        for(int i=0; i<=ROWS; i++)  if( Math.abs((y+i*span_y)-event.getY())<Math.abs((y+minY*span_y)-event.getY()))    minY = i ;
        for(int i=0; i<=ROWS; i++)  if( Math.abs((x+i*span_x)-event.getX())<Math.abs((x+minX*span_x)-event.getX()))    minX = i ;
        if(!working || pan[minX][ROWS-minY]!=0)  return;
        addQiZi(minX, ROWS-minY, userColor);
        checkWin(minX, ROWS-minY);
        control.work();
        Frame.jiBuLable.setText("目前双方已下 " + (++Frame.bushu) + " 步");
    }
    @Override public void mousePressed(MouseEvent mouseEvent) {}
    @Override public void mouseReleased(MouseEvent mouseEvent) {}
    @Override public void mouseEntered(MouseEvent mouseEvent) {}
    @Override public void mouseExited(MouseEvent mouseEvent) {}

    //判断目前棋盘上是否有胜利，传入最后落子位置。
    public void checkWin(int x, int y){
        int oldX = x,   oldY = y, leixin = 0;
        int[][] z = this.pan;
        try {
            int count = 1;                                //横向检查
            while(z[x][y++]==z[oldX][oldY])   count++;
            x = oldX;   y = oldY;
            while(z[x][y--]==z[oldX][oldY])   count++;
            if(count>=7)    leixin = z[oldX][oldY];

            count = 1;  x = oldX;   y = oldY;             //纵向检查
            while(z[x++][y]==z[oldX][oldY])   count++;
            x = oldX;   y = oldY;
            while(z[x++][y]==z[oldX][oldY])   count++;
            if(count>=7)    leixin = z[oldX][oldY];

            count = 1;  x = oldX;   y = oldY;             //左上右下
            while(z[x++][y++]==z[oldX][oldY])   count++;
            x = oldX;   y = oldY;
            while(z[x--][y--]==z[oldX][oldY])   count++;
            if(count>=7)    leixin = z[oldX][oldY];

            count = 1;  x = oldX;   y = oldY;             //左下右上
            while(z[x++][y--]==z[oldX][oldY])   count++;
            x = oldX;   y = oldY;
            while(z[x--][y++]==z[oldX][oldY])   count++;
            if(count>=7)    leixin = z[oldX][oldY];
        } catch (ArrayIndexOutOfBoundsException ignored){ }
        if(leixin!=0){
            JOptionPane.showMessageDialog(null, (leixin==BAI)?"白棋胜利！":"黑棋胜利！");
            working = false;
        }
    }

}