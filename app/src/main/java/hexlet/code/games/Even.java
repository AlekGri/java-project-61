package hexlet.code.games;

import hexlet.code.Engine;
public class Even {
    public static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startEven() {
        Engine.greeting(QUESTION);
        String[][] questionsAndAnswers = new String[Engine.MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int random = Engine.getRandom(1, Engine.MAX_RANDOM_NUMBER);
            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = String.valueOf(random);
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = (isEven(random)) ? "yes" : "no";
        }

        Engine.doRound(questionsAndAnswers);
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
