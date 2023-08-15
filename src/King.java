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
                    if(chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                        return false;
                    } else return true;
                } else return false;
            } else return false;
        } else return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                } else return false;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
