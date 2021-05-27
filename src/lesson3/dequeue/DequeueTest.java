package lesson3.dequeue;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DequeueTest {

    public static void main(String[] args) {
        Dequeue<Integer> dequeue = new DequeueImpl<>(5);

        Consumer<Integer> insertToHead = dequeue::insertHead;
        Consumer<Integer> insertToTail = dequeue::insert;
        Supplier<Integer> removeFromHead = dequeue::remove;
        Supplier<Integer> removeFromTail = dequeue::removeTail;

        Consumer<Integer>[] arr = new Consumer[] {insertToHead, insertToTail};

        for (int i = 0; i < 7; i++) {
            Consumer<Integer> consumer = arr[i % 2];
            consumer.accept(i);
            System.out.println("add " + (consumer == insertToHead ? "to head " : "to tail ") + i + ", dequeue = " + dequeue);
        }

        System.out.println("remove from head " + removeFromHead.get() + ", dequeue = " + dequeue);
        System.out.println("remove from head " + removeFromHead.get() + ", dequeue = " + dequeue);
        System.out.println("remove from tail " + removeFromTail.get() + ", dequeue = " + dequeue);
        System.out.println("remove from tail " + removeFromTail.get() + ", dequeue = " + dequeue);
        System.out.println("remove from tail " + removeFromTail.get() + ", dequeue = " + dequeue);
        System.out.println("remove from tail " + removeFromTail.get() + ", dequeue = " + dequeue);
    }
}
