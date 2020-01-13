# https://www.codewars.com/kata/sort-arrays-ignoring-case/train/python


def sort_case_insensitive(words):
    # return sorted(words, key=lambda word: word.lower())
    return sorted(words, key=str.lower)


print(sort_case_insensitive(["CodeWars"]))
print(sort_case_insensitive(["C", "d", "a", "B"]))
print(sort_case_insensitive(["Hello", "there", "I'm", "fine"]))
print(sort_case_insensitive([]))
