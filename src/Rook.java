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
                if (column == toColumn || line == toLine) {
                    if(chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) return false;
                } else return false;
            } else return false;
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
