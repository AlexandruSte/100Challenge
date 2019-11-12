# https://www.codewars.com/kata/numericals-of-a-string/train/python
def numericals(s):
    dict = {}
    res = ''
    for letter in s:
        if letter in dict:
            dict[letter] += 1
        else:
            dict[letter] = 1
        res += str(dict[letter])
    return res
