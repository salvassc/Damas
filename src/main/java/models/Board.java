package models;

import types.Color;

public class Board {

    private static final int MAX_PIECES_PEON = 12;
    private static final int MAX_PIECES_LADY = 2;
    private Square[][] squares;
    private Piece [][] pieces;

    public Board(){
        this.clear();
    }

    public void clear(){
        squares = new Square[8][8];
        pieces = new Piece[Color.values().length][MAX_PIECES_PEON];
        initBoard();
    }

    private void initBoard(){

    }

    public void addPiecesBoard(Coordinate coordinate, Piece piece, Color color){
        if(piece.getClass().getName().equals("Peon"))
            squares[coordinate.row][coordinate.column] = new Square(new Peon(color));
        else
            squares[coordinate.row][coordinate.column] = new Square(new Lady(color));
    }

    public boolean isWinner(){
        return true;
    }

    public int getPiecesWhite(){
        return this.pieces[0].length;
    }

    public int getPiecesBlack(){
        return this.pieces[1].length;
    }

    public int getPiecesPeons(){
        return 24;    
    }

    public int getPiecesLadies(){
        return 0;    
    }

    public boolean squareEmpty(Coordinate coordinate){
        return squares[coordinate.row][coordinate.column].isEmpty();
    }    

    public Piece getPiece(Coordinate coordinate){
        return squares[coordinate.row][coordinate.column].getPiece();
    }

    public Color getPieceColor(Coordinate coordinate){
        return squares[coordinate.row][coordinate.column].getPiece().getColor();
    }

    public boolean isPosibleMove(Coordinate origin, Coordinate target){
        return true;
    }

    public void move(Coordinate origin, Coordinate target){
        isPosibleMove(origin, target);
    }

    public void move(Coordinate origin, Coordinate target, Coordinate zigzag){
        isPosibleMove(origin, target);
    }

}