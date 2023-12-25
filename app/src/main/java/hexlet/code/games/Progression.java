package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "What number is missing in the progression?";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 14;
    public static final int MIN_STEP = 2;
    public static final int MAX_STEP = 10;
    public static final int MIN_START_NUMBER = 1;
    public static final int MAX_START_NUMBER = 20;
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
        int startNumber = Engine.getRandom(MIN_START_NUMBER, MAX_START_NUMBER);
        int progressionLength = Engine.getRandom(MIN_LENGTH, MAX_LENGTH);
        int step = Engine.getRandom(MIN_STEP, MAX_STEP);
        int[] progression = getProgression(startNumber, progressionLength, step);

        int indexToHide = Engine.getRandom(0, progressionLength - 1);

        var question = new StringBuilder();
        question.append("Question: ");
        for (int i = 0; i < progressionLength; i++) {
            if (i == indexToHide) {
                question.append(".. ");
            } else {
                question.append(progression[i]);
                question.append(" ");
            }
        }
        System.out.println(question);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        userAnswer = scanner.next();

        correctAnswer = progression[indexToHide];

        return userAnswer.equals(String.valueOf(correctAnswer));

    }

    public static int[] getProgression (int startNumber, int progressionLength, int step) {
        int[] progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + (i * step);
        }

        return progression;
    }
}
