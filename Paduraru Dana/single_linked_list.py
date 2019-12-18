class Node:

    def __init__(self, value=None, next=None):
        self.value = value
        self.next = next

    def set_value(self, value):
        self.value = value

    def get_value(self):
        return self.value

    def set_next(self, next):
        self.next = next

    def get_next(self):
        return self.next


class SingleLinkedList:

    def __init__(self):
        self.head = None
        self.size = 0

    def add_node(self, value):
        # O(N)
        node = Node(value)
        node.set_next(self.head)
        self.head = node
        self.size += 1

    def find_node(self, value, remove=False):
        current = self.head
        previous = None

        while current:
            if current.value == value:
                break
            else:
                previous = current
                current = current.next

        if remove and current:
            if previous is None:  # head node
                self.head = current.next
            else:
                previous.set_next(current.next)
        self.size -= 1

        return current is not None

    def remove(self, value):
        # O(N)
        return self.find_node(value, remove=True)

    def search(self, value):
        # O(N)
        return self.find_node(value)

    def size(self):
        return self.size
