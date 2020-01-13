# https://www.codewars.com/kata/range-extraction/train/python
def solution(args):
    list, string = [], ''
    for element in args + [args[0] - 1]:
        if len(list) == 0 or element == list[-1] + 1:
            list.append(element)
        else:
            if len(list) <= 2:
                for nr in list:
                    string += str(nr) + ','
            else:
                string += str(list[0]) + '-' + str(list[-1]) + ','
            list = [element]
    return string[:-1]
