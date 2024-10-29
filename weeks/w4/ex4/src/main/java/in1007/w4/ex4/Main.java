package in1007.w4.ex4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Write a program which asks the user to enter a
 * month of the year (as a String) and displays
 * the corresponding number
 * (JANUARY=1, FEBRUARY=2,...).
 */

import java.util.Scanner;

public class Main {
    public static enum Day {
        NULL, JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    };

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Input month: ");
        String input = s.nextLine();

        Day d = Day.valueOf(input.toUpperCase());
        System.out.println(d.ordinal());
    }
}
