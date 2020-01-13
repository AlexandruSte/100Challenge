"""
BINARY TREE implementation
"""


class Node:

    def __init__(self, data):
        self.data = data
        self.right = None
        self.left = None


""" ❤ ❤ ❤ ❤ """
""" TRAVERSALS """


# PREORDER
def preorder(root):
    if root:
        print(root.data, end=" ")
        preorder(root.left)
        preorder(root.right)


# INORDER
def inorder(root):
    if root:
        inorder(root.left)
        print(root.data, end=" ")
        inorder(root.right)


# POSTORDER
def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print(root.data, end=" ")


root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)

print("PREORDER Traversal: ", end="")
preorder(root)
print()

print("INORDER Traversal: ", end="")
inorder(root)
print()

print("POSTORDER Traversal: ", end="")
postorder(root)
print()

""" ❤ ❤ ❤ ❤ ❤ ❤ ❤ """
""" SEARCH FOR A NODE """


def search(root, value):
    if root is None or root.data == value:
        return root
    if root.data < value:
        return search(root.right, value)
    return search(root.left, value)


value = 3
if search(root, value):
    print("Found node %d" % value)
else:
    print("Node %d was not found" % value)

value = 8
if search(root, value):
    print("Found node %d" % value)
else:
    print("Node %d was not found" % value)

""" ❤ ❤ ❤ ❤ ❤ ❤ """
""" INSERT NEW NODE """


def insert_node(root, node):
    if root is None:
        root = node
    else:
        if root.data < node.data:
            if root.right is None:
                root.right = node
            else:
                insert_node(root.right, node)
        else:
            if root.left is None:
                root.left = node
            else:
                insert_node(root.left, node)


insert_node(root, Node(6))
print("Preorder after insertion: ", end="")
preorder(root)
print()
