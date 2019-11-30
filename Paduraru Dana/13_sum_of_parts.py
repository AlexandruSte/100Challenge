# https://www.codewars.com/kata/sums-of-parts/train/python


def sum_of_parts_clever(ls):
    result = [sum[ls]]
    for item in ls:
        result.append(result[-1] - item)
    return result


def sum_of_parts(ls):
    if not ls:
        return [0]
    sums = [0]
    current_sum = 0
    for i in range(len(ls) - 1, -1, -1):
        current_sum += ls[i]
        sums.append(current_sum)
    return sorted(sums, reverse=True)


print(sum_of_parts([0, 1, 3, 6, 10]))
print(sum_of_parts([1, 2, 3, 4, 5, 6]))
print(sum_of_parts([]))

# parcurgere inversa array:
# for i in range(len(ls)-1, -1, -1)
