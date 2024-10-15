package in1007.w3.ex6;

import java.util.Arrays;
import java.util.Scanner;

public class Ordered {
    public static boolean isArrayOrdered(int[] arr) {
        // 1. create a 'shallow' copy of the array
        int[] clone = arr.clone();

        // Sort the clone
        Arrays.sort(clone);

        // compare the clone against the original **by checking contents**
        // (https://stackoverflow.com/a/36706143)
        // 'arr.equals(clone)' or 'arr == clone' checks to see if they
        // point to the same reference.
        boolean sorted = Arrays.equals(arr, clone);

        // Return the result
        return sorted;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = new int[3];

        for (int i = 0; i < ints.length; i++) {
            System.out.print(String.format("integer (no %d of %d): ", i + 1, ints.length));
            ints[i] = sc.nextInt();
        }

        System.out.println(String.format(isArrayOrdered(ints) ? "true" : "false"));
    }
}
