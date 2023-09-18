package package_King;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

public class King extends ChessPiece {
    public King(String color) {
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
                if ((Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 0) || (Math.abs(column - toColumn) == 1 && Math.abs(line - toLine) == 0) ||
                        (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1)) {
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
                    }
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

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean isUnderAttack = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color)) {
                        if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            isUnderAttack = true;
                        }
                    }
                }
            }
        }
        return isUnderAttack;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
