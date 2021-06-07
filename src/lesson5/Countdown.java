package lesson5;

public class Countdown {

    public static void main(String[] args) {
//        countDownLoop(5);
        int n = 5;
        countDownRecursion(n);
    }

    private static void countDownRecursion(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        countDownRecursion(--n);
    }

    private static void countDownLoop(int n) {
//        while (true) {
        while (n > 0) {
            System.out.println(n);
            n--;
//            if (n <= 0)
//                break;
        }
    }
}
