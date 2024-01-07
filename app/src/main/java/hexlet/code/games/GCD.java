package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static final String QUESTION = "Find the greatest common divisor of given numbers.";
    public static void startGCD() {
        String[][] questionsAndAnswers = new String[Engine.MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int firstNum = Engine.getRandom(1, Engine.MAX_RANDOM_NUMBER);
            int secondNum = Engine.getRandom(1, Engine.MAX_RANDOM_NUMBER);

            while (firstNum == secondNum) {
                secondNum = Engine.getRandom(1, Engine.MAX_RANDOM_NUMBER);
            }
            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = firstNum + " " + secondNum;
            int rightAnswer = getGCD(firstNum, secondNum);
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = String.valueOf(rightAnswer);
        }
        Engine.doRound(QUESTION, questionsAndAnswers);
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
