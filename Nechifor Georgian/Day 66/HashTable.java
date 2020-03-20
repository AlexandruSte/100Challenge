import java.util.Random;

public class HashTable {
    final static private int B = 10; // size of the hash table
    static class Node {
        int key;
        Node next;

        Node(int key) { this.key = key; this.next = null;}

    }

    private static int f(int key) {
        int hash = 0;
        int k = 121;
        for(int i = 0; i < 10; i++) {
            hash += (key * i + k) / B;
        }
        //System.out.println(hash + " " + hash % B);
        return hash % B;
    }

    public static void insert(Node[] T, int key) {
        int hash = f(key);
        Node newNode = new Node(key);

        if(T[hash] == null) {
            T[hash] = newNode;
        } else {
            newNode.next = T[hash];
            T[hash] = newNode;
        }
    }

    public static Node search(Node[] T, int key) {
        Node node;
        int hash = f(key);
        if(T[hash] == null)
            return null;
        else {
            node = T[hash];
            while(node != null) {
                if(node.key == key) {
                    return node;
                }
                node = node.next;
            }
        }
        return null;
    }

    public static Node delete(Node[] T, int key) {
        int hash = f(key);
        if(T[hash] == null) return null;
        Node p = T[hash];
        if(T[hash].key == key) {
            T[hash] = T[hash].next;
            return p;
        }
        Node curr = p;
        while(p != null) {
            if(p.key == key) {
                curr.next = p.next;
                return p;
            }
            curr = p;
            p = p.next;
        }
        return null;
    }

    public static void printTable(Node[] T) {
        for(int i = 0; i < B; i++) {
            Node curr = T[i];
            System.out.print(i +": ");
            if(curr != null) {
                while (curr.next != null) {
                    System.out.print(curr.key + " -> ");
                    curr = curr.next;
                }
                System.out.println(curr.key);
            } else{
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        Node[] T = new Node[B];

       /*for(int i = 0; i < 50; i++) {
           int key = new Random().nextInt(3245);
           insert(T, key);
       }*/
        insert(T, 10);
        insert(T, 3);
        insert(T, 7);
        insert(T, 421);
        insert(T, 1338);
        insert(T, 1168);
        insert(T, 2267);
        insert(T, 22);
        insert(T, 67);
        printTable(T);

        delete(T, 67);

       printTable(T);
    }


}
