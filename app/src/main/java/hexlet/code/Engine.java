package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static String userName;
    public static String getUserName() {
        return userName;
    }
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static void greeting(String question) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(question);
    }

    public static void doRound(String[][] questionsAndAnswers) {
        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.next();

            if (userAnswer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                        "Correct answer was '" + questionsAndAnswers[i][1] + "'");
                System.out.println("Let's try again, " + Engine.getUserName() + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + Engine.getUserName()  + "!");
    }

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}

