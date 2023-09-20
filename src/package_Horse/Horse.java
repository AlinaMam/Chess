package package_Horse;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {

        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            return  (toLine == line + 2 && (toColumn == column + 1 || toColumn == column - 1) ||
                    (toLine == line - 2 && (toColumn == column + 1 || toColumn == column - 1)) ||
                    (toColumn == column - 2 && (toLine == line + 1 || toLine == line - 1)) ||
                    (toColumn == column + 2 && (toLine == line + 1 || toLine == line - 1)));
        }
        return !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }

        @Override
        public String getSymbol () {
            return "H";
        }
    }
