package game;

import game.pieces.*;

public class Board {
    private Piece[][] boardArray = new Piece[8][8];

    public Board() {
        //Setup Board in constructor
        //Use [row][col] scheme
        //[0][0] = Top left
        //[7][0] = Bottom left
        boardArray[0][0] = new Rook(TeamColor.BLACK);
        boardArray[0][1] = new Knight(TeamColor.BLACK);
        boardArray[0][2] = new Bishop(TeamColor.BLACK);
        boardArray[0][3] = new Queen(TeamColor.BLACK);
        boardArray[0][4] = new King(TeamColor.BLACK);
        boardArray[0][5] = new Bishop(TeamColor.BLACK);
        boardArray[0][6] = new Knight(TeamColor.BLACK);
        boardArray[0][7] = new Rook(TeamColor.BLACK);

        for(int i = 0; i < 8; i++) {
            boardArray[1][i] = new Pawn(TeamColor.BLACK);
        }

        boardArray[7][0] = new Rook(TeamColor.WHITE);
        boardArray[7][1] = new Knight(TeamColor.WHITE);
        boardArray[7][2] = new Bishop(TeamColor.WHITE);
        boardArray[7][3] = new Queen(TeamColor.WHITE);
        boardArray[7][4] = new King(TeamColor.WHITE);
        boardArray[7][5] = new Bishop(TeamColor.WHITE);
        boardArray[7][6] = new Knight(TeamColor.WHITE);
        boardArray[7][7] = new Rook(TeamColor.WHITE);

        for(int i = 0; i < 8; i++) {
            boardArray[6][i] = new Pawn(TeamColor.WHITE);
        }

    }

    public Piece[][] getBoardArray() {
        return boardArray;
    }

}
