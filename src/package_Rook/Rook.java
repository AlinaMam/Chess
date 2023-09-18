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
                if ((chessBoard.checkPos(Math.abs(line - toLine)) && Math.abs(column - toColumn) == 0) ^ (chessBoard.checkPos(Math.abs(column - toColumn)) && Math.abs(line - toLine) == 0)) {
                    return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public boolean isLineEmpty (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean isEmpty = true;

        int directionLine = Integer.compare(toLine, line);
        int directionColumn = Integer.compare(toColumn, column);
        int lineLength = 0;

        if (directionColumn == 0) {
            lineLength = Math.abs(toLine - line);
        } else if (directionLine == 0) {
            lineLength = Math.abs(toColumn - column);
        } else lineLength = Math.abs(toColumn - column);

        for (int i = 0; i < lineLength; i++) {
            if (chessBoard.board[line + i * directionLine][column + i * directionColumn] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }


    @Override
    public String getSymbol() {
        return "R";
    }
}
