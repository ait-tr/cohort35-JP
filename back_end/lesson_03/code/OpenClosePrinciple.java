package lesson_03.code;

public class OpenClosePrinciple {

    public static void main(String[] args) {
    }

    public void nonOCP() {

        String[] cites = new String[5];

        cites[0] = "Berlin";
        cites[1] = "Madrid";
        cites[2] = "Paris";
        cites[3] = "Prague";
        cites[4] = "London";

        // searchCities(cities)

    }

    public boolean nonOCP2(int x, int y) {

        if ((x + y) > 10) {
            return true;
        } else {
            return false;
        }

    }


}
