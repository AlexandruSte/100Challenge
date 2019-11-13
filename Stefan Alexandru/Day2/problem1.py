# https://www.codewars.com/kata/the-hashtag-generator/train/python
import re


def generate_hashtag(s):
    if len(s) == 0 or len(re.sub('[\s+]', '', s)) > 139:
        return False
    res = '#'
    for word in re.findall('[a-zA-Z]+', s):
        res += word.capitalize()
    return res
