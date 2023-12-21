package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Prime {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        Engine.greeting(QUESTION);

        int countAnswer = 0;
        while (true) {
            int count = doRound();
            countAnswer += count;
            if (countAnswer >= MAX_RIGHT_ANSWERS) {
                System.out.println("Congratulations, " + Engine.userName  + "!");
                break;
            }
        }
    }

    private static int doRound() {
        int random = Engine.getRandom(1, 100);
        System.out.println("Question: " + random);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();

        int count = 0;
        boolean isRandomPrime = isPrime(random);
        String correctAnswer = "no";
        if (isRandomPrime) {
            correctAnswer = "yes";
        }

        if ((userAnswer.equals("yes") && isRandomPrime) || (userAnswer.equals("no") && !isRandomPrime)) {
            count += 1;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n" +
                    "Let's try again, " + Engine.userName + "!");
        }
        return count;
    }

    public static boolean isPrime (int num) {
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
