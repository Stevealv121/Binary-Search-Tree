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


        //Primer arbol binario
        Node root1 = BinarySearchTree.newNode(1);
        root1.left = BinarySearchTree.newNode(2);
        root1.right = BinarySearchTree.newNode(3);
        root1.left.left = BinarySearchTree.newNode(4);
        root1.left.right = BinarySearchTree.newNode(5);
        root1.right.right = BinarySearchTree.newNode(6);

        //Segundo Arbol binario
        Node root2 = BinarySearchTree.newNode(7);
        root2.left = BinarySearchTree.newNode(4);
        root2.right = BinarySearchTree.newNode(2);
        root2.left.left = BinarySearchTree.newNode(5);
        root2.right.left = BinarySearchTree.newNode(3);
        root2.right.right = BinarySearchTree.newNode(6);

        Node root3 = BinarySearchTree.mergeTrees(root1, root2);
        System.out.println("\nLa mezcla de los arboles es:");
        BinarySearchTree.inorden(root3);

        BinarySearchTree aTree = new BinarySearchTree();
        aTree.insert(1);aTree.insert(2);aTree.insert(3);aTree.insert(4);aTree.insert(5);
        System.out.println("\nIn order");
        aTree.printInorder(BinarySearchTree.root);
        System.out.println("\nPost order");
        aTree.printPostorder(BinarySearchTree.root);
        System.out.println("\nPre order");
        aTree.printPreorder(BinarySearchTree.root);


    }
}
