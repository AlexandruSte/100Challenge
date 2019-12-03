# https://www.codewars.com/kata/find-the-odd-int/train/python
def find_it(seq):
    return list(filter(lambda x: seq.count(x) % 2, seq))[0]
