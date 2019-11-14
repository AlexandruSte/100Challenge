# https://www.codewars.com/kata/sum-of-intervals/train/python
def sum_of_intervals(intervals):
    numbers = []
    for interval in intervals:
        for i in range(interval[0], interval[1]):
            numbers.append(i)
    return len(set(numbers))
