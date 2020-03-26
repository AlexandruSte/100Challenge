public class QuickFindUF {
    private static int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public int find(int q) {
        return id[q];
    }

    public static void main(String[] args) {

    }

}
