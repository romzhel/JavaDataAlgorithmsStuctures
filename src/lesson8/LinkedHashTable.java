package lesson8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedHashTable<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public LinkedHashTable(int initialCapacity) {
        this.data = new LinkedList[initialCapacity];
    }

    private final List<Item<K, V>>[] data;
    private int size;

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        List<Item<K, V>> items = data[index] != null ? data[index] : new LinkedList<>();

        for (Item<K, V> item : items) {
            if (item.getKey().equals(key)) {
                return false;
            }
        }

        items.add(new Item<>(key, value));
        data[index] = items;
        size++;

        return true;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);

        List<Item<K, V>> items = data[index];

        for (Item<K, V> item : items) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        List<Item<K, V>> items = data[index];
        Iterator<Item<K, V>> iterator = items.listIterator();

        while (iterator.hasNext()) {
            Item<K, V> item = iterator.next();
            if (item.getKey().equals(key)) {
                iterator.remove();
                size--;
                return item.getValue();
            }
        }

        return null;
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
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("----------");
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }
}
