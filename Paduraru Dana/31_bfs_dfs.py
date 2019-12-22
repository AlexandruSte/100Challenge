"""

DefaultDict:


Usually, a Python dictionary throws a KeyError if you try to get an item with a key that is not currently in the
dictionary. The defaultdict in contrast will simply create any items that you try to access (provided of course they
do not exist yet)

"""
from collections import defaultdict


class Graph:
    def __init__(self):
        self.nodes = defaultdict(list)

    def add_edge(self, node_1, node_2):
        self.nodes[node_1].append(node_2)


def breadth_first_search(graph, start_node):
    """
    Time Complexity: O(E + V)
        E = Number of edges
        V = Number of vertices (nodes)
    """
    visited = [False for _ in range(len(graph))]
    visited[start_node] = True
    queue = [start_node]
    while queue:
        node = queue.pop(0)  # pop() gets the last one appended, pop(0) gets the one with index 0
        print(node, end=' ')
        for neighbour in graph[node]:
            if not visited[neighbour]:
                queue.append(neighbour)
                visited[neighbour] = True
    print()


def dfs_recursive(graph, node, visited):
    """
    Time Complexity: O(E + V)
        E = Number of edges
        V = Number of vertices (nodes)
    """
    visited[node] = True
    print(node, end=' ')
    for neighbour in graph[node]:
        if not visited[neighbour]:
            dfs_recursive(graph, neighbour, visited)


def depth_first_search(graph, start_node):
    visited = [False for _ in range(len(graph))]
    dfs_recursive(graph, start_node, visited)
    print()


graph = Graph()
graph.add_edge(0, 1)
graph.add_edge(0, 2)
graph.add_edge(1, 2)
graph.add_edge(2, 0)
graph.add_edge(2, 3)
graph.add_edge(3, 3)
depth_first_search(graph.nodes, 2)
breadth_first_search(graph.nodes, 2)
