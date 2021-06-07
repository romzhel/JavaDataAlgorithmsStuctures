package lesson5;

import lesson2.SortedArrayImpl;

public class RecSortedArrayImpl<E extends Comparable<? super E>> extends SortedArrayImpl<E> {

    @Override
    public int indexOf(E value) {
        return recBinaryFind(value, 0, size - 1);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (data[mid].equals(value)) {
            return mid;
        } else if (value.compareTo(data[mid]) > 0) {
            return recBinaryFind(value, mid + 1, high);
        } else {
            return recBinaryFind(value, low, mid - 1);
        }
    }
}
