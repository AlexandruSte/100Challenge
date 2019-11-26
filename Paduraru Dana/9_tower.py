# https://ww w.codewars.com/kata/576757b1df89ecf5bd00073b/train/python


def build_tower(n):
    floor = '*' * (2 * n - 1)
    floors = [floor]
    spaces = 0  # number of spaces for one side
    while n > 1:
        spaces += 1
        length = len(floor)
        floor = ' ' * spaces + floor[spaces: length - spaces] + ' ' * spaces
        floors.append(floor)
        n -= 1
    floors.sort(key=lambda f: f.count('*'))
    return floors


def build_tower_v2(n_floors):
    if n_floors == 0:
        return []
    result = []
    for i in range(1, n_floors + 1):
        stars = '*' * (2 * i - 1)
        space = ' ' * (n_floors - i)
        result.append(space + stars + space)
    return result


tower = build_tower(3)
print(tower)
