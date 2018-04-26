public class BinarySearchTree {

    public static Node root;

    BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        Node newNode = new Node(value,null, null);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent;
        while(true){
            parent = current;
            if(value<current.value){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void delete(int value){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.value!=value){
            parent = current;
            if(current.value>value){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current ==null){
                return;
            }
        }
        //Case 1: Node is a leaf
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2: Node has one child
        else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left==null){
            if(current==root){
                root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }
        //Case 3: Node has two children
        else if(current.left!=null && current.right!=null){
            //minimum element in the right sub tree
            Node successor	 = getSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    /**
     * getSuccesor
     * @param deleteNode Node that will be deleted
     * @return value that will replace the deleted Node
     */
    private Node getSuccessor(Node deleteNode){
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleteNode.right;
        while(current!=null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }

        if(successsor!=deleteNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleteNode.right;
        }
        return successsor;
    }

    public void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.value);
            display(root.right);
        }
    }

    private static int findMin(Node root) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }

    private static int findMax(Node root) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(root.right == null) {
            return root.value;
        }
        return findMax(root.right);
    }

    public int difference(){
        return findMax(root) - findMin(root);
    }

    static Node mergeTrees(Node t1, Node t2)
    {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.value += t2.value;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //Metodo que ayuda a asingnar un nuevo nodo con los datos dados y pone en null los punteros derecha e izquierda.
    static Node newNode(int value)
    {
        return new Node(value, null, null);
    }

    //Si tiene arbol binario, imprime sus nodos en inorden.
    static void inOrder(Node node)
    {
        if (node == null)
            return;

        //Primero recorre el hijo izquierdo.
        inOrder(node.left);

    //Despues imprime los datos del nodo.
        System.out.printf("%d ", node.value);

    //Ahora recorre el hijo derecho.
        inOrder(node.right);
    }

    /* Given a binary tree, print its nodes according to the
  "bottom-up" postorder traversal. */
    void printPostOrder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostOrder(node.left);

        // then recur on right subtree
        printPostOrder(node.right);

        // now deal with the node
        System.out.print(" "+node.value + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInOrder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInOrder(node.left);

        /* then print the data of node */
        System.out.print(" "+node.value + " ");

        /* now recur on right child */
        printInOrder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreOrder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(" "+node.value + " ");

        /* then recur on left subtree */
        printPreOrder(node.left);

        /* now recur on right subtree */
        printPreOrder(node.right);
    }
}
