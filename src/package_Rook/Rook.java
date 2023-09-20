package package_Rook;

import package_ChessBoard.ChessBoard;
import package_ChessPiece.ChessPiece;

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
            if ((line != toLine && column == toColumn) || (column != toColumn && line == toLine)) {
                int firstPoint;
                int secondPoint;
                if (toLine == line) {
                    firstPoint = column;
                    secondPoint = toColumn;
                } else {
                    firstPoint = line;
                    secondPoint = toLine;
                }
                for (int i = 0; i <= 7; i++) {
                    if (secondPoint > firstPoint) {
                        firstPoint += 1;
                    } else firstPoint -= 1;
                    if (firstPoint == secondPoint) {
                        break;
                    }
                    if (toLine != line && chessBoard.board[firstPoint][column] != null) {
                        return false;
                    } else if (toColumn != column && chessBoard.board[line][firstPoint] != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
