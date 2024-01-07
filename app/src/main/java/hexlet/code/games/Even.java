package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;
public class Even {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static String rightAnswer;
    public static final int MAX_RANDOM_NUMBER = 100;
    private static String[][] questionsAndAnswers = new String[MAX_RIGHT_ANSWERS][2];

    public static void startEven() {
        Engine.greeting(QUESTION);

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int random = Engine.getRandom(1, MAX_RANDOM_NUMBER);
            questionsAndAnswers[i][0] = String.valueOf(random);
            questionsAndAnswers[i][1] = (isEven(random)) ? "yes" : "no";
        }

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.next();

            if (userAnswer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + questionsAndAnswers[i][1] + "'");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + Engine.getUserName()  + "!");
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
