# https://www.codewars.com/kata/5277c8a221e209d3f6000b56/train/python


def is_valid_clever(s):
    while '{}' in s or '()' in s or '[]' in s:
        s = s.replace('{}', '')
        s = s.replace('[]', '')
        s = s.replace('()', '')
    return s == ''


def is_valid(braces):
    valid = ['()', '[]', '{}']
    while 1:
        found = False
        for pair in valid:
            if pair in braces:
                braces = braces.replace(pair, '')
                found = True
        if braces == '':
            return True
        elif not found and braces != '':
            return False


print(is_valid("(){}[]"))
print(is_valid("([{}])"))
print(is_valid("(}"))
print(is_valid("[(])"))
print(is_valid("[({})](]"))
