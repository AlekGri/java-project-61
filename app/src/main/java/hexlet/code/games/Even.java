package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Even {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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

    public static boolean doRound() {
        int random = Engine.getRandom(1, MAX_RANDOM_NUMBER);
        System.out.println("Question: " + random);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        userAnswer = scanner.next();

        boolean isRandomEven = isEven(random);
        correctAnswer = "no";
        if (isRandomEven) {
            correctAnswer = "yes";
        }

        return userAnswer.equals(correctAnswer);
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
