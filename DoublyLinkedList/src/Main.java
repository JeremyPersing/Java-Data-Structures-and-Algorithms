public class Main {
    static class Node {
        Node next, prev;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static class DoublyLinkedList {
        Node head, curr;

        // Insertion
        void insert(int value) {
            if (head == null) {
                head = new Node(value);
                curr = head;
            }
            else {
                curr.next = new Node(value);
                curr.next.prev = curr;
                curr = curr.next;
            }
        }

        void insertAt(int index, int value) {
            curr = head;
            if (index == 0) {
                Node newNode =  new Node(value);
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            else {
                for (int count = 0; count < index - 1; count++) {
                    curr = curr.next;
                }
                if (curr.next != null) {
                    Node nextNode = curr.next;
                    Node newNode = new Node(value);
                    curr.next = newNode;
                    newNode.prev = curr;
                    newNode.next = nextNode;
                    nextNode.prev = newNode;
                }
                else {
                    Node newNode = new Node(value);
                    curr.next = newNode;
                    newNode.prev = curr;
                }
            }
        }

        // Deletion
        void deleteEnd() {
            try {
                curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }

                curr.prev.next = null;
                curr.prev = null;
            } catch (NullPointerException e) {
                head = null;
            }
        }

        void deleteAt(int index) {
            curr = head;
            if (index == 0) {
                head = head.next;
                head.prev.next = null;
                head.prev = null;
                curr = head;
            }
            else {
                for (int count = 0; count < index - 1; count++) {
                    curr = curr.next;
                }
                if (curr.next.next != null) {
                    Node nextNode = curr.next.next;
                    nextNode.prev = curr;
                    curr.next = nextNode;
                }
                else {
                    deleteEnd();
                }
            }
        }

        void traverse() {
            curr = head;
            while (curr != null) {
                System.out.print(curr.value + " ");
                curr = curr.next;
            }

        }
    }

    public static void main(String[] args) {
	    DoublyLinkedList dll = new DoublyLinkedList();
	    dll.insert(1);
	    dll.insert(2);
	    dll.insert(5);
        dll.insertAt(1, 14);
        dll.insertAt(0, 69);
        dll.deleteAt(4);
	    dll.traverse();
    }
}
