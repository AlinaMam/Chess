package package_Rook;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (!(line == toLine && column == toColumn)) {
                if ((chessBoard.checkPos(Math.abs(line - toLine)) && Math.abs(column - toColumn) == 0) ^ (chessBoard.checkPos(Math.abs(column - toColumn)) && Math.abs(line - toLine) == 0)) { //комментарий п.3. Ладья может ходить
                    // по прямой (по горизонтали и по вертикали). True будет когда одно из условий выполнится.
                    if (chessBoard.board[toLine][toColumn] != null) { // комментарий п.4 - если ячейка не null
                        return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()); // на ней не должно быть фигуры нашего цвета
                    } else return false;
                } else return false;
            } else return false;
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
