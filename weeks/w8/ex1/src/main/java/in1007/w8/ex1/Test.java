package in1007.w8.ex1;

public class Test {
    public static void main(String[] args) {
        Singer james = new Singer("James", 18);

        System.out.printf("Created new singer '%s'%s.\r\n", james.getName(), (james.isAdult() ? " (Adult)" : ""));

        // Step 5+ below

        Singer chris = new Singer("Chris", 34);
        Singer maria = new Singer("Maria", 30);

        Duet duet = new Duet(chris, maria);

        Singer louis = new Singer("Louis", 18);
        Singer aryan = new Singer("Aryan", 19);

        Duet duet2 = new Duet(louis, aryan);

        Quatuor quatuor = new Quatuor(duet, duet2);
    }
}
