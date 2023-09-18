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
                        if (chessBoard.board[toLine][toColumn] != null) {
                            return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
                        } return true;
                    } else return false;
                } else return false;
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
        return "H";
    }
}
