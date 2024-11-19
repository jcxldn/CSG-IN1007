package in1007.w8.lecture;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(18, 1);
        Student s2 = new Student(21, 3);

        Classroom in1007 = new Classroom(450, s2);

        System.out.println("dbg");
    }
}
