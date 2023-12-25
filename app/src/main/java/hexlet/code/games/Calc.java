package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "What is the result of the expression?";
    private static String userAnswer;
    private static int rightAnswer;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static void startCalc() {
        Engine.greeting(QUESTION);

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            boolean roundResult = doRound();

            if (roundResult) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + rightAnswer + "'");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + Engine.getUserName()  + "!");
    }

    public static boolean doRound() {
        int x = Engine.getRandom(1, MAX_RANDOM_NUMBER);
        int y = Engine.getRandom(1, MAX_RANDOM_NUMBER);
        String[] signs = {"+", "-", "*"};
        String sign = signs[Engine.getRandom(0, signs.length)];
        System.out.println("Question: " + x + " " + sign + " " + y);

        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        userAnswer = scanner.next();

        rightAnswer = calculate(x, y, sign);

        return userAnswer.equals(String.valueOf(rightAnswer));
    }

    public static int calculate(int x, int y, String sign) {
        switch (sign) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                throw new RuntimeException("Unknown symbol");
        }
    }
}
