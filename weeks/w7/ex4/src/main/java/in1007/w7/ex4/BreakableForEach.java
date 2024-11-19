package in1007.w7.ex4;

import in1007.w7.ex4.position.Point;
import lombok.Getter;
import lombok.Setter;

public class BreakableForEach {
    private @Getter @Setter boolean willBreak = false;
    private @Getter @Setter boolean hasSwapped = true;
    private @Getter @Setter boolean startingNewIteration = false;

    public interface BreakableForEachExecutor {
        void execute(BreakableForEach instance, Point current, Point previous);
    }
}
