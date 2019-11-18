# https://www.codewars.com/kata/find-the-unique-number-1/train/python
def find_uniq(arr):
    dict = {}
    for element in arr:
        if element in dict:
            dict[element] += 1
        else:
            dict[element] = 1
    return list(dict.keys())[list(dict.values()).index(1)]

# Too costly
# return list(filter( lambda element: arr.count(element) == 1, arr))[0]
