public class Pawn extends Piece {
    public Pawn(int x, int y, PawnColor color) {
        super(x, y, color);
    }

    @Override
    public boolean isValidMove(int newX, int newY) {
        int diffX = newX - x;
        int diffY = newY - y;

        if (color.equals(PawnColor.WHITE)) {
            if (diffX == 1 && diffY == 0) {
                return true;
            }
            if (x == 1 && diffX == 2 && diffY == 0) {
                return true;
            }
            if (diffX == 1 && Math.abs(diffY) == 1) {
                return true;
            }
        } else {
            if (diffX == -1 && diffY == 0) {
                return true;
            }
            if (x == 6 && diffX == -2 && diffY == 0) {
                return true;
            }
            if (diffX == -1 && Math.abs(diffY) == 1) {
                return true;
            }
        }
        return false;
    }



    @Override
    public String toString() {
        return "Pawn{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }
}
