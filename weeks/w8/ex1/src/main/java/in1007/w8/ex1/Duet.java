package in1007.w8.ex1;

import lombok.Getter;
import lombok.Setter;

public class Duet {
    private @Getter @Setter Singer singer1;
    private @Getter @Setter Singer singer2;

    public Duet(Singer singer1, Singer singer2) {
        this.singer1 = singer1;
        this.singer2 = singer2;
    }

    public boolean isBothProfessional() {
        return singer1.isProfessional() && singer2.isProfessional();
    }
}
