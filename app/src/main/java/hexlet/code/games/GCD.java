package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Find the greatest common divisor of given numbers.";
    public static String userAnswer;
    public static int correctAnswer;
    public static void startGame() {
        Engine.greeting(QUESTION);

        int countAnswer = 0;
        while (true) {
            boolean roundResult = doRound();

            if (roundResult) {
                countAnswer += 1;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n" +
                        "Let's try again, " + Engine.userName + "!");
                break;
            }

            if (countAnswer >= MAX_RIGHT_ANSWERS) {
                System.out.println("Congratulations, " + Engine.userName  + "!");
                break;
            }
        }
    }

    public static boolean doRound() {
        int firstNum = Engine.getRandom(1, 100);
        int secondNum = Engine.getRandom(1, 100);

        while (firstNum == secondNum) {
            secondNum = Engine.getRandom(1, 100);
        }

        System.out.println("Question: " + firstNum + " " + secondNum);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        userAnswer = scanner.next();

        correctAnswer = getGCD(firstNum, secondNum);

        return userAnswer.equals(String.valueOf(correctAnswer));
    }

    public static int getGCD(int x, int y) {
        if (y > x) {
            int temp = y;
            y = x;
            x = temp;
        }

        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }
        return x;

    }
}
