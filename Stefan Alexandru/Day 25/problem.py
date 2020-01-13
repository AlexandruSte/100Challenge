# https://leetcode.com/discuss/interview-question/394347/
def water_plants(plants, capacity1, capacity2):
    refills = 2
    water1, water2 = capacity1, capacity2
    left, right = 0, -1
    while left <= int(len(plants) / 2):
        if left + abs(right) == len(plants):
            if water1 + water2 != plants[left]:
                refills += 1
        else:
            if water1 >= plants[left]:
                water1 -= plants[left]
            else:
                water1 = capacity1 - plants[left]
                refills += 1
            if water2 >= plants[right]:
                water2 -= plants[right]
            else:
                water2 = capacity2 - plants[right]
                refills += 1
        left, right = left + 1, right - 1
    return refills
