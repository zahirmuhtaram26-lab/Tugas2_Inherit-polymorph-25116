package soal3;

public class Titik {
    private double x;
    private double y;

    // Constructor kosong
    public Titik() {
        this(0, 0);
    }

    // Constructor dengan koordinat
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

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

    public double jarakKe(Titik lain) {
        double dx = this.x - lain.x;
        double dy = this.y - lain.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}