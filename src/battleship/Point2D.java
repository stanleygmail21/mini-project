package battleship;

public class Point2D {
    private int x, y;

    public Point2D(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point2D && x == ((Point2D) o).x && y == ((Point2D) o).y;
    }

    public Point2D add(Point2D o) {
        return new Point2D(x + o.x, y + o.y);
    }
}
