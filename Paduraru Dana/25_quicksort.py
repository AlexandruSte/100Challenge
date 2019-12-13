# QUICKSORT


def partition(arr, left, right):
    pivot = arr[right]
    i = left - 1
    for j in range(left, right):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[right] = arr[right], arr[i + 1]

    return i + 1


def quick_sort(arr, left, right):
    if left < right:
        m = partition(arr, left, right)
        quick_sort(arr, left, m - 1)
        quick_sort(arr, m + 1, right)


lis = [5, 8, 1, 3, 6]
quick_sort(lis, 0, len(lis) - 1)
print(lis)
