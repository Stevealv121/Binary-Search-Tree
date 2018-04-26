public class BinarySearchTree {

    public static Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
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

    public boolean delete(int value){
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
                return false;
            }
        }
        //Case 1: Node is a leaf
        if(current.left==null && current.right==null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
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
        return true;
    }

    /**
     * getSuccesor
     * @param deleteNode Node that will be deleted
     * @return value that will replace the deleted Node
     */
    public Node getSuccessor(Node deleteNode){
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

    public static int findMin(Node root) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(root.left == null) {
            return root.value;
        }
        return findMin(root.left);
    }

    public static int findMax(Node root) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(root.right == null) {
            return root.value;
        }
        return findMax(root.right);
    }

    public int difference(Node root){
        int result = findMax(root) - findMin(root);
        return result;
    }
}
