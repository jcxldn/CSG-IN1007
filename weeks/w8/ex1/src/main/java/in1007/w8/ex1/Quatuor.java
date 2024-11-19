package in1007.w8.ex1;

import lombok.Getter;
import lombok.Setter;

public class Quatuor {
    private @Getter @Setter Duet duet1;
    private @Getter @Setter Duet duet2;

    public Quatuor(Duet duet1, Duet duet2) {
        this.duet1 = duet1;
        this.duet2 = duet2;
    }
}
