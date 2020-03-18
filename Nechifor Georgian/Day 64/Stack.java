public class Stack {
    static class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }
    //LIFO - last in first out
    //push = insert first
    //pop = delete first
    Node head;
    public static void push(Stack s, int key) {
        Node top = new Node(key);
        top.next = null;
        if(s.head == null) {
            s.head = top;
        } else {
            top.next = s.head;
            s.head = top;
        }
    }

    public static Node pop(Stack s) {
        if(s.head == null) return null;
        Node top = s.head;
        s.head = s.head.next;
        return top;
    }

    public static Node top(Stack s) {
        if(s.head == null) return null;
        return s.head;
    }

    public static void printStack(Stack s) {
        if(s.head == null) return;
        Node top = s.head;
        while(top != null) {
            String str = String.format("%03d", top.key);
            System.out.println("| " + str + " |");
            System.out.println(" _____");
            top = top.next;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        push(s, 4);
        push(s, 15);
        push(s, 2);
        push(s, 7);
        push(s, 11);
        push(s, 2);
        System.out.println("Initial stack: ");
        printStack(s);

        pop(s);
        System.out.println("First pop: ");
        printStack(s);
        System.out.println("Second pop: ");
        pop(s);
        pop(s);
        printStack(s);


    }
}
