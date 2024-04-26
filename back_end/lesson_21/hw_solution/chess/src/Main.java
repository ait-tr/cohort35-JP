/**
 * @author Andrej Reutow
 * created on ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Pawn pawn = new Pawn(1, 2, PawnColor.WHITE);
        System.out.println(pawn);
        changePos(pawn);
        System.out.println(pawn);
    }

    private static void changePos(Pawn obj) {
        obj.setX(99);
        obj.setY(199);
    }
}
