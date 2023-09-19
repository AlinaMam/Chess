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
            if (chessBoard.board[toLine][toColumn] == null) {
                return (line == toLine && toColumn == column + 1
                        || line == toLine && toColumn == column - 1
                        || column == toColumn && toLine == line + 1
                        || column == toColumn && toLine == line - 1
                        || toColumn == column + 1 && toLine == line + 1
                        || toColumn == column + 1 && toLine == line - 1
                        || toColumn == column - 1 && toLine == line + 1
                        || toColumn == column - 1 && toLine == line - 1);
            } else return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
        }
        return true;
    }

        public boolean isUnderAttack (ChessBoard chessBoard,int line, int column){
            boolean isUnderAttack = false;

            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
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
        public String getSymbol () {
            return "K";
        }
    }
