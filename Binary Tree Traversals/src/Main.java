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

        void insertNode(int value, Node tempRoot) {
            if (tempRoot == null) {
                root = new Node(value);
            }
            else {
                if (value <= tempRoot.value && tempRoot.left == null) {
                    tempRoot.left = new Node(value);
                }
                else if (value > tempRoot.value && tempRoot.right == null) {
                    tempRoot.right = new Node(value);
                }
                else if (value <= tempRoot.value && tempRoot.left != null) {
                    insertNode(value, tempRoot.left);
                }
                else if (value > tempRoot.value && tempRoot.right != null) {
                    insertNode(value, tempRoot.right);
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
            // Deletion value is less than the current root value
            else if (value < root.value) {
                root.left = deleteNode(value, root.left);
            }
            // Deletion value is greater than the current root value
            else if (value > root.value) {
                root.right = deleteNode(value, root.right);
            }
            // Deletion value is equal to the current root value (ie DELETE THIS NODE)
            else {
                // No Children
                if (root.right == null && root.left == null) {
                    System.out.println("Should be deleting " + root.value);
                    return null;
                }
                // One Child
                else if (root.left == null) {
                    System.out.println("Should be deleting " + root.value);
                    return root.right;
                }
                else if (root.right == null) {
                    System.out.println("Should be deleting " + root.value);
                    return root.left;
                }
                // Two Children
                else {
                    // Find the minimum on the right of the node
                    Node min = findMin(root.right);
                    root.value = min.value;
                    // Within the right subtree, delete the minimum node
                    // Because you just replaced the node you wanted to delete with it
                    root.right = deleteNode(root.value, root.right);
                    System.out.println("Should be deleting " + root.value);
                }
            }
            return root;
        }

        Node findMin(Node tempRoot) {
            if (tempRoot.left == null) {
                return tempRoot;
            }
            else {
                return findMin(tempRoot.left);
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
        /*int arr [] = new int[] {7, 15, 2, 3, 19, 20, 35, 42, 10, 56, 99, 3};
        for (int i = 0; i < arr.length; i++) {
            bt.insert(arr[i], bt.root);
        }*/
        bt.insert(15);
        bt.insert(10);
        bt.insert(25);
        bt.insert(6);
        bt.insert(20);
        bt.insert(19);
        bt.insert(22);
        bt.insert(33);
        bt.delete(15);
        bt.delete(33);
        bt.delete(10);
        System.out.println("PreOrder Traversal");
        bt.preOrderTraversal(bt.root);
        System.out.println("\nInOrder Traversal");
        bt.inOrderTraversal(bt.root);
        System.out.println("\nPostOrder Traversal");
        bt.postOrderTraversal(bt.root);
    }
}
