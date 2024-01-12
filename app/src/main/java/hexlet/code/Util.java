package hexlet.code;

public class Util {
    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}
