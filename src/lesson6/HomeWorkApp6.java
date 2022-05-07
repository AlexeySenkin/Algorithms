package lesson6;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkApp6 {
    public static void main(String[] args) {

        List<Tree<Integer>> trees = new ArrayList<>();

        int treeCount = 20;
        int balanceTreeCount = 0;

        for (int i = 0; i < treeCount; i++) {
            Tree<Integer> tree = new TreeImpl<>(4);
            for (int j = 0; j < 15; j++) {
                tree.add((int) Math.round(Math.random() * 50 - 25) );
            }
            trees.add(tree);
        }

        for (int i = 0; i < treeCount; i++) {
            trees.get(i).display();
            if (trees.get(i).traverse(Tree.TraversMode.PRE_ORDER_BALANCE)) {
                System.out.println("Дерево сбалансировано");
                balanceTreeCount++;
            } else {
                System.out.println("Дерево не сбалансировано");
            }
        }
        System.out.println("Из " + treeCount + " деревьев " + balanceTreeCount + " сбалансированы (" +
                (double)balanceTreeCount / (double)treeCount * 100 + "%)" );
    }
}
