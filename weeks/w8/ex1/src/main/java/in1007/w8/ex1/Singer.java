package in1007.w8.ex1;

import lombok.Getter;

public class Singer {
    private @Getter String name;
    private @Getter int age;
    private @Getter boolean professional;

    public Singer(String name, int age) {
        this.name = name;
        this.age = age;
        this.professional = true;
    }

    private void setAge(int age) {
        if (age >= this.age)
            this.age = age;
    }

    public void reverseProfessional() {
        this.professional = !this.professional; // flip the boolean
    }

    public boolean isAdult() {
        return this.age >= 18;
    }
}
