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
            if (!(line == toLine && column == toColumn)) {
                if ((chessBoard.checkPos(Math.abs(line - toLine)) && Math.abs(column - toColumn) == 0) || (chessBoard.checkPos(Math.abs(column - toColumn)) && Math.abs(line - toLine) == 0) ||
                        (Math.abs(line - toLine) == Math.abs(column - toColumn))) {
                        if(chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                            return false;
                        } else return true;
                } else return false;
            } else return false;
        } else return false;
    }
    @Override
    public String getSymbol () {
        return "Q";
    }
}
