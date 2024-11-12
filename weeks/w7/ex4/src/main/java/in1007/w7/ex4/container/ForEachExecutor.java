package in1007.w7.ex4.container;

import in1007.w7.ex4.position.Point;

@FunctionalInterface
public interface ForEachExecutor {
    void execute(Point current, Point previous);
}