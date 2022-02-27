public class Point {
    private double x;
    private double y;

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(double x1, double y1, double x2, double y2) {
        double d = Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
        return Math.sqrt(d);
    }
}
