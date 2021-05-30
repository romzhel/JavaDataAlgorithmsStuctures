package lesson4;

import java.util.Iterator;

public class TwoSideLinkedListImpl<E> implements TwoSideLinkedList<E> {

    private int size;
    private ExtNode<E> firstElement;
    private ExtNode<E> lastElement;

    @Override
    public void insertLast(E value) {
        ExtNode<E> newNode = new ExtNode<>(lastElement, value, null);
        if (isEmpty()) {
            firstElement = newNode;
        } else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public E removeLast() {
        E removedValue = lastElement.item;
        lastElement.prev.next = null;
        lastElement.prev = null;
        size--;

        if (isEmpty()) {
            firstElement = null;
        }

        return removedValue;
    }

    @Override
    public void insertFirst(E value) {
        firstElement = new ExtNode<>(null, value, firstElement);
        if (isEmpty()) {
            lastElement = firstElement;
        }
        size++;
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    private E getValue(ExtNode<E> extNode) {
        return extNode != null ? extNode.item : null;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        ExtNode<E> removedMode = firstElement;
        firstElement = removedMode.next;
        removedMode.next = null;
        size--;

        if (isEmpty()) {
            lastElement = null;
        }

        return removedMode.item;
    }

    @Override
    public boolean remove(E value) {
        ExtNode<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else if (current == lastElement) {
            removeLast();
            return true;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
        }

        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        ExtNode<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean insert(E value) {
        insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E peekFront() {
        return getFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public E getLast() {
        return getValue(lastElement);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ExtNode<E> current = firstElement;
        while (current != null) {
            sb.append(current.item).append(",");
            current = current.next;
        }
        sb.setCharAt(sb.length() - 1, ']');

        return sb.toString();
    }

    @Override
    public boolean insertLeft(E value) {
        insertFirst(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return removeFirst();
    }

    @Override
    public E removeRight() {
        return removeLast();
    }

    @Override
    public boolean insertRight(E value) {
        insertLast(value);
        return true;
    }

    @Override
    public E peekRight() {
        return getLast();
    }

    @Override
    public E peekLeft() {
        return getFirst();
    }

    private class Itr implements Iterator<E> {

        ExtNode<E> pointer;

        public Itr() {
            this.pointer = firstElement;
        }

        @Override
        public boolean hasNext() {
            return firstElement != null;
        }

        @Override
        public E next() {
            ExtNode<E> node = pointer;
            pointer = node.next;

            return getValue(node);
        }
    }
}
