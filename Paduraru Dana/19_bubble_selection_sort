# BUBBLE SORT & SELECTION SORT


def bubble_sort(lis):
    for i in range(len(lis)):
        for j in range(len(lis)):
            if lis[i] < lis[j]:
                lis[i], lis[j] = lis[j], lis[i]
    return lis


def selection_sort(lis):
    for i in range(len(lis)):
        min_value = lis[i]
        position = i
        # finding minimum value
        for j in range(i + 1, len(lis)):
            if min_value > lis[j]:
                min_value = lis[j]
                position = j
        lis[i], lis[position] = lis[position], lis[i]
    return lis


print(bubble_sort([4, 1, 5, 3]))
print(selection_sort([4, 1, 5, 3]))
