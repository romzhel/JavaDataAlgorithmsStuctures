package lesson5;

import java.util.*;

public class HomeworkBackPack {
    private Set<Item> result = new LinkedHashSet<>();
    private int weight;
    private int maxCost;
    private int maxWeight;

    public static void main(String[] args) {
        HomeworkBackPack backPack = new HomeworkBackPack();
        Set<Item> itemSet = backPack.findMaxCostCollection(36,
                new Item(25, 10),
                new Item(10, 20),
                new Item(12, 30),
                new Item(20, 40),
                new Item(5, 50),
                new Item(35, 80));

        System.out.println("--------------------------\n" + itemSet +
                ", weight = " + backPack.weight +
                ", cost = " + backPack.maxCost
        );
    }

    private Set<Item> findMaxCostCollection(int maxWeight, Item... items) {
        this.maxWeight = maxWeight;
        result.clear();
        find(items);

        return result;
    }

    private void find(Item... items) {
        if (checkWeight(items) || items.length == 1) {
            return;
        }

        Item[] workItems = Arrays.copyOf(items, items.length);
        for (int i = 0; i < workItems.length; i++) {
            Item[] buffer = new Item[workItems.length - 1];

            System.arraycopy(workItems, 0, buffer, 0, i);
            System.arraycopy(workItems, i + 1, buffer, i, items.length - 1 - i);

            find(buffer);
            checkWeight(buffer);

            rotate(workItems);
        }
    }

    private Item[] rotate(Item... items) {
        Item temp = items[0];

        for (int i = 1; i < items.length; i++) {
            items[i - 1] = items[i];
        }

        items[items.length - 1] = temp;

        return items;
    }

    private boolean checkWeight(Item... items) {
        int weight = 0;
        int cost = 0;

        for (Item item : items) {
            weight += item.weight;
            cost += item.cost;
        }

        if (weight <= maxWeight && cost > maxCost) {
            result.clear();
            result.addAll(Arrays.asList(items));
            maxCost = cost;
            this.weight = weight;
        }

        return weight <= maxWeight;
    }

    private static class Item {
        private int weight;
        private int cost;

        public Item(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", cost=" + cost +
                    '}';
        }
    }
}
