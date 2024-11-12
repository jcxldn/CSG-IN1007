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
    public boolean equals(Point otherPoint) {
        if (otherPoint instanceof Point2D) {
            Point2D other = (Point2D) otherPoint;
            return (this.getX() == other.getX() &&
                    this.getY() == other.getY());
        } else {
            return false;
        }
    }

    public boolean equals(Axes a, Point otherPoint) {
        if (otherPoint instanceof Point2D) {
            Point2D other = (Point2D) otherPoint;

            switch (a) {
                case X:
                    return this.getX() == other.getX();
                case Y:
                    return this.getY() == other.getY();
            }
        }

        return false;
    }
}
