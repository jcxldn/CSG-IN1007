package in1007.w4.ex2;

/**
 * Write a program which asks the user to enter
 * a positive integer n and displays the sum 1+2+...+n.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter integer: ");
        int inp = s.nextInt();

        int total = 0;
        // eg inp = 3, iterate i: {1,2,3}
        for (int i = 1; i <= inp; i++) {
            total += i;
        }
        System.out.println(total);
    }
}
