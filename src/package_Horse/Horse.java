package package_Horse;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (!(line == toLine && column == toColumn)) {
                if (!(line == toLine ^ column == toColumn)) {
                    if (Math.abs(toLine - line) <= 2 && Math.abs(toColumn - column) <= 2) {
                       if(chessBoard.board[toLine][toColumn]  != null) { // комментарий п.4 - если ячейка не null
                           return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()); // на ней не должно быть фигуры нашего цвета
                       } else return false;
                    } else return false;
                } else return false;
            } else return false;
        } return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
