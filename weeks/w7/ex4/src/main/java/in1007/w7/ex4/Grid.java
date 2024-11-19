package in1007.w7.ex4;

import java.util.ArrayList;

import in1007.w7.ex4.container.Container;
import in1007.w7.ex4.container.ForEachExecutor;
import in1007.w7.ex4.position.Axes;
import in1007.w7.ex4.position.Point;
import in1007.w7.ex4.position.Point1D;
import in1007.w7.ex4.position.Point2D;

public class Grid implements Container {
    private int sizeX, sizeY;

    public Square[][] squares;

    public Grid(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;

        this.squares = new Square[y][x];
        forEach((currentPos, previousPos) -> {
            setPosition(currentPos, new Square());
        });

    }

    @Override
    public void forEach(ForEachExecutor ex) {
        Point2D previousPos = new Point2D(0, 0);

        for (int y = 0; y < this.sizeY; y++) {
            for (int x = 0; x < this.sizeX; x++) {
                Point2D currentPos = new Point2D(x, y);
                ex.execute(currentPos, previousPos);
                previousPos = currentPos;
            }
        }
    }

    @Override
    public Square getPosition(Point point) {
        if (point instanceof Point2D) {
            Point2D p = (Point2D) point;
            return this.squares[p.getY()][p.getX()];
        } else {
            return null;
        }
    }

    @Override
    public void setPosition(Point point, Square square) {
        if (point instanceof Point2D) {
            Point2D p = (Point2D) point;
            this.squares[p.getY()][p.getX()] = square;
        }
    } // TODO: error handling

    public String toString() {
        StringBuilder sb = new StringBuilder();
        forEach((currentPos, previousPos) -> {
            Point2D currentPos2d = (Point2D) currentPos;

            if (!currentPos2d.equals(Axes.Y, previousPos)) {
                sb.append("\r\n");
            }
            sb.append(this.getPosition(currentPos));
        });
        return sb.toString();
    }

    // get row
    public Line getY(int y) {
        Line line = new Line(this.sizeX);

        line.forEach((currentPos, previousPos) -> {
            // Get the point along the line
            Point1D point = (Point1D) currentPos;

            // Use the point1d along the line (x) and the given y to fetch the square
            Point2D gridPoint = new Point2D(point.getPos(), y);
            Square square = this.getPosition(gridPoint);

            line.setPosition(point, square);
        });

        return line;
    }

    // get column
    public Line getX(int x) {
        Line line = new Line(this.sizeY);

        line.forEach((currentPos, previousPos) -> {
            // Get the point along the line
            Point1D point = (Point1D) currentPos;

            // Use the point1d along the line (y) and the given x to fetch the square
            Point2D gridPoint = new Point2D(x, point.getPos());
            Square square = this.getPosition(gridPoint);

            line.setPosition(point, square);
        });

        return line;
    }

    public void setY(Line line, int x) {
        line.forEach((currentPoint, previousPoint) -> {
            Point1D currentPoint1D = (Point1D) currentPoint;

            Point2D destinationPoint = new Point2D(x, currentPoint1D.getPos());
            this.setPosition(destinationPoint, line.getPosition(currentPoint));
        });
    }

    public void setX(Line line, int y) {
        line.forEach((currentPoint, previousPoint) -> {
            Point1D currentPoint1D = (Point1D) currentPoint;

            Point2D destinationPoint = new Point2D(currentPoint1D.getPos(), y);
            this.setPosition(destinationPoint, line.getPosition(currentPoint));
        });
    }

    public void tick(Direction d) {
        switch (d) {
            case UP:
                tickUp();
                break;
            case DOWN:
                tickDown();
                break;
            case LEFT:
                tickLeft();
                break;
            case RIGHT:
                tickRight();
                break;

        }

        // Finally, add number 2 to random square (that previously contained 0)
        randomlyAddTwo();
    }

    public void tickLeft() {
        // Update all rows in grid
        for (int y = 0; y < this.sizeY; y++) {
            Line line = this.getY(y);
            line.tick();
            this.setY(line, y);
        }
    }

    public void tickRight() {
        // Reverse, update, then reverse all rows in grid
        for (int y = 0; y < this.sizeY; y++) {
            Line line = this.getY(y);
            line = line.reverse();
            line.tick();
            line = line.reverse();
            this.setY(line, y);
        }
    }

    public void tickUp() {
        // Update all columns in grid (top to bottom)
        for (int x = 0; x < this.sizeX; x++) {
            Line line = this.getX(x);
            line.tick();
            this.setY(line, x);
        }
    }

    public void tickDown() {
        // Reverse, update, then reverse all columns in grid (top to bottom)
        for (int x = 0; x < this.sizeX; x++) {
            Line line = this.getX(x);
            line = line.reverse();
            line.tick();
            line = line.reverse();
            this.setY(line, x);
        }
    }

    public void randomlyAddTwo() {
        ArrayList<Point2D> emptyPoints = new ArrayList<Point2D>();

        forEach((currentPoint, previousPoint) -> {
            Point2D currentPoint2D = (Point2D) currentPoint;
            if (getPosition(currentPoint2D).getValue() == 0) {
                emptyPoints.add(currentPoint2D);
            }
        });

        // ArrayList populated, get a random index from the arraylist
        // based on moodle notes
        int randomIndex = (int) (Math.random() * emptyPoints.size() + 1);

        Square square = new Square();
        square.setValue(2);

        setPosition(emptyPoints.get(randomIndex), square);
    }
}
