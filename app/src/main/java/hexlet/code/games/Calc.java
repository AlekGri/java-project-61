package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static final String QUESTION = "What is the result of the expression?";
    public static final int MAX_RANDOM_NUMBER = 100;
    public static void startCalc() {
        Engine.greeting(QUESTION);
        String[][] questionsAndAnswers = new String[Engine.MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int x = Engine.getRandom(1, MAX_RANDOM_NUMBER);
            int y = Engine.getRandom(1, MAX_RANDOM_NUMBER);
            String[] signs = {"+", "-", "*"};
            String sign = signs[Engine.getRandom(0, signs.length)];
            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = x + " " + sign + " " + y;
            //запись ответа
            int rightAnswer = calculate(x, y, sign);
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = String.valueOf(rightAnswer);
        }

        Engine.doRound(questionsAndAnswers);
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
