# https://www.codewars.com/kata/split-and-then-add-both-sides-of-an-array-together/train/python
def split_and_add(numbers, n):
    while len(numbers) > 1 and n > 0:
        listt = []
        if len(numbers) % 2:
            listt.append(numbers[int(len(numbers) / 2)])
            del numbers[int(len(numbers) / 2)]
        for i in range(0, int(len(numbers) / 2)):
            listt.append(numbers[i] + numbers[int(len(numbers) / 2) + i])
        numbers = listt
        n -= 1
    return numbers
