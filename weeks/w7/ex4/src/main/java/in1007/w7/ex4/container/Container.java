package in1007.w7.ex4.container;

import in1007.w7.ex4.Square;
import in1007.w7.ex4.position.Point;

public interface Container {
    // Iterable
    public void forEach(ForEachExecutor ex);

    // Square
    public Square getPosition(Point p);

    public void setPosition(Point p, Square s);

    public String toString();
}