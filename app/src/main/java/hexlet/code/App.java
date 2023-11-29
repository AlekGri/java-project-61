package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "0 - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String startChoice = scanner.next();
        System.out.println("");

        switch (startChoice) {
            case "0":
                System.out.println("Exiting game now. Hope you had fun)");
                break;
            case "1":
                Cli.getName();
                break;
            case "2":
                Even.startEven();
                break;
        }
        scanner.close();
    }
}
