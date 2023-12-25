package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        String startChoice = scanner.next();
        System.out.println();

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
            case "3":
                Calc.startCalc();
                break;
            case "4":
                GCD.startGCD();
                break;
            case "5":
                Progression.startProgression();
                break;
            case "6":
                Prime.startPrime();
                break;
            default:
                System.out.println("Error: Not a valid game number");
                break;
        }
        scanner.close();
    }
}
