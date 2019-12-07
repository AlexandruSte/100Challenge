# INSERTION SORT


def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        k = i - 1
        # Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
        while k >= 0 and key < arr[k]:
            arr[k + 1] = arr[k]
            k -= 1
        arr[k + 1] = key
    return arr


print(insertion_sort([1, 8, 3, 56, 2]))
