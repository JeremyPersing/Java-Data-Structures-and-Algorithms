public class Main {

    static class Node {
        Node next;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    static class Stack {
        Node top;

        void push(int value) {
            if (top == null) {
                top = new Node(value);
            }
            else {
                Node newNode = new Node(value);
                newNode.next = top;
                top = newNode;
            }
        }

        int pop() {
            Node returnNode = top;
            top = top.next;
            return returnNode.value;
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
	    for (int i = 0; i < 5; i++) {
	        stack.push(i);
        }
	    System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(69);
        System.out.println(stack.top.value);
        System.out.println(stack.pop());
    }
}
