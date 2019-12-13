class ListNode {
    int value;
    ListNode next;
    ListNode(int x) {
        value = x;
    }
}

public class Easy {
    /*
     * DAY 2
     *
     */

    //https://leetcode.com/problems/merge-two-sorted-lists/
    private ListNode insertLast(ListNode node, int x) {
        ListNode aux = node;
        if (node == null)
            return new ListNode(x);
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = new ListNode(x);
        return node;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rez = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                rez = insertLast(rez, l1.val);
                l1 = l1.next;
            } else {
                rez = insertLast(rez, l2.val);
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            rez = insertLast(rez, l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            rez = insertLast(rez, l2.val);
            l2 = l2.next;
        }

        return rez;
    }

    //https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        while (head != null) {
            if (head.val != Integer.MIN_VALUE)
                head.val = Integer.MIN_VALUE;
            else
                return true;

            head = head.next;
        }
        return false;
    }

    //https://leetcode.com/problems/min-stack/
    class MinStack {
        private static final int MAX = 1000;
        private int top;
        private int[] a = new int[MAX];

        MinStack() {
            top = -1;
        }

        public boolean isEmpty() {
            return top < 0;
        }

        //insert last
        public void push(int x) {
            if (top >= MAX - 1)
                return;
            else {
                a[++top] = x;
            }
        }

        public void pop() {
            if (top < 0)
                return;
            else {
                int x = a[top--];
            }

        }

        public int top() {
            if (top < 0) return -1;
            return a[top];
        }

        public int getMin() {
            if (top < 0) return 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i <= top; i++)
                minValue = Integer.min(minValue, a[i]);
            return minValue;
        }
    }

    //https://leetcode.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        int majority = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else
                freq.put(nums[i], 1);
        }

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > nums.length / 2)
                majority = e.getKey();
        }
        return majority;
    }

    //https://leetcode.com/problems/happy-number/submissions/
    public boolean isHappy(int n) {
        int result = 0;
        int iteration = 0;
        while (result != 1 && iteration <= 100) {
            result = 0;
            while (n != 0) {
                result += (n % 10) * (n % 10);
                n /= 10;
            }
//            System.out.println(result);
            n = result;
            iteration++;
        }
        if (result != 1)
            return false;
        return true;
    }

    //https://leetcode.com/problems/count-primes/
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    private static int nextPrime(int n) {
        if (n <= 1) return 2;
        boolean found = false;
        int prime = n;
        while (!found) {
            prime++;

            if (isPrime(prime))
                found = true;
        }
        return prime;
    }

    public int countPrimes(int n) {
        int count = (int) IntStream.iterate(2, Easy::nextPrime).limit(n).filter(i -> i < n).count();
        return count;
    }

    //https://leetcode.com/problems/valid-anagram/submissions/
    public boolean isAnagram(String s, String t) {
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        for (int i = 0; i < s.length(); i++) {
            freq1[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++)
            freq2[t.charAt(i)]++;

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }
}

