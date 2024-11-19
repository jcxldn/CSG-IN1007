package in1007.w7.ex4;

public class Main {
    public static void main(String[] args) {
        System.out.println("HI");

        Grid grid = new Grid(5, 10);
        System.out.println(grid);
        grid.tick(Direction.DOWN);
        System.out.println("\r\n");
        System.out.println(grid);

    }
}
