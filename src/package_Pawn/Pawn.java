package package_Pawn;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

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
        if ("White".equals(getColor())) {
            startPosition = 1;
            direction = 1;
        } else if ("Black".equals(getColor())) {
            startPosition = 6;
            direction = -1;
        } else return false;

        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (!(line == toLine && column == toColumn)) {
                if (column == toColumn) {
                    if (toLine == line + 2 * direction && line == startPosition)
                        if (chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                            return false;
                        } else return true;
                    else return toLine == line + direction;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
