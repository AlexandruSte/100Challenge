# https://www.codewars.com/kata/find-last-fibonacci-digit-hardcore-version/train/python
def last_fib_digit(n):
    if n > 60:
        n = int(n % 60)
    if n in [1, 2]:
        return 1
    if n % 5 == 0:
        if n % 3 != 0:
            return 5
        else:
            return 0
    first, second, index = 1, 1, 2
    while index != n:
        first, second = second, (first + second) % 10
        index += 1
    return second
