public class Bishop extends ChessPiece {
    public Bishop(String color) {
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
                if (Math.abs(line - toLine) == Math.abs(column - toColumn))
                    if(chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                        return false;
                    } else return true;
            } else return false;
        } else return false;
        return false;
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}
