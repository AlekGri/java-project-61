package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Even {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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

    public static int doRound() {
        int random = Engine.getRandom(1, 100);
        System.out.println("Question: " + random);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();

        int count = 0;
        boolean isRandomEven = isEven(random);
        String correctAnswer = "no";
        if (isRandomEven) {
            correctAnswer = "yes";
        }

        if ((userAnswer.equals("yes") && isRandomEven) || (userAnswer.equals("no") && !isRandomEven)) {
            count += 1;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n" +
                    "Let's try again, " + Engine.userName + "!");
        }
        return count;
    }

    public static boolean isEven (int num) {
        return num % 2 == 0;
    }
}