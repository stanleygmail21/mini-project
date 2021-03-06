package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    public static final int SIZE = 7;
    List<Ship> ships;

    public Board(List<Ship> ships) {
        this.ships = ships;
    }

    public boolean isHit(Point2D p) {
        for (Ship s : ships)
            if (s.isHit(p))
                return true;
        return false;
    }

    private boolean canPlaceShipPart(Point2D part) {
        Point2D[] dirs = {
                new Point2D(0, 1),
                new Point2D(1, 1),
                new Point2D(1, 0),
                new Point2D(1, -1),
                new Point2D(0, -1),
                new Point2D(-1, -1),
                new Point2D(-1, 0),
                new Point2D(-1, 1),
        };
        for (Point2D dir: dirs)
            if (isHit(part.add(dir)))
                return false;
        return true;
    }

    public static Board random() {
        int[] sizes = { 4, 3, 2, 2, 1, 1 };
        Board b = new Board(new ArrayList<>());
        ThreadLocalRandom r = ThreadLocalRandom.current();
        for (int size: sizes) {
            while (true) {
                Point2D pos = new Point2D(r.nextInt(0, SIZE - 1), r.nextInt(0, SIZE - 1));
                Ship s = r.nextBoolean()
                        ? Ship.horizontal(pos, size) : Ship.vertical(pos, size);

                boolean isValid = true;
                for (Point2D part : s.getParts())
                    if (!b.canPlaceShipPart(part) || part.getX() >= SIZE || part.getY() >= SIZE) {
                        isValid = false;
                        break;
                    }
                if (isValid) {
                    b.ships.add(s);
                    break;
                }
            }
        }
        return b;
    }
}
