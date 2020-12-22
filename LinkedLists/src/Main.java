public class Main {

    static class Node {
        Node next;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static class LinkedList {
        Node firstNode, curr;

        LinkedList(int value) {
            firstNode = new Node(value);
            curr = firstNode;
        }

        // Adding nodes
        void add(int value) {
            Node newNode = new Node(value);
            curr.next = newNode;
            curr = newNode;
        }

        void addAtIndex(int index, int value) {
            if (index == 0) {
                Node formerFirstNode = firstNode;
                firstNode = new Node(value);
                firstNode.next = formerFirstNode;
                curr = firstNode;
            }
            else {
                curr = firstNode;
                int count = 0;
                while (count < index - 1) {
                    curr = curr.next;
                    count++;
                }
                System.out.println(curr.value);
                // When there is a next node, you want to hold the value of that node
                // and link the node you are inserting to that node
                if (curr.next != null) {
                    Node nextNode = curr.next;
                    System.out.println(nextNode.value);
                    Node newNode = new Node(value);
                    curr.next = newNode;
                    curr = newNode;
                    curr.next = nextNode;
                } else {
                    curr.next = new Node(value);
                }
            }
        }

        // Deletion from the list
        void deleteFromEnd() {
            curr = firstNode;
            try {
                while (curr.next.next != null) {
                    curr = curr.next;
                }
                curr.next = null;
            } catch (NullPointerException e) {
                firstNode = null;
            }
        }

        void deleteFromBeginning() {
            firstNode = firstNode.next;
            curr = firstNode;
        }

        void deleteAtIndex(int index) {
            if (index == 0) {
                deleteFromBeginning();
            }
            else {
                curr = firstNode;
                int count = 0;
                while(count < index - 1) {
                    curr = curr.next;
                    count++;
                }

                if (curr.next != null) {
                    Node nextNode = curr.next.next;
                    curr.next = nextNode;
                }
                else {
                    deleteFromEnd();
                }
            }
        }

        void traverse() {
            curr = firstNode;
            while (curr != null) {
                if (curr.next != null) {
                    System.out.print(curr.value + " => ");
                }
                else {
                    System.out.print(curr.value);
                }
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(1);
        ll.add(2);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(68);
        ll.add(69);
        ll.add(70);
        ll.addAtIndex(4, 8);
        ll.deleteFromEnd();
        ll.deleteFromBeginning();
        ll.addAtIndex(0, -4);
        ll.deleteAtIndex(0);
        ll.traverse();
    }
}
