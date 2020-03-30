def add_element_to_matrix(matrix, value, line, column, is_transpose):
    if is_transpose:
        line, column = column, line

    item = (value, column)
    for element in matrix[line]:
        if element[1] == item[1]:
            item = (element[0] + item[0], item[1])
            matrix[line].remove(element)
            break
    matrix[line].append(item)


def read_matrix(filename, include_transpose):
    matrix, transpose = [], []
    file_content = open(filename).readlines()
    for index, line in enumerate(file_content):
        line = line[:-1]
        if index == 0:
            size = int(line)
            for _ in range(size):
                matrix.append([])
            if include_transpose:
                for _ in range(size):
                    transpose.append([])
        else:
            value, line, column = [float(value) for value in line.split(', ')]
            line, column = int(line), int(column)

            add_element_to_matrix(matrix, value, line, column, False)
            if include_transpose:
                add_element_to_matrix(transpose, value, line, column, True)
            if len(matrix[line]) > 11:
                return True, matrix, []
    return False, matrix, transpose


def add_matrix(first, second):
    matrix = []
    if len(first) != len(second):
        print('Matrix can\'t be added with each other.')
    else:
        for _ in range(len(first)):
            matrix.append([])
        for index, line in enumerate(first):
            for element in line:
                matrix[index].append(element)
        for index, line in enumerate(second):
            for element in line:
                element_in_same_line = False
                for matrix_element in matrix[index]:
                    if element[1] == matrix_element[1]:
                        element_in_same_line = True
                        new_value = element[0] + matrix_element[0]
                        matrix[index].remove(matrix_element)
                        matrix[index].append((new_value, element[1]))
                        break
                if not element_in_same_line:
                    matrix[index].append(element)
    return matrix


def multiply_arrays(array1, array2):
    result = 0
    for element1 in array1:
        for element2 in array2:
            if element1[1] == element2[1]:
                result += element1[0] * element2[0]
                break
    return result


def multiply_matrix(first, second):
    matrix = []
    if len(first) != len(second):
        print('Matrix can\'t be multiplied with each other.')
    else:
        for _ in range(len(first)):
            matrix.append([])
        for i in range(len(first)):
            for j in range(len(first)):
                result = multiply_arrays(first[i], second[j])
                if result != 0:
                    matrix[i].append((result, j))
    return matrix


def test_matrix_equality(first, second):
    if len(first) != len(second):
        return False
    for index in range(len(first)):
        for element_first in first[index]:
            for element_second in second[index]:
                if element_first[1] == element_second[1] and element_first[0] != element_second[0]:
                    print('Different elements, on line ' + str(index) + ', column ' + str(
                        element_second[1]))
                    return False
    return True


matrix_a_filename = 'a.txt'
matrix_b_filename = 'b.txt'
matrix_aplusb_filename = 'aplusb.txt'
matrix_aorib_filename = 'aorib.txt'

ok = True
too_big_a, matrix_a, _ = read_matrix(matrix_a_filename, False)
if too_big_a:
    print('Matrix a has more than 10 elements on a line.')
    ok = False

too_big_b, matrix_b, transpose_b = read_matrix(matrix_b_filename, True)
if too_big_b or not ok:
    print('Matrix b has more than 10 elements on b line.')
    ok = False

if ok:
    a_plus_b = add_matrix(matrix_a, matrix_b)
    _, a_plus_b_file, _ = read_matrix(matrix_aplusb_filename, False)
    print('Matrix for addition is correct: ' + str(test_matrix_equality(a_plus_b, a_plus_b_file)))

    a_ori_b = multiply_matrix(matrix_a, transpose_b)
    _, a_ori_b_file, _ = read_matrix(matrix_aorib_filename, False)
    print('Matrix for multiplication is correct: ' + str(test_matrix_equality(a_ori_b, a_ori_b_file)))
