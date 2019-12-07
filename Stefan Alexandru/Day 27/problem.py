# https://leetcode.com/discuss/interview-question/421787/
def solution(rooms):
    bookings = {}
    for booking in rooms:
        if booking[0] == '+':
            if booking not in bookings:
                bookings[booking] = 0
            bookings[booking] += 1
    return sorted(bookings.items(), key=lambda x: (-x[1], x[0]))[0][0][1:]


print(solution(['+1A', '+3E', '-1A', '+4F', '+1A', '-3E']))
