package net.jcxldn.csg.in1007.w3.ex2;

import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        int currentYear, birthYear;
        Scanner sc = new Scanner(System.in);

        System.out.println("What is the current year?");
        currentYear = sc.nextInt();

        System.out.println("What is your birth year?");
        birthYear = sc.nextInt();

        System.out.println(
                String.format(
                        "Assuming you have had your birthday this year, you are %d years old.",
                        currentYear - birthYear));

    }
}
