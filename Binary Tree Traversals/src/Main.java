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

        void insert(int digit) {
            insertNode(digit, root);
        }

        void insertNode(int value, Node root) {
            // No root
            if (root == null) {
                this.root = new Node(value);
            }
            else {
                // Value is less than or equal to root's value
                if (value <= root.value) {
                    // If there is no leaf node, create one
                    if (root.left == null) {
                        root.left = new Node(value);
                    }
                    // Otherwise keep going
                    else {
                        insertNode(value, root.left);
                    }
                }
                // Value is greater than root's value
                else {
                    // If there is no leaf node, create one
                    if (root.right == null) {
                        root.right = new Node(value);
                    }
                    else {
                        insertNode(value, root.right);
                    }
                }
            }
        }

        void delete(int digit) {
            deleteNode(digit, root);
        }

        Node deleteNode(int value, Node root) {
            if (root == null) {
                return null;
            }

            // Find the position of the leaf
            if (value < root.value) {
                root.left = deleteNode(value, root.left);
            }
            else if (value > root.value) {
                root.right = deleteNode(value, root.right);
            }
            // You're on the correct leaf Node now
            else {
                // If the leaf has no children
                if (root.right == null && root.left == null) {
                    return null;
                }
                // The leaf has 1 child
                if (root.left == null) {
                    return root.right;
                }
                else if (root.right == null) {
                    return root.left;
                }
                // Leaf has 2 children
                else {
                    // Find the minimum value on the right side of the root
                    int min = getMinimum(root.right).value;
                    System.out.println("Minimum value is " + min);
                    // Replace the current node's value for the minimum value
                    root.value = min;
                    // Delete the previous min node because it is now where the 'deleted' node was
                    root.right = deleteNode(min, root.right);
                }
            }
            return root;
        }

        Node getMinimum(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
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
            if (root != null) {
                inOrderTraversal(root.left);
                System.out.println(root.value);
                inOrderTraversal(root.right);
            }
        }

        void postOrderTraversal(Node root) {
            if (root != null) {
                postOrderTraversal(root.left);
                postOrderTraversal(root.right);
                System.out.println(root.value);
            }
        }
    }


    public static void main(String[] args) {
        // Creation of the binary tree
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(7);
        bt.insert(11);
        bt.insert(6);
        bt.insert(8);
        bt.insert(20);
        bt.insert(1);
        bt.insert(9);
        bt.insert(14);
        bt.insert(22);
        bt.delete(8);
        System.out.println("PreOrder Traversal");
        bt.preOrderTraversal(bt.root);
        System.out.println("\nInOrder Traversal");
        bt.inOrderTraversal(bt.root);
        System.out.println("\nPostOrder Traversal");
        bt.postOrderTraversal(bt.root);
    }
}
