# https://www.codewars.com/kata/maximum-subarray-sum/train/python

def max_sequence(arr):
    if not arr:
        return 0
    if min(arr) >= 0:
        return sum(arr)
    mini = 0
    max_sum = 0
    current_sum = 0
    for nr in arr:
        current_sum += nr
        mini = min(current_sum, mini)
        max_sum = max(max_sum, current_sum - mini)
    return max_sum


print(max_sequence([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
