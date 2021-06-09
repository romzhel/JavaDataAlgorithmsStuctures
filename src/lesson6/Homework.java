package lesson6;

import java.util.Random;

public class Homework {
    public static final int TREE_MAX_LEVEL = 4;
    public static final int TREE_COUNT = 20;
    public static final int ABS_MAX_VALUE = 25;

    public static void main(String[] args) {
        Random random = new Random();

        int balancedTreeCount = 0;
        for (int i = 0; i < TREE_COUNT; i++) {
            Tree<Integer> tree = new TreeImpl<>(TREE_MAX_LEVEL);
            for (int j = 0; j < Math.pow(2, TREE_MAX_LEVEL) - 1; j++) {
                tree.add(random.nextInt(ABS_MAX_VALUE * 2 + 1) - ABS_MAX_VALUE);
            }
            tree.display();

            boolean treeIsBalanced = tree.isBalanced();
            if (treeIsBalanced) {
                balancedTreeCount++;
            }
            System.out.println("tree is balanced = " + treeIsBalanced);
        }

        System.out.println("===============================");
        System.out.println(String.format("balanced trees %d from %d (%d%%)",
                balancedTreeCount,
                TREE_COUNT,
                balancedTreeCount * 100 / TREE_COUNT
        ));
    }
}
