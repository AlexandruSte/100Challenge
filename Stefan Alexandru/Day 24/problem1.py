# https://www.algoexpert.io/questions/River%20Sizes
def get_length(matrix, visited, x, y):
    length = 1
    ways = [(0, 1), (0, -1), (-1, 0), (1, 0)]
    positions = [[x, y]]
    while len(positions):
        i, j = positions.pop()
        for way in ways:
            if 0 <= i + way[0] < len(matrix) and 0 <= j + way[1] < len(matrix[i + way[0]]):
                if not visited[i + way[0]][j + way[1]] and matrix[i + way[0]][j + way[1]]:
                    length += 1
                    visited[i + way[0]][j + way[1]] = 1
                    positions.append([i + way[0], j + way[1]])
    return length


def riverSizes(matrix):
    visited = [[0 for _ in matrix[i]] for i in range(0, len(matrix))]
    lengths = []
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if not visited[i][j] and matrix[i][j]:
                lengths.append(get_length(matrix, visited, i, j))
    return list(map(lambda x: x if x == 1 else x - 1, lengths))
