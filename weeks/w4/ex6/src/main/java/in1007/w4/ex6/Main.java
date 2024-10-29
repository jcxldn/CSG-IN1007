package in1007.w4.ex6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("n: ");
        int numOfInts = s.nextInt();

        int[] values = new int[numOfInts];

        for (int i = 0; i < numOfInts; i++) {
            System.out.printf("int %o: ", i + 1); // 1 - numofInts inclusive
            values[i] = s.nextInt();
        }

        // if more than two ints... then
        for (int i = 0; i < numOfInts - 1; i++) {
            System.out.printf("%o %o", values[i], values[i] + 1);
            System.out.printf(i % 2 == 0 ? "minus" : "add");
            if (i % 2 == 0) {
                values[i + 1] = values[i] - values[i + 1];
            } else {
                values[i + 1] = values[i] + values[i + 1];
            }
        }

        System.out.println(values[numOfInts - 1]);
    }
}
