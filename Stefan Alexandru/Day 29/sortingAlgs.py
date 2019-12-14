import random

import matplotlib.animation as animation
import matplotlib.pyplot as plt
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


# Insertion Sort
def insertion_sort():
    for i in range(1, len(v)):
        j = i
        while j > 0 and v[j] < v[j - 1]:
            v[j - 1], v[j] = v[j], v[j - 1]
            j -= 1
            yield v


# Doing the graphics
# Day 5
title = "Bubble sort"
generator = bubble_sort()

# Initialize figure and axis.
fig, ax = plt.subplots()
ax.set_title(title)

# Initialize a bar plot. Note that matplotlib.pyplot.bar() returns a
# list of rectangles (with each bar in the bar plot corresponding
# to one rectangle), which we store in bar_rects.
bar_rects = ax.bar(range(len(v)), v, align="edge")

# Set axis limits. Set y axis upper limit high enough that the tops of
# the bars won't overlap with the text label.
ax.set_xlim(0, array_size)
ax.set_ylim(0, int(1.07 * max(v)))

# Place a text label in the upper-left corner of the plot to display
# number of operations performed by the sorting algorithm (each "yield"
# is treated as 1 operation).
text = ax.text(0.02, 0.95, "", transform=ax.transAxes)

# Define function update_fig() for use with matplotlib.pyplot.FuncAnimation().
# To track the number of operations, i.e., iterations through which the
# animation has gone, define a variable "iteration". This variable will
# be passed to update_fig() to update the text label, and will also be
# incremented in update_fig(). For this increment to be reflected outside
# the function, we make "iteration" a list of 1 element, since lists (and
# other mutable objects) are passed by reference (but an integer would be
# passed by value).
# NOTE: Alternatively, iteration could be re-declared within update_fig()
# with the "global" keyword (or "nonlocal" keyword).
iteration = [0]


def update_fig(v, rects, iteration):
    for rect, val in zip(rects, v):
        rect.set_height(val)
    iteration[0] += 1
    text.set_text("# of operations: {}".format(iteration[0]))


def init():
    return 1


anim = animation.FuncAnimation(
    fig,
    init_func=init,
    func=update_fig,
    fargs=(bar_rects, iteration),
    frames=generator,
    interval=1, repeat=False
)

plt.show()

print(v)
