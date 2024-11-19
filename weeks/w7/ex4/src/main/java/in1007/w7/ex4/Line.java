package in1007.w7.ex4;

import in1007.w7.ex4.BreakableForEach.BreakableForEachExecutor;
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

    public void breakableForEach(BreakableForEachExecutor ex) {
        BreakableForEach bfe = new BreakableForEach();

        while (!bfe.isWillBreak()) {

            Point1D previousPos = new Point1D(0);

            for (int index = 0; index < squares.length; index++) {
                bfe.setStartingNewIteration(index == 0);

                Point1D currentPos = new Point1D(index);
                ex.execute(bfe, currentPos, previousPos);
                previousPos = currentPos;
            }

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

    public Line reverse() {
        Line line = new Line(this.squares.length);

        forEach((currentPos, previousPos) -> {
            Point1D point = (Point1D) currentPos;

            Point1D reversedPoint = new Point1D(this.squares.length - 1 - point.getPos());

            System.out.println(reversedPoint.getPos());
            line.setPosition(reversedPoint, this.getPosition(point));
        });

        return line;
    }

    public void tick() {
        // Common
        forEach((currentPos, previousPos) -> {
            // If we are at the first position, skip this one since we want to compare n and
            // n-1.
            if (currentPos.equals(previousPos))
                return;

            // Get squares
            Square current = this.getPosition(currentPos);
            Square previous = this.getPosition(previousPos);

            // Check to see if we have two identical numbers, ignoring if either is 0
            if (current.equals(previous) && current.getValue() != 0) {
                System.out.println("MATCH");

                // Add the two elements, placing the sum in the first square and zero in the
                // last.
                current.merge(previous); // update current to current+previous
                previous.reset(); // reset previous value to 0

                // Update squares
                this.setPosition(currentPos, current);
                this.setPosition(previousPos, previous);
            }
        });

        // Shift all non-zero elements to the right

        breakableForEach((bfe, currentPos, previousPos) -> {

            // Check if we should break, if so do nothing
            if (bfe.isWillBreak()) {
                return;
            }

            // Check if we are starting a new iteration
            if (bfe.isStartingNewIteration()) {

                // Check if we should break (hasSwapped == false)
                if (!bfe.isHasSwapped()) {
                    // No swaps made since last iteration, end here.
                    bfe.setWillBreak(true);
                    return;
                } else {
                    // (hasSwapped == true) we swapped last iteration, continue

                    // reset hasSwapped for this new iteration
                    bfe.setHasSwapped(false);
                }

                // Reset flag
                bfe.setStartingNewIteration(false);
            }

            // Check if we are comparing the first object against itself
            if (currentPos.equals(previousPos))
                return; // Skip this object since we compare n against n-1

            // We are at position > 0

            // Check if previous position is 0
            Square previous = this.getPosition(previousPos);
            Square current = this.getPosition(currentPos);

            if (previous.getValue() == 0 && current.getValue() != 0) {
                // Swap previous and current
                this.setPosition(previousPos, current);
                this.setPosition(currentPos, previous);

                bfe.setHasSwapped(true);
            }
        });
        System.out.println("\r\n\r\n");
    }
}