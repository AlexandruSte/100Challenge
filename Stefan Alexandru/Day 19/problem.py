# https://www.codewars.com/kata/split-strings/train/python
def solution(s):
    if len(s) == 0:
        return []
    splits = [s[index:index + 2] for index in range(0, len(s), 2)]
    if len(splits[-1]) == 1:
        splits[-1] += '_'
    return splits
