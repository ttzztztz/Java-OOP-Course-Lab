public class Circle extends Shape {
    private int radius;

    public Circle(int r) {
        this.radius = r;
    }

    @Override
    public double getArea() {
        final double pi = 3.1415926535898;
        return this.radius * this.radius * pi;
    }
}
