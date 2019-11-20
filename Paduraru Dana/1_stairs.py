# Link to problem:
# https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_r=profile


def stairs(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    a, b, c = 1, 2, 4
    steps = 4
    ways = 0
    while steps <= n:
        ways = a + b + c
        a = b
        b = c
        c = ways
        steps += 1
    return ways


# times out for big numbers
def stairs_recursive(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    return stairs_recursive(n - 1) + stairs_recursive(n - 2) + stairs_recursive(n - 3)


print(stairs_recursive(5))
print(stairs(4))
