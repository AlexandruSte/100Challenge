public class DoublyLinkedList {
    static class Node {
        int key;
        Node next;
        Node prev;

        public Node(int key) {
            this.key = key;
        }
    }

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

    public static Node deleteFirst(DoublyLinkedList dl) {
        if(dl.head == null) return null;
        Node head = dl.head;
        dl.head = head.next;
        dl.head.prev = null;

        return head;
    }

    public static Node deleteLast(DoublyLinkedList dl) {
        Node last = dl.head;
        if(last == null) return null;
        while(last.next != null)
            last = last.next;
        Node prev = last.prev;
        last.prev = null;
        prev.next = null;
        return last;
    }

    public static Node deleteKey(DoublyLinkedList dl, int key) {
        Node node = dl.head;
        if(node == null) return null;
        boolean deleted = false;
        if(node.key == key) {
            dl.head = node.next;
            dl.head.prev = null;
            return node;
        }
        while(node.next != null) {
            if(node.key == key)  {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                deleted = true;
                break;
            }
            node = node.next;
        }
        if(!deleted) {
            if (node.key == key) {
                node.prev.next = null;
            }
        }
        return node;
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
        
        deleteLast(dl);
        deleteFirst(dl);

        deleteKey(dl, 3);
        printList(dl);
        printListBackwords(dl);
    }
}
