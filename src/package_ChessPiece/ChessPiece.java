package package_ChessPiece;

import package_ChessBoard.ChessBoard;

public abstract class ChessPiece {
    protected String color;
    public boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();
}
