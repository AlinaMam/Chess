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
                       if(chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) return false;
                       else return true;
                    } else return false;
                } else return false;
            } else return false;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
