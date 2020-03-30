#You get a list of nodes. Return the sorted list of nodes without any duplicates.
def remove_duplicate(arr):
    print([i for n, i in enumerate(arr) if i not in arr[n+1:]])

Nodes=[
    {'data': {'id': 'A'}},
    {'data': {'id': 'A'}},
    {'data': {'id': 'A'}},
    {'data': {'id': 'A'}},
    {'data': {'id': 'B'}},
    {'data': {'id': 'B'}},
    {'data': {'id': 'D'}},
    {'data': {'id': 'D'}},
    {'data': {'id': 'B'}},
    {'data': {'id': 'B'}},
    {'data': {'id': 'B'}},
    {'data': {'id': 'B'}},
    {'data': {'id': 'E'}},
    {'data': {'id': 'E'}}]
remove_duplicate(Nodes)
