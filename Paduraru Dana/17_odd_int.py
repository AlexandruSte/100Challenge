# https://www.codewars.com/kata/find-the-odd-int/train/python


def find_odd_int(seq):
    for elem in seq:
        if seq.count(elem) % 2:
            return elem


print(find_odd_int([20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5]))
print(find_odd_int([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5]))
print(find_odd_int([10]))
print(find_odd_int([1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1]))
print(find_odd_int([]))
