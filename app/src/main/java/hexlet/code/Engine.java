package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    public static String getUserName() {
        return userName;
    }
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final int MAX_RANDOM_NUMBER = 100;

    public static final int QUESTIONS_ROW = 0;
    public static final int ANSWERS_ROW = 1;

    public static void doRound(String question, String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(question);

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][QUESTIONS_ROW]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(questionsAndAnswers[i][ANSWERS_ROW])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + questionsAndAnswers[i][ANSWERS_ROW] + "'");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                return;
            }
        }
        scanner.close();
        System.out.println("Congratulations, " + Engine.getUserName()  + "!");
    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}

