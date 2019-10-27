package models;

import types.Color;

public class Game {

    private Board board;
    private Turn turn;

    public Game(){
        board = new Board();
        turn = new Turn(Color.WHITE);
    }

    public void clear(){
        this.board.clear();
    }

    public Turn getTurn(){
        return this.turn;
    }

    public void nextTurn(){
        if(this.turn.getColor() == Color.WHITE)
            this.turn.setColor(Color.BLACK);
        else
        this.turn.setColor(Color.WHITE);
    }

    public void move(Coordinate origin, Coordinate target){
        this.board.move(origin, target);    
    }

    public void move(Coordinate origin, Coordinate target, Coordinate zigzag){
        this.board.move(origin, target);    
    }

    public boolean isWinner(){
        return this.board.isWinner();
    }

    public Piece getPiece(Coordinate coordinate){
        return this.board.getPiece(coordinate);
    }

    public int getPiecesWhite(){
        return this.board.getPiecesWhite();
    }

    public int getPiecesBlack(){
        return this.board.getPiecesBlack();
    }

    public int getPiecesPeons(){
        return this.board.getPiecesPeons();    
    }

    public int getPiecesLadies(){
        return this.board.getPiecesLadies();    
    }

    public boolean squareEmpty(Coordinate coordinate){
        return this.board.squareEmpty(coordinate);
    }    

    public Color getPieceColor(Coordinate coordinate){
        return this.board.getPieceColor(coordinate);
    }

}