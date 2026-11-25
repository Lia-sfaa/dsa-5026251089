package lw06.prelab.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String line = read.nextLine();
        BinarySearchTree bst = new BinarySearchTree();

        for(String num : line.split(" ")){
            bst.insert(Integer.parseInt(num));
        }

        int target = read.nextInt();
        read.close();

        System.out.print("\nPreorder : ");
        bst.preOrderHelper(bst.root);
        System.out.print("\nInorder : ");
        bst.inOrderHelper(bst.root);
        System.out.print("\nPostorder : ");
        bst.postOrderHelper(bst.root);

        System.out.println("\nSearch " + target + " : " + bst.search(target));
        System.out.println("Nodes : " + bst.countNodes());
        System.out.println("Leaves : " + bst.countLeaves());
    }
}