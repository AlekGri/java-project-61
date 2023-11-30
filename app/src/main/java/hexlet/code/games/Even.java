package hexlet.code.games;

import java.util.Scanner;
public class Even {
    public static final int MAX_RIGHT_ANSWERS = 3;
    public static String userName;
    public static void startEven() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int countAnswer = 0;
        while (true) {
            int count = getRound();
            countAnswer += count;
            if (countAnswer >= MAX_RIGHT_ANSWERS) {
                System.out.println("Congratulations, " + userName  + "!");
                break;
            }
        }
        scanner.close();
    }

    public static int getRound() {
        int count = 0;
        int random = getRandom(1, 100);
        System.out.println("Question: " + random);
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.next();
        boolean isRandomEven = isEven(random);
        String correctAnswer = "no";
        if (isRandomEven) {
            correctAnswer = "yes";
        }

        if ((userAnswer.equals("yes") && isRandomEven) || (userAnswer.equals("no") && !isRandomEven)) {
            count += 1;
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.\n" +
                    "Let's try again, " + userName + "!");
        }
        return count;
    }

    public static int getRandom (int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }

    public static boolean isEven (int num) {
        return num % 2 == 0;
    }
}