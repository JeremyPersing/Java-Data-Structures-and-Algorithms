public class Main {

    static class Node {
        Node next;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static class Queue {
        Node front, rear;

        void enqueue(int value) {
            if (front == null) {
                front = rear = new Node(value);
            }
            else {
                rear.next = new Node(value);
                rear = rear.next;
            }
        }

        int dequeue() {
            Node firstNode = front;
            front = front.next;
            return firstNode.value;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 1; i < 11; i++) {
            q.enqueue(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(q.dequeue());
        }

        System.out.println("First Node: " + q.front.value);
        System.out.println("Last Node: " + q.rear.value);
    }

}


