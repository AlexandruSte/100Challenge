# https://leetcode.com/discuss/interview-question/396769/
def solution(time):
    s = [digit for digit in time]
    for index, digit in enumerate(time):
        if digit == '?':
            if index == 0:
                s[index] = '1' if int(time[index + 1]) > 3 else '2'
            elif index == 1:
                s[index] = '3' if int(time[index - 1]) > 1 else '9'
            elif index > 2:
                s[index] = '5' if index == 3 else '9'
    return ''.join(s)


print(solution("?4:5?"))
print(solution("23:5?"))
print(solution("2?:22"))
