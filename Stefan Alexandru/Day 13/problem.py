# https://www.codewars.com/kata/iq-test/train/python
import re


def iq_test(numbers):
    numbers = [int(nr) for nr in re.findall('[0-9]+', numbers)]
    number = list(filter(lambda x: x % 2, numbers))
    if len(number) != 1:
        number = list(filter(lambda x: not x % 2, numbers))
    return numbers.index(number[0]) + 1
