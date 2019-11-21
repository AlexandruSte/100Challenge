"""Your task is to make a function that can take any non-negative integer as a argument and return it with its digits
in descending order. Essentially, rearrange the digits to create the highest possible number.

Examples:
Input: 21445 Output: 54421
Input: 145263 Output: 654321
Input: 1254859723 Output: 9875543221
"""


def max_number_from_digits(n):
    if 0 < n < 10:
        return n
    digits = []
    while n > 0:
        digits.append(n % 10)
        n = int(n / 10)
    # sort digits in descending order
    digits = sorted(digits, reverse=True)
    new_n = 0
    for digit in digits:
        new_n = new_n * 10 + digit
    return new_n


def clever(n):
    return int("".join(sorted(str(n), reverse=True)))


print(max_number_from_digits(1254859723))
print(clever(1254859723))
