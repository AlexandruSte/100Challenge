# https://www.codewars.com/kata/valid-parentheses/train/python


def valid_parentheses(string):
    string = ''.join(c for c in string if c in ['(', ')'])
    while '()' in string:
        string = string.replace('()', '')
    if string == '':
        return True
    return False


print(valid_parentheses(")(()))"))
print(valid_parentheses("(())((()())())"))
print(valid_parentheses("hi())("))
print(valid_parentheses("hi(hi)()"))


def valid_parentheses_2(string):
    counter = 0
    for ch in string:
        if ch == '(':
            counter += 1
        elif ch == ')':
            counter -= 1
        if counter < 0:
            return False
    if counter == 0:
        return True
    return False


print()
print(valid_parentheses_2(")(()))"))
print(valid_parentheses_2("(())((()())())"))
print(valid_parentheses_2("hi())("))
print(valid_parentheses_2("hi(hi)()"))
