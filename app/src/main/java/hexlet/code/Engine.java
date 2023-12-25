package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    public static String getUserName() {
        return userName;
    }

    public static void greeting(String question) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(question);
    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}

