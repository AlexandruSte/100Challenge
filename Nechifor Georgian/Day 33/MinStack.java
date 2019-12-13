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
        if(top < 0) return 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i <= top; i++)
            minValue = Integer.min(minValue, a[i]);
        return minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
