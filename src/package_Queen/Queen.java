package package_Queen;

import package_Bishop.Bishop;
import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;
import package_Rook.Rook;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (Math.abs(line - toLine) == Math.abs(column - toColumn) && line != toLine && column != toColumn) {
                return new Bishop(getColor()).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
            } else return new Rook((getColor())).canMoveToPosition(chessBoard, line, column, toLine, toColumn);
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
