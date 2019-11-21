"""
Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of
characters then it should replace the missing second character of the final pair with an underscore ('_').

Examples:

solution('abc') # should return ['ab', 'c_']
solution('abcdef') # should return ['ab', 'cd', 'ef']
"""


def split_string_into_pairs(string):
    if len(string) % 2:
        string += '_'
    return list(string[index: index + 2] for index in range(0, len(string), 2))


print(split_string_into_pairs("abcd"))
print(split_string_into_pairs("abcde"))
print(split_string_into_pairs(""))
