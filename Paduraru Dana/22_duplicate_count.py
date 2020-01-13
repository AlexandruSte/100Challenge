# https://www.codewars.com/kata/counting-duplicates/train/python


def duplicate_count(s):
    s = s.lower()
    count = 0
    found = set()
    for ch in s:
        if s.count(ch) != 1 and ch not in found:
            count += 1
            found.add(ch)
    return count


def duplicate_count_smart(s):
    return len([c for c in set(s.lower()) if s.lower().count(c) > 1])
