import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Graphs {
    static class Graph {
        int nodes;
        int[][] m;

        public Graph(int nodes) {
            this.nodes = nodes;
            m = new int[nodes][nodes];
        }

        public void setEdge(int x, int y) {
            m[x][y] = 1;
        }
    }

    Graph g;
    private List<Integer> BFS_Nodes = new ArrayList<>();


    public void createGraph(int n) {
        g = new Graph(n);
    }
    public void insertEdge(int x, int y) {
        if(x < g.nodes && y < g.nodes) {
            g.setEdge(x, y);
            g.setEdge(y, x);
        }
    }
    enum e {VISITED, UNVISITED};
    public void BFS(int source) {
        int n = g.nodes;
        e[] visit = new e[n];
        Queue q = new Queue();
        for(int i = 0; i < n; i++) {
            visit[i] = e.UNVISITED;
        }

        visit[source] = e.VISITED;
        Queue.enqueue(q, source);
        while(q.head != null) {
            int v = Queue.dequeue(q).key;
            BFS_Nodes.add(v);
            for(int i = 0; i < n; i++) {
                if(g.m[v][i] == 1) {
                    if(visit[i] == e.UNVISITED) {
                        visit[i] = e.VISITED;
                        Queue.enqueue(q, i);
                    }
                }
            }
        }

        System.out.print("BFS: ");
        for(Integer i: BFS_Nodes)
            System.out.print(i + " ");
    }


    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.createGraph(7);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(1, 4);
        graph.insertEdge(2, 3);
        graph.insertEdge(2, 5);
        graph.insertEdge(3, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 6);
        graph.insertEdge(5, 6);

        graph.BFS(1);
    }


}
