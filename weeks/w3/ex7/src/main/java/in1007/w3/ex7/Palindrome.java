package in1007.w3.ex7;

import java.util.Scanner;

public class Palindrome {
    // Overriden arguments to convert string to int
    public static boolean isFullPalindrome(String text) {
        char[] chars = text.toCharArray();

        int[] values = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            values[i] = (int) chars[i];
        }

        return isFullPalindrome(values);
    }

    public static boolean isFullPalindrome(int[] values) {
        // div no remainder? (5/2 == 2 for example??)
        int middleIndex = values.length / 2;

        // 12 *3* 456, middle index 3
        for (int i = 0; i <= middleIndex; i++) {
            if (values[i] != values[values.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isFullPalindrome("abcba"));
        /*
         * System.out.println("Input an int:");
         * 
         * Scanner sc = new Scanner(System.in);
         * Integer input = sc.nextInt();
         * System.out.println(input);
         * Boolean ans = isFullPalindrome(("" + input));
         * System.out.println(ans);
         */

    }
}
