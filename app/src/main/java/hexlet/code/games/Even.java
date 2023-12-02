package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Even {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startEven() {
        Engine.greeting(QUESTION);

        int countAnswer = 0;
        while (true) {
            int count = getRound();
            countAnswer += count;
            if (countAnswer >= MAX_RIGHT_ANSWERS) {
                System.out.println("Congratulations, " + Engine.userName  + "!");
                break;
            }
        }
    }

    public static int getRound() {
        int count = 0;
        int random = getRandom(1, 100);
        System.out.println("Question: " + random);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();
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

    public static int getRandom (int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }

    public static boolean isEven (int num) {
        return num % 2 == 0;
    }
}