package lesson3.dequeue;

import lesson3.queue.QueueImpl;

public class DequeueImpl<E> extends QueueImpl<E> implements Dequeue<E> {

    public DequeueImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertHead(E value) {
        if (isFull()) {
            return false;
        }

        if (head == HEAD_DEFAULT) {
            head = data.length;
        }

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public E removeTail() {
        if (isEmpty()) {
            return null;
        }

        if (tail == TAIL_DEFAULT) {
            tail = data.length - 1;
        }

        E value = data[tail];
        data[tail--] = null;
        size--;

        return value;
    }

    @Override
    public E peekTail() {
        return data[tail];
    }
}
