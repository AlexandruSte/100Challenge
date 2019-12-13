from collections import defaultdict


class Graph:
    def __init__(self):
        self.nodes = defaultdict(list)

    def add_edge(self, u, v):
        self.nodes[u].append(v)


def dfs_recursively(graph, v, visited):
    visited[v] = 1
    print(v, end=' ')
    for neighbour in graph[v]:
        if not visited[neighbour]:
            dfs_recursively(graph, neighbour, visited)


def DFS(graph, v):
    visited = [0 for _ in range(len(graph))]
    dfs_recursively(graph, v, visited)
    print()


def BFS(graph, v):
    visited = [0 for _ in range(len(graph))]
    queue = []
    visited[v] = 1
    queue.append(v)
    while queue:
        s = queue.pop(0)
        print(s, end=' ')
        for neighbour in graph[s]:
            if not visited[neighbour]:
                queue.append(neighbour)
                visited[neighbour] = 1
    print()


graph = Graph()
graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 2)
graph.add_edge(2, 0)
graph.add_edge(2, 3)
graph.add_edge(3, 3)
DFS(graph.nodes, 2)
BFS(graph.nodes, 2)
