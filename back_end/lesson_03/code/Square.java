package lesson_03.code;

public class Square extends Rectangle{
    public Square(int width) {
        super(width, width);
    }

    @Override
    public int area() {
        return width * width;
    }
}
