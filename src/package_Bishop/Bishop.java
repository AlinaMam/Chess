package package_Bishop;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

public class Bishop extends ChessPiece {
    public Bishop(String color) {

        super(color);
    }

    @Override
    public String getColor() {

        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (toLine == line || toColumn == column) return false;
            else if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                //по диагонали вниз и вправо
                if (toColumn > column && toLine > line) {
                    for (int i = 1; i + column < toColumn; i++) {
                        if (chessBoard.board[line + i][column + i] != null) {
                            return false;
                        }
                    }
                    return true;

                    //по диагонали вниз и влево
                } else if (toColumn < column && toLine > line) {
                    for (int i = 1; line + i < toLine; i++) {
                        if (chessBoard.board[line + i][column - i] != null) {
                            return false;
                        }
                    }
                    return true;

                    //по диагонали вверх и вправо
                } else if (toColumn > column && toLine < line) {
                    for (int i = 1; i + column < toColumn; i++) {
                        if (chessBoard.board[line - i][column + i] != null) {
                            return false;
                        }
                    }
                    return true;

                    //по диагонали вверх и влево
                } else {
                    for (int i = 1; line - i > toLine; i++) {
                        if (chessBoard.board[line - i][column - i] != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}
