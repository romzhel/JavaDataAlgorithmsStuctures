package lesson5;

public class HomeworkPow {

    public static void main(String[] args) {
        for (int i = -3; i < 3; i++) {
            System.out.println("5 в степени " + i + " = " + getPow(5, i));
        }
    }

    public static double getPow(int value, int level) {
        if (level == 0) {
            return 1;
        } else if (level < 0) {
            level = Math.abs(level);
            return 1 / (value * getPow(value, level - 1));
        } else {
            return value * getPow(value, level - 1);
        }
    }
}
