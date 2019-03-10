package foo.bar;

public class Triangle implements Figure {
    private int a;
    private int h;

    public Triangle(int a) {
        this.a = a;

    }

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public int area() {
        return (a / 2) * h;
    }

    //todo zrobić faktyczny wzór na obwód
    @Override
    public int circumference() {
        return 3 * a;
    }
}
