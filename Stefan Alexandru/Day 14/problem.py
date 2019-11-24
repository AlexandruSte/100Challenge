# https://www.codewars.com/kata/sudoku-solution-validator/train/python
def validSolution(board):
    lines = []
    # lines
    for line in board:
        values = [line.count(x) for x in line]
        if len(list(filter(lambda x: x > 1, values))):
            return False

    # columns
    for column in range(0, 9):
        values = []
        for line in board:
            values.append(line[column])
        values = [values.count(x) for x in values]
        if len(list(filter(lambda x: x > 1, values))):
            return False

    # 3x3
    for line in range(0, 8, 3):
        for column in range(0, 8, 3):
            values = []
            for index_line in range(0, 3):
                for index_column in range(0, 3):
                    values.append(board[line + index_line][column + index_column])
            values = [values.count(x) for x in values]
            if len(list(filter(lambda x: x > 1, values))):
                return False

    return True
