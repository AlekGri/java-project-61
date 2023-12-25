package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "What is the result of the expression?";
    public static String userAnswer;
    public static int correctAnswer;
    public static void startGame() {
        Engine.greeting(QUESTION);

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            boolean roundResult = doRound();

            if (roundResult) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n" +
                        "Let's try again, " + Engine.userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + Engine.userName  + "!");
    }

    public static boolean doRound() {
        int x = Engine.getRandom(1, 100);
        int y = Engine.getRandom(1, 100);
        String[] Signs = {"+", "-", "*"};
        String sign = Signs[Engine.getRandom(0, Signs.length)];
        System.out.println("Question: " + x + sign + y);

        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        userAnswer = scanner.next();

        correctAnswer = calculate(x, y, sign);

        return userAnswer.equals(String.valueOf(correctAnswer));
    }

    public static int calculate (int x, int y, String sign) {
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
