# IMPLEMENTING A QUEUE IN PYTHON
# https://www.ics.uci.edu/~pattis/ICS-33/lectures/complexitypython.txt

from collections import deque


# A double-ended queue, or deque, has the feature of adding and removing elements from either end.

class Queue:

    def __init__(self):
        self.queue = deque([])

    def __add__(self, value):
        """
        Adding an element as the last item in a queue
        Worst case complexity: O(1)
        """
        self.queue.append(value)

    def remove(self):
        """
        Removing an element from the front of the queue
        Worst case complexity: O(1)
        """
        return self.queue.popleft()

    def is_empty(self):
        """
        worst case complexity: O(1)
        """
        return not len(self.queue)

    def size(self):
        """
        worst case complexity: O(1)
        """
        return len(self.queue)
