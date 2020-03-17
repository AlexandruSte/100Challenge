public class DoublyLinkedList {
    static class Node {
        int key;
        Node next;
        Node prev;

        public Node(int key) {
            this.key = key;
        }
    }
    //insert first
    //insert last
    //insert after key
    //delete first
    //delete last
    //delete key
    Node head;
    public static void insertFirst(DoublyLinkedList dl, int key) {
        Node newNode = new Node(key);
        newNode.next = null;
        newNode.prev = null;

        if(dl.head == null)
            dl.head = newNode;
        else {
            newNode.next = dl.head;
            dl.head.prev = newNode;
            dl.head = newNode;
        }
    }

    public static void insertLast(DoublyLinkedList dl, int key) {
        Node newNode = new Node(key);
        newNode.next = null;
        newNode.prev = null;
        if(dl.head == null)
            dl.head = newNode;
        else {
            Node last = dl.head;
            while(last.next != null)
                last = last.next;
            last.next = newNode;
            newNode.prev = last;
        }
    }

    public static void insertAfterKey(DoublyLinkedList dl, int key, int after) {
        Node newNode = new Node(key);
        newNode.next = null;
        newNode.prev = null;

        if(dl.head == null)
            return;
        else {
            if(dl.head.key == after) {
                dl.head.next = newNode;
                newNode.prev = dl.head;
            } else {
                Node temp = dl.head;
                while(temp.next != null) {
                    if(temp.key == after) {
                        newNode.next = temp.next;
                        temp.next.prev = newNode;
                        temp.next = newNode;
                        newNode.prev = temp;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }

    public static void printList(DoublyLinkedList dl) {
        if(dl.head == null) return;
        Node temp = dl.head;
        while(temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //for optimisation we could make an attribute last for this class
    public static void printListBackwords(DoublyLinkedList dl) {
        Node last = dl.head;
        while(last.next != null)
            last = last.next;

        while(last != null) {
            System.out.print(last.key + " ");
            last = last.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        insertFirst(dl, 10);
        insertFirst(dl, 11);
        insertFirst(dl, 1);
        insertFirst(dl, 3);
        insertLast(dl, 123);
        insertLast(dl, 5);

        insertAfterKey(dl, 54, 10);

        printList(dl);
        printListBackwords(dl);
    }
}
