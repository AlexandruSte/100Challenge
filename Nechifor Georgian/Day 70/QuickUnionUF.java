public class QuickUnionUF {
    private static int[] id;
    private static int[] size;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        //id[i] = j; //simple quick union

        if (i == j) return;
        //weigthed
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
