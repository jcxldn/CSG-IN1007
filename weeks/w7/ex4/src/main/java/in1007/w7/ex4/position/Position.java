package in1007.w7.ex4.position;

import lombok.Getter;

public class Position {
    private @Getter int x;
    private @Getter int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        // null x,y
    };

    public boolean equals(Position other) {
        return equals(Axes.X, other) && equals(Axes.Y, other);
    }

    public boolean equals(Axes a, Position other) {
        switch (a) {
            case Axes.X:
                return x == other.x;
            case Axes.Y:
                return y == other.y;
            // jank
            default:
                return false;
        }
    }

    public String toString() {
        return String.format("Position<[%d, %d]>", x, y);
    }

    public int getLinePosition(Position max) {
        return x + (y * max.getX());
    }

    /**
     * Returns true if self position is before other position
     * 
     * @param other
     * @param max
     * @return {@link Boolean}
     */
    public boolean isPlacedBefore(Position other, Position max) {

        // [0, 2] on 5x(n) grid -> position 10 (y*5)
        // [0, 0] -> 0
        // [0, 1] -> 5
        int currentLinePos = getLinePosition(max);
        int otherLinePos = other.getLinePosition(max);
        return currentLinePos < otherLinePos;
    }

    /**
     * Returns true if self position is after other position
     * 
     * @param other
     * @param max
     * @return {@link Boolean}
     */
    public boolean isPlacedAfter(Position other, Position max) {

        // [0, 2] on 5x(n) grid -> position 10 (y*5)
        // [0, 0] -> 0
        // [0, 1] -> 5
        int currentLinePos = getLinePosition(max);
        int otherLinePos = other.getLinePosition(max);
        return currentLinePos > otherLinePos;
    }
}
