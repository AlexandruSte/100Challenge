# https://www.codewars.com/kata/snail/train/python
def snail(snail_map):
    res = []
    while len(snail_map) > 0:
        # first line
        for value in snail_map[0]:
            res.append(value)
        snail_map.remove(snail_map[0])

        if len(snail_map) == 0:
            break

        # last column
        for index in range(len(snail_map)):
            res.append(snail_map[index][len(snail_map)])
            del snail_map[index][len(snail_map)]

        # last line
        for value in snail_map[len(snail_map) - 1][::-1]:
            res.append(value)
        snail_map.remove(snail_map[len(snail_map) - 1])

        # first column
        for index in range(len(snail_map) - 1, -1, -1):
            res.append(snail_map[index][0])
            del snail_map[index][0]
    return res
