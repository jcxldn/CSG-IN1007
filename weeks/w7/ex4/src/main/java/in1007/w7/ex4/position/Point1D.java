package in1007.w7.ex4.position;

import lombok.Getter;

public class Point1D extends Point {
    private @Getter int pos;

    public Point1D(int pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Class<? extends Point> otherPoint) {
        if (otherPoint.isInstance(Point1D.class)) {
            Point1D other = Point1D.class.cast(otherPoint);
            return this.getPos() == other.getPos();
        } else {
            return false;
        }
    }
}