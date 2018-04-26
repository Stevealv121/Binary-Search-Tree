public class Main {

    public static void main(String[] args) {

        System.out.println("Arbol busqueda binaria");

        BinarySearchTree bst = new BinarySearchTree();
        //Inserciones
        bst.insert(3);bst.insert(8);
        bst.insert(1);bst.insert(4);bst.insert(6);bst.insert(2);
        bst.insert(10);bst.insert(9);
        bst.insert(20);bst.insert(25);bst.insert(15);bst.insert(16);

        System.out.println("\nArbol inicial : ");
        bst.display(BinarySearchTree.root);
        System.out.println("");

        //Casos eliminacion
        bst.delete(2);
        System.out.println(" Eliminar nodo sin hijos (2) : ");
        bst.display(BinarySearchTree.root);
        bst.delete(4);
        System.out.println("\n Eliminar nodo con un hijo (4) : ");
        bst.display(BinarySearchTree.root);
        bst.delete(10);
        System.out.println("\n Eliminar nodo con dos hijos (10) : ");
        bst.display(BinarySearchTree.root);

        //Diferencia entre el nodo menor y mayor
        System.out.println("\n Diferencia entre el nodo mayor y el nodo menor : " + bst.difference());
        bst.display(BinarySearchTree.root);


        //Mezcla de dos arboles
        System.out.println("\n\nMezcla de Arboles");
        //Primer arbol binario
        Node root1 = BinarySearchTree.newNode(1);
        root1.left = BinarySearchTree.newNode(2);
        root1.right = BinarySearchTree.newNode(3);
        root1.left.left = BinarySearchTree.newNode(4);
        root1.left.right = BinarySearchTree.newNode(5);
        root1.right.right = BinarySearchTree.newNode(6);
        System.out.println("\nArbol 1: ");
        BinarySearchTree.inOrder(root1);

        //Segundo Arbol binario
        Node root2 = BinarySearchTree.newNode(7);
        root2.left = BinarySearchTree.newNode(4);
        root2.right = BinarySearchTree.newNode(2);
        root2.left.left = BinarySearchTree.newNode(5);
        root2.right.left = BinarySearchTree.newNode(3);
        root2.right.right = BinarySearchTree.newNode(6);
        System.out.println("\nArbol 2: ");
        BinarySearchTree.inOrder(root2);

        //Arbol resultante de la mezcla
        Node root3 = BinarySearchTree.mergeTrees(root1, root2);
        System.out.println("\nLa mezcla de los arboles es:");
        BinarySearchTree.inOrder(root3);

        //Resultado de recorrerlo en inorden, postorden y preorden
        System.out.println("\n\nDiferentes maneras de recorrer el arbol: ");
        BinarySearchTree aTree = new BinarySearchTree();
        BinarySearchTree.root = BinarySearchTree.newNode(1);
        BinarySearchTree.root.left = BinarySearchTree.newNode(2);
        BinarySearchTree.root.right = BinarySearchTree.newNode(3);
        BinarySearchTree.root.left.left = BinarySearchTree.newNode(4);
        BinarySearchTree.root.left.right = BinarySearchTree.newNode(5);
        System.out.println("\n Recorrida inorden");
        aTree.printInOrder(BinarySearchTree.root);
        System.out.println("\n Recorrida postorden");
        aTree.printPostOrder(BinarySearchTree.root);
        System.out.println("\n Recorrida preorden");
        aTree.printPreOrder(BinarySearchTree.root);


    }
}
