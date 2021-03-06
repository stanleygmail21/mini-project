package battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Point2D> parts;

    private Ship(Point2D pos, Point2D dir, int length) {
        parts = new ArrayList<>();
        for (int i = 1; i <= length; i++)
            parts.add(new Point2D(
                    pos.getX() + dir.getX() * i,
                    pos.getY() + dir.getY() * i));
    }

    public static Ship horizontal(Point2D pos, int length) {
        return new Ship(pos, new Point2D(1, 0), length);
    }

    public static Ship vertical(Point2D pos, int length) {
        return new Ship(pos, new Point2D(0, 1), length);
    }

    public int getLength() {
        return parts.size();
    }

    public List<Point2D> getParts() {
        return parts;
    }

    public boolean isHit(Point2D p) {
        for (Point2D part: parts)
            if (part.equals(p))
                return true;
        return false;
    }
}
