import random

import numpy as np

array_size = 15
v = [random.randint(0, 100) for i in range(array_size)]
print(v)


# Naive Sort
def naive_sort():
    for i in range(len(v) - 1):
        for j in range(i + 1, len(v)):
            if v[i] > v[j]:
                v[i], v[j] = v[j], v[i]
            yield v


# Bubble Sort
def bubble_sort():
    sorted = False
    while not sorted:
        if sorted:
            break
        sorted = True
        for i in range(len(v) - 1):
            if v[i] > v[i + 1]:
                v[i], v[i + 1] = v[i + 1], v[i]
                sorted = False
            yield v


# Selection Sort
def selection_sort():
    for i in range(len(v) - 1):
        min_nr = min(v[i:])
        pos = np.where(v == min_nr)[0][0]
        v[i], v[pos] = v[pos], v[i]
        yield v
