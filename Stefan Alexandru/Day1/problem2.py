# https://www.codewars.com/kata/numericals-of-a-string/train/python
def numericals(s):
    dict = {}
    res = ''
    for letter in s:
        if letter in dict:
            res += str(dict[letter] + 1)
            dict[letter] += 1
        else:
            res += '1'
            dict[letter] = 1
    return res
