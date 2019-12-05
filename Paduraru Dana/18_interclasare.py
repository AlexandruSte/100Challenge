# INTERCLASARE


def interclasare(a, b):
    c = []
    i = j = 0
    while i < len(a) and j < len(b):
        if a[i] < b[j]:
            c.append(a[i])
            i += 1
        else:
            c.append(b[j])
            j += 1

    if i <= len(a):
        for k in range(i, len(a)):
            c.append(a[k])
    if j <= len(b):
        for k in range(j, len(b)):
            c.append(b[k])
    return c


print(interclasare(a=[3, 5, 6, 7], b=[1, 4, 8]))
