public class Queue {
    static class Node {
        int key;
        Node next;

        public Node(int key) {this.key = key;}
    }

    //FIFO - first in first out
    //enqueue - insert last
    //dequeue - delete first
    Node head;
    public static void enqueue(Queue q, int key) {
        Node newNode = new Node(key);
        newNode.next = null;
        if(q.head == null) {
            q.head = newNode;
        } else {
            Node last = q.head;
            while(last.next != null)
                last = last.next;
            last.next = newNode;
        }
    }

    public static Node dequeue(Queue q) {
        Node temp = q.head;
        if(temp == null) return null;
        else q.head = temp.next;
        return temp;
    }

    public static Node front(Queue q) {
        return q.head;
    }

    public static void printQueue(Queue q) {
        if(q.head == null) return;
        Node top = q.head;
        while(top != null) {
            String str = String.format("%03d", top.key);
            System.out.print(" | " + str);
            top = top.next;
        }
        System.out.println(" |");
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        enqueue(q, 3);
        enqueue(q, 5);
        printQueue(q);
        System.out.println();
        enqueue(q, 10);
        printQueue(q);
        dequeue(q);
        System.out.println();
        printQueue(q);
    }
}
