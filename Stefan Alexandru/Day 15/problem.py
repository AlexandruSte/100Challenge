# https://www.codewars.com/kata/strip-comments/train/python
import re


def solution(string, markers):
    strings = re.split('\n', string)
    for marker in markers:
        strings = [s.split(marker)[0] for s in strings]
    strings = [s.rstrip() for s in strings]
    return '\n'.join(strings)
