package in1007.w4.ex1;

/**
 * Write a program which asks the user to enter two
 * integers and display "greater" if the first one is
 * greater than the second one and "smaller or equal"
 * otherwise. 
 */

import java.util.Scanner;

public class Main {
    static Scanner s;

    public static void main(String[] args) {
        s = new Scanner(System.in);

        int one = inputInt();
        int two = inputInt();

        System.out.println(one > two ? "greater" : "smaller");
    }

    public static Integer inputInt() {
        System.out.print("Enter integer: ");
        return s.nextInt();

    }
}
