# https://leetcode.com/discuss/interview-question/356520
def solution(s, e):
    chairs_needed = 0
    guests = sorted((zip(s, e)), key=lambda x: x[0])
    for hour in range(min(s), max(s) + 1):
        current_hour_chairs = 0
        for guest in guests:
            if guest[0] <= hour < guest[1]:
                current_hour_chairs += 1
        chairs_needed = max(current_hour_chairs, chairs_needed)
    return chairs_needed


print(solution([1, 2, 6, 5, 3], [5, 5, 7, 6, 8]))
