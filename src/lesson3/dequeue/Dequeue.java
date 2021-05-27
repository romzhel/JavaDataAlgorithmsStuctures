package lesson3.dequeue;

import lesson3.queue.Queue;

public interface Dequeue<E> extends Queue<E> {

    boolean insertHead(E value);

    E removeTail();

    E peekTail();
}
