# https://www.codewars.com/kata/meeting/train/python
def meeting(s):
    s = [st.upper() for st in s.split(';')]
    s = sorted(s, key=lambda x: x.split(':')[1])
    for i in range(0, len(s) - 1):
        for j in range(i + 1, len(s)):
            if s[i].split(':')[1] == s[j].split(':')[1] and s[i].split(':')[0] > s[j].split(':')[0]:
                s[i], s[j] = s[j], s[i]
    return ''.join(['({}, {})'.format(st.split(':')[1], st.split(':')[0]) for st in s])
