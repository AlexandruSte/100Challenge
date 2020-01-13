"""
BINARY SEARCH
"""


def binary_search(sequence, elem):
    left = 0
    right = len(sequence) - 1
    while right >= left:
        mid = (left + right) // 2
        if sequence[mid] < elem:
            left = mid + 1
        elif sequence[mid] > elem:
            right = mid - 1
        else:
            return True
    return False

"""
Primesti o lista de zero-uri urmate de cifre de 1
Lista va arata asa: [0, 0, 0, ... , 0, 1, ... , 1]
Cazuri partculare in care poate arata lista: [0, 0, ... ] (doar zero-uri) sau doar 1-uri
Nu se va intampla sa urmeze vreun 0 dupa un 1

CERINTA:
Gasiti pozitia pe care se afla primul 1.
Daca nu exista, se va afisa "Not found"
"""


def find_first_one(sequence):
    if sequence[0] == 1:
        return 0
    left = 1
    right = len(sequence) - 1
    while right >= left:
        mid = (left + right) // 2
        if sequence[mid] == 1 and sequence[mid - 1] == 1:
            right = mid - 1
        elif sequence[mid] == 1 and sequence[mid - 1] == 0:
            return mid
        elif sequence[mid] == 0 and sequence[mid - 1] == 0:
            left = mid + 1
    return 'Not found'


print(find_first_one([0, 0, 0, 0, 1, 1, 1]))
print(find_first_one([0, 1, 1, 1]))
print(find_first_one([0, 0, 0]))
print(find_first_one([1, 1]))
