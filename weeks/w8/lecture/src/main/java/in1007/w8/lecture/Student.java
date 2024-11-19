package in1007.w8.lecture;

import lombok.Setter;

import lombok.Getter;

public class Student {
    private @Getter @Setter int age;
    private int yearGroup;

    Student(int a, int b) {
        // this. is optional as constructor vars do not have conflicting names
        age = a;
        yearGroup = b;
    }
}
