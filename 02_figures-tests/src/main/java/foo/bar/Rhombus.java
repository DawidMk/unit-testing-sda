package foo.bar;

public class Rhombus implements Figure {
    int a;
    int h;

    public Rhombus(int a) {
        this.a = a;
    }
    public Rhombus(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public int area() {
        return a * h;
    }

    @Override
    public int circumference() {
        return 4 * a;
    }
}
