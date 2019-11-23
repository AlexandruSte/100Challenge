# https://www.codewars.com/kata/most-valuable-character/train/python


def most_valuable_character(string):
    max_value = -1
    valuable_ch = ''
    for ch in string:
        value = string.rfind(ch) - string.find(ch)
        if value == max_value and ch < valuable_ch:
            valuable_ch = ch
        elif value > max_value:
            max_value = value
            valuable_ch = ch
    return valuable_ch


def most_valuable_timed_out(s):
    if s == '':
        return s
    return min(ch for ch in s if (s.rfind(ch) - s.find(ch)) ==
               max(s.rfind(ch) - s.find(ch) for ch in s))


def clever(st):
    return sorted((st.find(c) - st.rfind(c), c) for c in set(st))[0][1]


print(most_valuable_character('axyzxyz'))
print(most_valuable_character('aabccc'))
print(most_valuable_character('ab'))
print(most_valuable_character('a'))
