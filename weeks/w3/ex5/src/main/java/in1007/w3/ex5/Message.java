package in1007.w3.ex5;

import java.util.Scanner;

public class Message {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String taName, studentName;

        System.out.print("TA Name: ");
        taName = sc.next();

        System.out.print("Student Name: ");
        studentName = sc.next();

        System.out.println(
                String.format(
                        "Dear %s,\nI enjoy your tutorials, they are awesome!\n%s.",
                        taName,
                        studentName));
    }
}
