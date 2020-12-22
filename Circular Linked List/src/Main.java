import javax.swing.*;

public class Main {
    static class Node {
        Node next, prev;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static class CircularLinkedList {
        Node head, curr;

        // Insertion
        void insert(int value) {
            if (head == null) {
                head = new Node(value);
                head.next = head;
                head.prev = head;
            }
            else {
                curr = head.prev;
                Node newNode = new Node(value);
                curr.next = newNode;
                newNode.prev = curr;
                newNode.next = head;
                head.prev = newNode;
            }
        }

        void insertAt(int index, int value) {
            if (index == 0) {
                Node newNode = new Node(value);
                Node prevNode = head.prev;
                prevNode.next = newNode;
                newNode.prev = prevNode;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            else {
                curr = head;
                for (int count = 0; count < index - 1; count++) {
                    curr = curr.next;
                }
                Node nextNode = curr.next;
                Node newNode = new Node(value);
                curr.next = newNode;
                newNode.prev = curr;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }
        }

        // Deletion
        void delete() {
            curr = head.prev;
            Node lastNode = curr.prev;
            lastNode.next = head;
            head.prev = lastNode;
        }

        void deleteAt(int index) {
            if (index == 0) {
                Node prevNode = head.prev;
                Node newHead = head.next;
                prevNode.next = newHead;
                newHead.prev = prevNode;
                head = newHead;
            } else {
                curr = head;
                for (int count = 0; count < index; count++) {
                    curr = curr.next;
                }
                Node prevNode = curr.prev;
                Node nextNode = curr.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
        }

        void traverse() {
            curr = head;
            do {
                System.out.print(curr.value + " ");
                curr = curr.next;
            } while (curr != head);
        }
    }

    public static void main(String[] args) {
	    CircularLinkedList cll = new CircularLinkedList();
	    cll.insert(1);
	    cll.insert(2);
	    cll.insertAt(1, 5);
	    for (int i = 0; i < 10; i++) {
	        cll.insert(i);
        }
	    cll.delete();
	    cll.deleteAt(0);
	    cll.deleteAt(2);
	    cll.traverse();
    }
}
