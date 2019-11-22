class Edge {
    int x;
    int y;
    List<Edge> edgeList;

    Edge(int x, int y) {
        this.x = x;
        this.y = y;
        edgeList = new ArrayList<Edge>();
    }

    Edge() {
        super();
    }

    @Override
    public String toString() {
        return this.x + " " + this.y;
    }
}

public class Solution {
    boolean visited[];
    List<Edge> edgeList = new ArrayList<Edge>();
    int[][] matrix;

    private void createGraph() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1)
                    edgeList.add(new Edge(i, j));
            }
        }
    }

    private void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (Edge e : edgeList) {
            if (e.x == start) {
                if (visited[e.y] == false)
                    dfs(e.y);
            }
        }
    }

    private void bfs(int start) {
        LinkedList<Integer> root = new LinkedList<Integer>();
//        Stack<Integer> root = new Stack<Integer>();
        root.add(start);
//        root.push(start);
        visited[start] = true;
        while (root.size() != 0) {
//            int node = root.pop();
            int node = root.poll();
            visited[node] = true;

            System.out.print(node + " ");
            for (Edge e : edgeList) {
                if (e.x == node && !visited[e.y])
//                    root.push(e.y);
                    root.add(e.y);
            }
        }
    }
}
