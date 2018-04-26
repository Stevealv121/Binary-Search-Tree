public class Main {

    public static void main(String[] args) {

        System.out.println("Arbol busqueda binaria");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);bst.insert(8);
        bst.insert(1);bst.insert(4);bst.insert(6);bst.insert(2);bst.insert(10);bst.insert(9);
        bst.insert(20);bst.insert(25);bst.insert(15);bst.insert(16);
        System.out.println("Original Tree : ");
        bst.display(BinarySearchTree.root);
        System.out.println("");
        System.out.println("Delete Node with no children (2) : " + bst.delete(2));
        bst.display(BinarySearchTree.root);
        System.out.println("\n Delete Node with one child (4) : " + bst.delete(4));
        bst.display(BinarySearchTree.root);
        System.out.println("\n Delete Node with Two children (10) : " + bst.delete(10));
        System.out.println("\n Difference between max and min value : " + bst.difference(BinarySearchTree.root));
        bst.display(BinarySearchTree.root);
    }
}
