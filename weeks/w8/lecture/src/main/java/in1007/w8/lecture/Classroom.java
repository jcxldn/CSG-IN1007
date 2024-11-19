package in1007.w8.lecture;

public class Classroom {
    private int size;
    private Student rep;

    Classroom(int size, Student rep) {
        this.size = size;
        this.rep = rep;
    }

    public int getRepAge() {
        return this.rep.getAge();
    }

    public void setRepAge(int age) {
        this.rep.setAge(age);
    }
}
