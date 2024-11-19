package in1007.w4.lecture;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Age: ");
        int age = s.nextInt();

        System.out.println(age >= 18 ? "Adult" : "Underage");
        /**
         * Equal to:
         * 
         * if (age >= 18) {
         * System.out.println("Adult");
         * } else {
         * System.out.println("Underage");
         * }
         */
    }
}
