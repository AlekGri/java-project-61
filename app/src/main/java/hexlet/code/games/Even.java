package hexlet.code.games;

import hexlet.code.Engine;
public class Even {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static final String QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startEven() {
        Engine.greeting(QUESTION);
        String[][] questionsAndAnswers = new String[MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < MAX_RIGHT_ANSWERS; i++) {
            int random = Engine.getRandom(1, MAX_RANDOM_NUMBER);
            questionsAndAnswers[i][0] = String.valueOf(random);
            questionsAndAnswers[i][1] = (isEven(random)) ? "yes" : "no";
        }

        Engine.doRound(questionsAndAnswers);
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
