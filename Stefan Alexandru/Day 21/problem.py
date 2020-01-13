# https://www.codewars.com/kata/sort-arrays-ignoring-case/train/python
def sortme(words):
    return sorted(words, key=lambda x: x.lower())
