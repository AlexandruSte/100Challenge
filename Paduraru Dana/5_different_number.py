# https://www.codewars.com/kata/iq-test/train/python

def iq_test(numbers):
    numbers = [int(number) for number in numbers.split(' ')]
    even_numbers = list(filter(lambda element: element%2 == 0, numbers))
    parity = 1 if len(even_numbers) > 1 else 0 # zero if even
    for index, number in enumerate(numbers, 1):
        if number % 2 == parity:
            return index


def iq_test(numbers):
    e = [int(i) % 2 == 0 for i in numbers.split()]

    return e.index(True) + 1 if e.count(True) == 1 else e.index(False) + 1
