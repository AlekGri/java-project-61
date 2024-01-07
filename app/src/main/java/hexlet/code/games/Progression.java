package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static final String QUESTION = "What number is missing in the progression?";
    public static final int MIN_LENGTH = 5;
    public static final int MAX_LENGTH = 14;
    public static final int MIN_STEP = 2;
    public static final int MAX_STEP = 10;
    public static final int MIN_START_NUMBER = 1;
    public static final int MAX_START_NUMBER = 20;
    public static void startProgression() {
        String[][] questionsAndAnswers = new String[Engine.MAX_RIGHT_ANSWERS][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int startNumber = Engine.getRandom(MIN_START_NUMBER, MAX_START_NUMBER);
            int progressionLength = Engine.getRandom(MIN_LENGTH, MAX_LENGTH);
            int step = Engine.getRandom(MIN_STEP, MAX_STEP);
            int[] progression = getProgression(startNumber, progressionLength, step);

            int indexToHide = Engine.getRandom(0, progressionLength - 1);
            String question = hideIndex(progression, indexToHide);
            /*
            var question = new StringBuilder();
            for (int j = 0; j < progressionLength; j++) {
                if (j == indexToHide) {
                    question.append(".. ");
                } else {
                    question.append(progression[j]);
                    question.append(" ");
                }
            }
            */
            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = String.valueOf(question);
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = String.valueOf(progression[indexToHide]);
        }
        Engine.doRound(QUESTION, questionsAndAnswers);
    }

    public static int[] getProgression(int startNumber, int progressionLength, int step) {
        int[] progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + (i * step);
        }

        return progression;
    }

    public static String hideIndex(int[] progression, int indexToHide) {
        var question = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == indexToHide) {
                question.append(".. ");
            } else {
                question.append(progression[i]);
                question.append(" ");
            }
        }
        return String.valueOf(question);
    }
}
