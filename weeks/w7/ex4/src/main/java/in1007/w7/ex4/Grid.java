package in1007.w7.ex4;

import in1007.w7.ex4.container.Container;
import in1007.w7.ex4.container.ForEachExecutor;
import in1007.w7.ex4.position.Axes;
import in1007.w7.ex4.position.Point;
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
}
