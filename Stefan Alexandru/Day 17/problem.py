# https://www.codewars.com/kata/build-a-pile-of-cubes/train/python
def find_nb(m):
    for value in range(1, m):
        m -= value ** 3
        if m == 0:
            return value
        elif m < 0:
            return -1
