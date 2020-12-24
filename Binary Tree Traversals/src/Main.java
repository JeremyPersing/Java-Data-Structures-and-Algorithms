public class Main {
    static class Node {
        Node left, right;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static class BinaryTree {
        Node root;

        void insert(int value, Node tempRoot) {

            if (value < tempRoot.value && tempRoot.left == null) {
                tempRoot.left = new Node(value);
            }
            else if (value > tempRoot.value && tempRoot.right == null) {
                tempRoot.right = new Node(value);
            }
            else if (value < tempRoot.value && tempRoot.left != null) {
                insert(value, tempRoot.left);
            }
            else if (value > tempRoot.value && tempRoot.right != null) {
                insert(value, tempRoot.right);
            }
        }

        void preOrderTraversal(Node root) {
            System.out.println(root.value);
            if (root.left != null) {
                preOrderTraversal(root.left);
            }
            if (root.right != null) {
                preOrderTraversal(root.right);
            }
        }

        void inOrderTraversal(Node root) {
            if (root.left != null) {
                inOrderTraversal(root.left);
            }
            System.out.println(root.value);
            if (root.right != null) {
                inOrderTraversal(root.right);
            }
        }

        void postOrderTraversal(Node root) {
            if (root.left != null) {
                postOrderTraversal(root.left);
            }
            if (root.right != null) {
                postOrderTraversal(root.right);
            }
            System.out.println(root.value);
        }
    }


    public static void main(String[] args) {
        // Creation of the binary tree
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(10);
        bt.insert(7, bt.root);
        bt.insert(11, bt.root);
        bt.insert(6, bt.root);
        bt.insert(8, bt.root);
        bt.insert(20, bt.root);
        bt.insert(1, bt.root);
        bt.insert(9, bt.root);
        bt.insert(14, bt.root);
        bt.insert(22, bt.root);
        System.out.println("PreOrder Traversal");
        bt.preOrderTraversal(bt.root);
        System.out.println("\nInOrder Traversal");
        bt.inOrderTraversal(bt.root);
        System.out.println("\nPostOrder Traversal");
        bt.postOrderTraversal(bt.root);
    }
}
