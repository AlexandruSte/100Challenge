# https://www.codewars.com/kata/583203e6eb35d7980400002a/train/python


"""
-Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
-A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
-Every smiling face must have a smiling mouth that should be marked with either ) or D.
"""
from re import findall


def count_smileys(arr):
    smileys = 0
    for s in arr:
        if s[0] in [':', ';']:
            if len(s) == 3 and s[1] in ['-', '~']:
                if s[2] in [')', 'D']:
                    smileys += 1
            elif len(s) == 2 and s[1] in [')', 'D']:
                smileys += 1
    return smileys


def count_smileys_clever(arr):
    eyes = [":", ";"]
    noses = ["", "-", "~"]
    mouths = [")", "D"]
    count = 0
    for eye in eyes:
        for nose in noses:
            for mouth in mouths:
                face = eye + nose + mouth
                count += arr.count(face)
    return count


def count_smileys_regex(arr):
    return len(list(findall(r"[:;][-~]?[)D]", " ".join(arr))))


print(count_smileys([':)', ';(', ';}', ':-D']))
print(count_smileys([';D', ':-(', ':-)', ';~)']))
print(count_smileys([';]', ':[', ';*', ':$', ';-D']))
