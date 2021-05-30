package lesson4;

import lesson3.dequeue.Dequeue;

public interface TwoSideLinkedList<E> extends LinkedList<E>, Dequeue<E> {

    void insertLast(E value);

    E removeLast();

    E getLast();

    class ExtNode<E> {
        E item;
        ExtNode<E> prev;
        ExtNode<E> next;

        public ExtNode(ExtNode<E> prev, E item, ExtNode<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}
