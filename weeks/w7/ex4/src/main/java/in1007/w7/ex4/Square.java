package in1007.w7.ex4;

import lombok.Getter;
import lombok.Setter;

public class Square {
    private @Getter @Setter int value = 0;

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
