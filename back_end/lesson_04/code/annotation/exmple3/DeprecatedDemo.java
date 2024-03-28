package lesson_04.code.annotation.exmple3;

public class DeprecatedDemo {
    @SuppressWarnings("deprecation")
    @Deprecated(since = "4.5", forRemoval = true)
    public void testLegacyFunction() {
        System.out.println("This is legacy function");
    }
}
