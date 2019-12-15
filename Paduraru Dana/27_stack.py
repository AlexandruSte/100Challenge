# IMPLEMENTING A STACK

# LIFO - Last in, first out


class Stack:

    def __init__(self):
        self.stack_list = []

    def __add__(self, value):
        """
        add element on last position
        time complexity: O(1)
        """

    def remove(self):
        """
        o(1)
        """

        return self.stack_list.pop()

    def is_empty(self):
        # o(1)
        return not self.size()

    def size(self):
        # o(1)
        return len(self.stack_list)
