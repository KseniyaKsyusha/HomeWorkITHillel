package ua.en.kosse.oksana.hillel.hw16;

import java.util.Random;

public class HomeWorkTree {
    public static void main(String[] args) {
//        Tree<Integer> tree=new Tree<Integer>();
//        Random rnd=new Random();
//        for(int i=0;i<10;++i)
//        {
//            tree.add(rnd.nextInt(100));
//        }
//        tree.printAll();
//        System.out.println();


        System.out.println();

        TreeUtil myTree = new TreeUtil();
        myTree.addNode(8);
        myTree.addNode(3);
        myTree.addNode(6);
        myTree.addNode(10);
        myTree.addNode(14);
        myTree.addNode(1);
        myTree.addNode(4);
        myTree.addNode(7);
        myTree.addNode(13);
        System.out.println(myTree.toString());
        System.out.println();

        myTree.printTree();
        // Реалізувати метод обходу ( в ширину)
        myTree.traverseLevelOrder();


    }

}
