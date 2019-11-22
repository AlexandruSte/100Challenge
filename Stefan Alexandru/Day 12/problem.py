# https://www.codewars.com/kata/extract-the-domain-name-from-a-url-1/train/python
import re


def domain_name(url):
    values, index = re.findall('[0-9a-zA-Z\-]+', url), 0
    if 'www' in values:
        index += 1
    if 'http' in values:
        index += 1
    elif 'https' in values:
        index += 1
    return values[index]


'''
return url.split("//")[-1].split("www.")[-1].split(".")[0]
'''
