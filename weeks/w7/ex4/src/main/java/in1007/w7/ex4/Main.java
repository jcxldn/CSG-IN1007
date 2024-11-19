package in1007.w7.ex4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("HI");

        Scanner scanner = new Scanner(System.in);

        Grid grid = new Grid(5, 10);

        Pattern inputKeys = Pattern.compile("[wasd]");

        while (grid.isGameActive()) {
            // Clear screen
            // https://www.javatpoint.com/how-to-clear-screen-in-java#Platform-Specific-Command
            // System.out.print("\033[H\033[2J");
            // System.out.flush();

            // Display grid (Grid has a toString method that returns a String array
            // representation so calling println on the instance will work)
            System.out.println(grid);

            // Take user input
            String key = scanner.next(inputKeys);

            switch (key) {
                case "w":
                    grid.tick(Direction.UP);
                    break;
                case "a":
                    grid.tick(Direction.LEFT);
                    break;
                case "s":
                    grid.tick(Direction.DOWN);
                    break;
                case "d":
                    grid.tick(Direction.RIGHT);
                    break;
            }

        }

        scanner.close();
    }
}
