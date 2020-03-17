public class Lista {
    static class Node {
        int key;
        Node next;

        public Node(int d) {
            this.key = d;
            next = null;
        }

    }
    Node head;

    public static void printList(Lista l) {
        Node curr = l.head;
        System.out.println("Linked list: ");

        while (curr != null) {
            System.out.print(curr.key + " ");
            curr = curr.next;
        }
    }

    public static void insertLast(Lista T, int key) {
        Node newNode = new Node(key);
        newNode.next = null;
        if (T.head == null) {
            T.head = newNode;
        } else {
            Node last = T.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public static void insertFirst(Lista T, int key) {
        Node newNode = new Node(key);
        newNode.next = null;
        if (T.head == null)
            T.head = newNode;
        else {
            newNode.next = T.head;
            T.head = newNode;
        }
    }

    public static void insertAfterKey(Lista T, int key, int after) {
        Node newNode = new Node(key);
        newNode.next = null;
        if (T.head == null) return;
        Node curr = T.head;
        while (curr != null) {
            if (curr.key == after) {
                //insert
                newNode.next = curr.next;
                curr.next = newNode;
                break;
            }
            curr = curr.next;
        }
    }

    public static void insertBeforeKey(Lista T, int key, int before) {
        Node newNode = new Node(key);
        newNode.next = null;
        if (T.head == null) return;
        Node curr = T.head;
        Node prev = T.head;
        if (before == T.head.key) {
            insertFirst(T, key);
            return;
        }
        while (curr != null) {
            if (curr.key == before) {
                prev.next = newNode;
                newNode.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static Node deleteFirst(Lista T) {
        if(T.head == null) return null;
        Node node = T.head;
        T.head = node.next;
        node.next = null;

        return node;
    }

    public static Node deleteLast(Lista T) {
        Node last = T.head;
        while(last.next.next != null) {
            last = last.next;
        }

        Node node = new Node(last.next.key);
        last.next = null;
        return node;
    }

    public static Node deleteKey(Lista T, int key) {
        if(T.head == null) return null;
        if(T.head.key == key) {
            return deleteFirst(T);
        }

        Node curr = T.head;
        Node prev = curr;
        while(curr != null) {
            if(curr.key == key) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;

        }

        return curr;
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        insertLast(lista, 1);
        insertLast(lista, 3);
        insertLast(lista, 10);
        insertFirst(lista, 5);
        insertFirst(lista, 4);
        insertAfterKey(lista, 11, 1);
        insertAfterKey(lista, 67, 11);
        insertBeforeKey(lista, 6, 5);
        insertBeforeKey(lista, 1, 4);
        insertBeforeKey(lista, 123, 10);
        insertAfterKey(lista, 54, 10);
        insertAfterKey(lista, 54, 675);

        deleteFirst(lista);
        //System.out.println(deleteFirst(lista).key);
        deleteLast(lista);
        deleteLast(lista);
        deleteKey(lista, 11);
        deleteKey(lista, 11);
        deleteKey(lista, 123);
        deleteKey(lista, 4);

        printList(lista);
    }


}
