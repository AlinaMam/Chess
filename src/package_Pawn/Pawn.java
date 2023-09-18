package package_Pawn;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;
import package_ChessBoard.ChessBoard;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int startPosition;
        int direction;

        if (getColor().equals("White")) {
            startPosition = 1;
            direction = 1;
        } else if (getColor().equals("Black")) {
            startPosition = 6;
            direction = -1;
        } else {
            return false;
        }

        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (!(line == toLine && column == toColumn)) {
                if (chessBoard.board[toLine][toColumn] == null) {
                    if (column == toColumn && line == startPosition) {
                        return toLine == line + 2 * direction || toLine == line + direction;
                    } else return toLine == line + direction;
                } else return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
            } else return false;
        } else return false;
    }

    public boolean isLineEmpty(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
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
        return "P";
    }
}
