package com.example;

import java.util.Random;

public class AIcontrol {
    private ChessBoard mChessBoard;

    public AIcontrol(ChessBoard chessBoard) {
        mChessBoard = chessBoard;
    }

    public void work(){
        int newX, newY;
        Frame.jiBuLable.setText("目前双方已下 " + (++Frame.bushu) + " 步");
        Random random = new Random(8);
        newX = (int) (Math.random()*19+1);      newY = (int) (Math.random()*19+1);
        mChessBoard.addQiZi(newX, newY, (ChessBoard.userColor==ChessBoard.BAI)?ChessBoard.HEI:ChessBoard.BAI);
        mChessBoard.checkWin(newX, newY);
    }

}
