

def read_matrix(filename):
    matrix = []
    size = 0
    file_content = open(filename).readlines()
    for index, line in enumerate(file_content):
        line = line[:-1]
        if index == 0:
            size = int(line)
            for _ in range(size):
                matrix.append([])
        else:
            line_content = [float(value) for value in line.split(', ')]
            item = (line_content[0], int(line_content[2]))
            for element in matrix[int(line_content[1])]:
                if element[1] == item[1]:
                    item = (element[0] + item[0], item[1])
                    matrix[int(line_content[1])].remove(element)
                    break
            matrix[int(line_content[1])].append(item)
            if len(matrix[int(line_content[1])]) > 10:
                return True, size, matrix
    return False, size, matrix


def add_matrix(first, second):
    matrix = []
    if size_a != size_b:
        print('Matrix can\'t be added with each other.')
    else:
        for _ in range(size_a):
            matrix.append([])
        for index, line in enumerate(first):
            for element in line:
                matrix[index].append(element)
        for index, line in enumerate(second):
            for element in line:
                in_line = False
                for matrix_element in matrix[index]:
                    if element[1] == matrix_element[1]:
                        in_line = True
                        new_value = element[0] + matrix_element[0]
                        matrix[index].remove(matrix_element)
                        matrix[index].append((new_value, element[1]))
                        break
                if not in_line:
                    matrix[index].append(element)
    return matrix


def get_column_from_matrix(matrix, col):
    array = []
    for line in matrix:
        for element in line:
            if element[1] == col:
                array.append(element)
                break
    return array


def multiply_matrix(first, second):
    matrix = []
    if size_a != size_b:
        print('Matrix can\'t be multiplied with each other.')
    else:
        for _ in range(size_a):
            matrix.append([])
        for index_line in range(len(matrix)):
            line_first = first[index_line]
            for index_column in range(len(matrix)):
                column_second = get_column_from_matrix(second, index_column)
                new_element = 0
                for line_elem in line_first:
                    for col_elem in column_second:
                        if line_elem[1] == col_elem[1]:
                            new_element += line_elem[0] * col_elem[0]
                if new_element != 0:
                    matrix[index_line].append((new_element, index_column))
    return matrix


def test_matrix_equality(first, second):
    if len(first) != len(second):
        return False
    for index_first, line_first in enumerate(first):
        for index_second, line_second in enumerate(second):
            if index_first == index_second:
                if len(line_first) != len(line_second):
                    return False
                for element_first in line_first:
                    for element_second in line_second:
                        if element_first[1] == element_second[1] and element_first[0] != element_second[0]:
                            return False
                break
    return True


matrix_a_filename = 'a.txt'
matrix_b_filename = 'b.txt'
matrix_aplusb_filename = 'aplusb.txt'
matrix_aorib_filename = 'aorib.txt'

ok = True
too_big_a, size_a, matrix_a = read_matrix(matrix_a_filename)
# if too_big_a:
#     print('Matrix a has more than 10 elements on a line.')
#     ok = False

too_big_b, size_b, matrix_b = read_matrix(matrix_b_filename)
# if too_big_b or not ok:
#     print('Matrix a has more than 10 elements on b line.')
#     ok = False

# if ok:
#     a_plus_b = add_matrix(matrix_a, matrix_b)

a_plus_b = add_matrix(matrix_a, matrix_b)
_, _, a_plus_b_file = read_matrix(matrix_aplusb_filename)
print('Matrix for addition is correct: ' + str(test_matrix_equality(a_plus_b, a_plus_b_file)))

a_ori_b = multiply_matrix(matrix_a, matrix_b)
_, _, a_ori_b_file = read_matrix(matrix_aorib_filename)
print('Matrix for multiplication is correct: ' + str(test_matrix_equality(a_ori_b, a_ori_b_file)))

# for index, line in enumerate(a_plus_b):
#     if index > 2:
#         break
#     print(line)
