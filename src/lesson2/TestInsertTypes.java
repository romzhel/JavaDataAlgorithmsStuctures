package lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestInsertTypes {

    public static void main(String[] args) {
        final int CAPACITY = 100_000;
        Array<Integer> array1 = new ArrayImpl<>(CAPACITY);
        Array<Integer> array2 = new ArrayImpl<>(CAPACITY);
        Array<Integer> array3 = new ArrayImpl<>(CAPACITY);

        Random random = new Random();
        for (int i = 0; i < CAPACITY; i++) {
            int value = random.nextInt();
            array1.add(value);
            array2.add(value);
            array3.add(value);
        }

        System.out.println("sort bubbles time = " + testAndGetTime(array1::sortBubble));
        System.out.println("sort select time = " + testAndGetTime(array2::sortSelect));
        System.out.println("sort insert time = " + testAndGetTime(array3::sortInsert));
    }

    public static String testAndGetTime(Runnable runnable) {
        long t0 = System.nanoTime();
        runnable.run();

        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t0) + " ms";
    }
}
