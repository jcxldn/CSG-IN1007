package in1007.w4.ex3;

/**
 * Write a program which asks the user to enter
 * an integer until this integer is negative.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int input = 0;

        while (input >= 0) {
            System.out.print("Enter integer: ");
            input = s.nextInt();
        }
    }
}
