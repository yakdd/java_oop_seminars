package PointMethod;

/**
 * Это точка 2D
 */

public class Point2D {
    private int x, y;

    /**
     * ДОКУМЕНТАЦИЯ:
     * Это конструктор ...
     * 
     * @param valueX - координата X
     * @param valueY - координата Y
     */
    public Point2D(int valueX, int valueY) {
        x = valueX;
        y = valueY;
    }

    public Point2D(int value) {
        this(value, value);
    }
    // старый вариант:
    // public Point2D(int value) {
    // x = value;
    // y = value;
    // }

    public Point2D() {
        this(0);
    }
    // старый вариант:
    // public Point2D() {
    // x = 0;
    // y = 0;
    // }

    public static double distance(Point2D a, Point2D b) {
        double distance = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
        return distance;
    }

    protected String getInfo() {
        return String.format("x: %d; y: %d", x, y);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int value) {
        this.x = value;
    }

    public void setY(int value) {
        this.y = value;
    }
}
