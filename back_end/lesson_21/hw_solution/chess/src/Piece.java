/**
 * @author Andrej Reutow
 * created on 14.03.2023
 */
public abstract class Piece {
    protected int x;
    protected int y;
    protected PawnColor color;

    public Piece(int x, int y, PawnColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(PawnColor color) {
        this.color = color;
    }

    public abstract boolean isValidMove(int newX, int newY);
}
