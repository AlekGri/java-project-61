package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String userAnswer;
    public static String correctAnswer;
    public static final int MAX_RANDOM_NUMBER = 100;
    public static void startGame() {
        Engine.greeting(QUESTION);

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            boolean roundResult = doRound();

            if (roundResult) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + Engine.getUserName()  + "!");
    }

    private static boolean doRound() {
        int random = Engine.getRandom(1, MAX_RANDOM_NUMBER);
        System.out.println("Question: " + random);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        userAnswer = scanner.next();

        boolean isRandomPrime = isPrime(random);
        correctAnswer = "no";
        if (isRandomPrime) {
            correctAnswer = "yes";
        }

        return userAnswer.equals(correctAnswer);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i += 1) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
