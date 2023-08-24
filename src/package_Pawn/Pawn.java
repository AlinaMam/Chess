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

        //проверка взаимодействия с фигурами, если поле не null, то ходить на это поле нельзя
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            for (int i = startPosition; i < 7; i++) {
                for (int j = startPosition; j < 7; j++) {
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return false;
                    } else return true;
                }
            }
        }

        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) { //если нет выхода за пределы шахматной доски
            if (!(line == toLine && column == toColumn)) { //если пешка не сходила в то же самое поле на котором стоит
                if (chessBoard.board[toLine][toColumn] == null) { //если на поле нет никакой фигуры
                    if (column == toColumn && line == startPosition) { //если пешка ходит только по прямой и её позиция = старотовой позиции (т.е. выполняет 1ый ход)
                        return toLine == line + 2 * direction || toLine == line + direction; //выполняется проверка, что она может сходить на 2 клетки вперед или на одну
                    } else return toLine == line + direction; //иначе только на одну
                } else
                    return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()); //иначе должна выполниться проверка, что на клетке не стоит фигура её цвета
            } else return false; //иначе пешка не может сходить на то же самое поле
        } else return false; //иначе false, т.к. есть выход на пределы доски
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
