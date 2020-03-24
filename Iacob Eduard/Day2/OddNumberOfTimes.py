# Given an array, find the integer that appears an odd number of times.
# There will always be only one integer that appears an odd number of times.

def find_it(seq):
    duplicates = []
    for i in seq:
        if seq.count(i) % 3 == 0 or seq.count(i) == 1:
            duplicates.append(i)
    duplicates = list(dict.fromkeys(duplicates))
    s = [str(i) for i in duplicates]
    res = int("".join(s))
    return res

print(find_it([20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5]))
