package lesson3.dequeue;

import lesson3.queue.Queue;

public interface Dequeue<E> extends Queue<E> {

    boolean insertLeft(E value);

    E removeLeft();

    E removeRight();

    boolean insertRight(E value);

    E peekRight();

    E peekLeft();
}
