"""
Detect cycle in an undirected graph
"""

from collections import defaultdict


class Graph:

    def __init__(self):
        self.nodes = defaultdict(list)

    def add_edge(self, node_1, node_2):
        self.nodes[node_1].append(node_2)
        self.nodes[node_2].append(node_1)

    def has_cycle(self, node, visited, parent):
        visited[node] = True
        # Recur for all nodes adjacent to this node
        for neighbour in self.nodes[node]:
            if not visited[neighbour]:
                if self.has_cycle(neighbour, visited, node):
                    return True
            # If an adjacent node is visited and not a parent of the current node
            # then, we have a cycle
            elif parent != neighbour:
                return True
        return False

    def is_cyclic_graph(self):
        visited = [False] * len(self.nodes)
        # Call the recursive helper function to detect cycle in different DFS trees
        for node in range(len(self.nodes)):
            if not visited[node]:
                if self.has_cycle(node, visited, -1):
                    return True
        return False


g = Graph()
g.add_edge(1, 0)
g.add_edge(0, 2)
g.add_edge(2, 0)
g.add_edge(0, 3)
g.add_edge(3, 4)

if g.is_cyclic_graph():
    print("Contains cycle")
else:
    print("Does not contain cycle")

g = Graph()
g.add_edge(0, 1)
g.add_edge(1, 2)

if g.is_cyclic_graph():
    print("Contains cycle")
else:
    print("Does not contain cycle")
