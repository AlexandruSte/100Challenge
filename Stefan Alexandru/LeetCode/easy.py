def romanToInt(s):
    number = 0
    dictt = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    ok = True
    for i in range(len(s)):
        if not ok:
            ok = True
            continue
        if i != len(s) - 1:
            if dictt[s[i]] < dictt[s[i + 1]]:
                number += dictt[s[i + 1]] - dictt[s[i]]
                ok = False
            else:
                number += dictt[s[i]]
        else:
            if dictt[s[i]] <= dictt[s[i - 1]]:
                number += dictt[s[i]]
    return number


# print(romanToInt('III'))


# https://leetcode.com/problems/valid-parentheses/
def isValid(s: str) -> bool:
    dic = {'(': 0, '{': 0, '[': 0}
    oppose = {')': '(', '}': '{', ']': '['}
    last_open = []
    for paranthesis in s:
        if paranthesis not in dic:
            if dic[oppose[paranthesis]] == 0 or last_open[-1] != oppose[paranthesis]:
                return False
            del last_open[-1]
            dic[oppose[paranthesis]] -= 1
        else:
            dic[paranthesis] += 1
            last_open.append(paranthesis)
    return True if not sum([dic[key] for key in dic]) else False


print(isValid("([])"))


# https://leetcode.com/problems/min-stack/submissions/
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.vect = []

    def push(self, x: int) -> None:
        self.vect.append(x)

    def pop(self) -> None:
        del self.vect[-1]

    def top(self) -> int:
        return self.vect[-1]

    def getMin(self) -> int:
        return min(self.vect)
