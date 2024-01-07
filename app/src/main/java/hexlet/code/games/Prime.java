package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static final String QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void startPrime() {
        Engine.greeting(QUESTION);
        String[][] questionsAndAnswers = new String[Engine.MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int random = Engine.getRandom(1, Engine.MAX_RANDOM_NUMBER);
            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = String.valueOf(random);
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = (isPrime(random)) ? "yes" : "no";
        }

        Engine.doRound(questionsAndAnswers);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i += 1) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
