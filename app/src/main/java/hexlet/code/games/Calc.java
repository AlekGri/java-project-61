package hexlet.code.games;

import java.util.Scanner;

public class Calc {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static String userName;

    public static void startCalc() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("What is the result of the expression?");
        int countAnswer = 0;
        while (true) {
            int count = getRound();
            countAnswer += count;
            if (countAnswer >= MAX_RIGHT_ANSWERS) {
                System.out.println("Congratulations, " + userName  + "!");
                break;
            }
        }
        scanner.close();
    }

    public static int getRound() {
        int x = getRandom(1, 100);
        int y = getRandom(1, 100);
        String[] Signs = {"+", "-", "*"};
        String sign = Signs[getRandom(0, Signs.length)];
        System.out.println("Question: " + x + sign + y);

        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();

        int count = 0;
        int correctAnswer = calculate(x, y, sign);

        if (userAnswer.equals(String.valueOf(correctAnswer))) {
            count += 1;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n" +
                    "Let's try again, " + userName + "!");
        }

        return count;
    }

    public static int calculate (int x, int y, String sign) {
        return switch (sign) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            default -> throw new IllegalStateException("Unexpected value: " + sign);
        };
    }

    public static int getRandom (int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
