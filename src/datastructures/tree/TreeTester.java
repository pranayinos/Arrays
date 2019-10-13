package datastructures.tree;

import java.util.List;

public class TreeTester {
    public static void main(String[] args) {
//        for (int a = 1; a < 100; a++){
//            System.out.println("nodes : " + a + " height : "+log2(a));
//        }
        Tree tree = new Tree();
        print(tree.traverseInOrderRecursively());
        tree.add(10);
        tree.add(11);
        tree.add(7);
        tree.add(78);
        tree.add(9);
        tree.add(3);
        tree.add(46);
        tree.add(55);
        tree.add(22);
        System.out.println("\n"+tree.root.data);
        print(tree.traverseInOrderRecursively());
        System.out.println();
        print(tree.traverseInOrder());
        System.out.println();
        print(tree.traversePreOrder());

    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    public static void print(List<Integer> characters){
        characters.forEach(character -> System.out.print(character+" "));
    }
}
