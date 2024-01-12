package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static final String QUESTION = "What is the result of the expression?";
    public static void startCalc() {
        String[][] questionsAndAnswers = new String[Engine.MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int x = Util.getRandom(1, Engine.MAX_RANDOM_NUMBER);
            int y = Util.getRandom(1, Engine.MAX_RANDOM_NUMBER);
            String[] signs = {"+", "-", "*"};
            String sign = signs[Util.getRandom(0, signs.length)];
            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = x + " " + sign + " " + y;
            int rightAnswer = calculate(x, y, sign);
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = String.valueOf(rightAnswer);
        }

        Engine.doRound(QUESTION, questionsAndAnswers);
    }

    public static int calculate(int x, int y, String sign) {
        switch (sign) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                throw new RuntimeException("Unknown symbol");
        }
    }
}
