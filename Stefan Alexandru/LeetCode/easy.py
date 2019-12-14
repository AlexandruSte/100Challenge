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


print(romanToInt('III'))
