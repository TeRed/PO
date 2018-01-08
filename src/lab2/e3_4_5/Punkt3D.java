package lab2.e3_4_5;

public class Punkt3D extends Punkt2D {
    protected double z;

    public Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Punkt3D point) {
        return Math.sqrt((super.x-point.x)*(x-point.x) + (y-point.y)*(y-point.y) + (z-point.z)*(z-point.z));
    }

    @Override
    public String toString() {
        return "Punkt3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
