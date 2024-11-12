package in1007.w7.ex4.position;

import lombok.Getter;

public class Point2D extends Point {
    private @Getter int x;
    private @Getter int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Class<? extends Point> otherPoint) {
        if (otherPoint.isInstance(Point2D.class)) {
            Point2D other = Point2D.class.cast(otherPoint);
            return (this.getX() == other.getX() &&
                    this.getY() == other.getY());
        } else {
            return false;
        }
    }
}
