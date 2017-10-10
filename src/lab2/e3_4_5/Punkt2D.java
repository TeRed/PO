package lab2.e3_4_5;

public class Punkt2D {
    protected double x;
    protected double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    Punkt2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Punkt2D point) {
        return Math.sqrt((x-point.x)*(x-point.x) + (y-point.y)*(y-point.y));
    }
}
