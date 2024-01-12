package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

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
            int startNumber = Util.getRandom(MIN_START_NUMBER, MAX_START_NUMBER);
            int progressionLength = Util.getRandom(MIN_LENGTH, MAX_LENGTH);
            int step = Util.getRandom(MIN_STEP, MAX_STEP);
            String[] progression = getProgression(startNumber, progressionLength, step);

            int indexToHide = Util.getRandom(0, progressionLength - 1);
            String answer = progression[indexToHide];
            String question = hideIndex(progression, indexToHide);

            questionsAndAnswers[i][Engine.QUESTIONS_ROW] = question;
            questionsAndAnswers[i][Engine.ANSWERS_ROW] = answer;
        }
        Engine.doRound(QUESTION, questionsAndAnswers);
    }

    public static String[] getProgression(int startNumber, int progressionLength, int step) {
        String[] progression = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = String.valueOf(startNumber + (i * step));
        }

        return progression;
    }

    public static String hideIndex(String[] progression, int indexToHide) {
        progression[indexToHide] = "..";
        return String.join(" ", progression);
    }
}
