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
    List<Integer> DFS_nodes = new ArrayList<>();

    enum e {VISITED, UNVISITED;}
    enum color {WHITE, GRAY, BLACK}


    public void createGraph(int n) {
        g = new Graph(n);
    }

    public void insertEdge(int x, int y) {
        if (x < g.nodes && y < g.nodes) {
            g.setEdge(x, y);
            g.setEdge(y, x);
        }
    }

    public void insertDirectedEdge(int x, int y) {
        if (x < g.nodes && y < g.nodes) {
            g.setEdge(x, y);
        }
    }

    public void BFS(int source) {
        int n = g.nodes;
        e[] visit = new e[n];
        Queue q = new Queue();
        for (int i = 0; i < n; i++) {
            visit[i] = e.UNVISITED;
        }

        visit[source] = e.VISITED;
        Queue.enqueue(q, source);
        while (q.head != null) {
            int v = Queue.dequeue(q).key;
            BFS_Nodes.add(v);
            for (int i = 0; i < n; i++) {
                if (g.m[v][i] == 1) {
                    if (visit[i] == e.UNVISITED) {
                        visit[i] = e.VISITED;
                        Queue.enqueue(q, i);
                    }
                }
            }
        }

        System.out.print("BFS: ");
        for (Integer i : BFS_Nodes)
            System.out.print(i + " ");
    }

    public void DFS_visit(int source) {
        int n = g.nodes;
        color[] colors = new color[n];
        for (int i = 0; i < n; i++)
            colors[i] = color.WHITE;

        DFS(source, colors);
    }

    public void DFS(int source, color[] colors) {

        int n = g.nodes;
        colors[source] = color.GRAY;
        DFS_nodes.add(source);
        for (int i = 0; i < n; i++) {
            if (g.m[source][i] == 1) {
                if (colors[i] == color.WHITE) {
                    //DFS_nodes.add(i);
                    DFS(i, colors);
                }
            }
        }
        colors[source] = color.BLACK;
    }

    public static void main(String[] args) {
        Graphs graph = new Graphs();
        /* graph.createGraph(7);
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
        graph.insertEdge(5, 6); */

        graph.createGraph(6);

        graph.insertDirectedEdge(0, 1);
        graph.insertDirectedEdge(0, 3);

        graph.insertDirectedEdge(1, 4);
        graph.insertDirectedEdge(2, 5);

        graph.insertDirectedEdge(3, 1);
        graph.insertDirectedEdge(4, 3);
        graph.insertDirectedEdge(4, 2);
        graph.insertDirectedEdge(5, 5);

        //graph.BFS(1);
        graph.DFS_visit(0);
        System.out.print("\nDFS: ");
        for (Integer i : graph.DFS_nodes) {
            System.out.print(i + " ");
        }
    }


}
