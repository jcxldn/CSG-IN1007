package in1007.w7.ex4;

import in1007.w7.ex4.container.Container;
import in1007.w7.ex4.container.ForEachExecutor;
import in1007.w7.ex4.position.Point;
import in1007.w7.ex4.position.Point1D;

public class Line implements Container {
    public Square[] squares;

    public Line(int size) {
        this.squares = new Square[size];

        forEach((current, previous) -> {
            setPosition(current, new Square());
        });

    }

    @Override
    public void forEach(ForEachExecutor ex) {
        Point1D previousPos = new Point1D(0);

        for (int index = 0; index < squares.length; index++) {
            Point1D currentPos = new Point1D(index);
            ex.execute(currentPos, previousPos);
            previousPos = currentPos;
        }

    }

    @Override
    public Square getPosition(Point point) {
        if (point instanceof Point1D) {
            Point1D p = (Point1D) point;
            return this.squares[p.getPos()];
        } else {
            return null;
        }
    }

    @Override
    public void setPosition(Point point, Square square) {
        if (point instanceof Point1D) {
            Point1D p = (Point1D) point;
            this.squares[p.getPos()] = square;
        } // TODO: error handling
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        forEach((current, previous) -> {
            sb.append(this.getPosition(current));
        });
        return sb.toString();
    }
}