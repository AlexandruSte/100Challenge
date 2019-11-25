# https://www.codewars.com/kata/take-a-number-and-sum-its-digits-raised-to-the-consecutive-powers-and-dot-dot-dot-eureka/train/python

# See this property again: 135 = 1^1 + 3^2 + 5^3


def sum_dig_pow(a, b):
    special_numbers = []
    for nr in range(a, b + 1):
        count = 0
        s = 0
        copy = nr
        inversed = str(nr)[::-1]
        nr = int(inversed)
        while nr > 0:
            count += 1
            digit = nr % 10
            s += digit ** count
            nr = int(nr / 10)
        if s == copy:
            special_numbers.append(copy)
    return special_numbers


def filter_func(a):
    return sum(int(d) ** (i + 1) for i, d in enumerate(str(a))) == a


def sum_dig_pow_clever(a, b):
    return filter(filter_func, range(a, b + 1))


print(sum_dig_pow(1, 100))
