package in1007.w7.ex4;

import lombok.Getter;
import lombok.Setter;

public class Square implements Cloneable {
    private @Getter @Setter int value = 0;

    public Object clone() throws CloneNotSupportedException {
        // Shallow copy is fine since we do not have
        // instances of classes as parameters (only primitives like int)
        Square cloned = (Square) super.clone();

        // Return the cloned object
        return cloned;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean equals(Square other) {
        return getValue() == other.getValue();
    }

    public void merge(Square other) {
        this.value += other.getValue();
    }

    public void reset() {
        this.setValue(0);
    }

}
