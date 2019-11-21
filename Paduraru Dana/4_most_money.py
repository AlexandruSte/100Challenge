"""You're going on a trip with some students and it's up to you to keep track of how much money each Student has.
 A student is defined like this:

class Student:
    def __init__(self, name, fives, tens, twenties):
        self.name = name
        self.fives = fives
        self.tens = tens
        self.twenties = twenties

As you can tell, each Student has some fives, tens, and twenties. Your job is to return the name of the student
 ith the most money. If every student has the same amount, then return "all".

Notes:
    Each student will have a unique name
    There will always be a clear winner: either one person has the most, or everyone has the same amount
    If there is only one student, then that student has the most money
"""


class Student:
    def __init__(self, name, fives, tens, twenties):
        self.name = name
        self.fives = fives
        self.tens = tens
        self.twenties = twenties


def most_money(students):
    if len(students) == 1:
        return students[0].name
    name = ""
    max_money = 0
    same_amount = 0
    for student in students:
        sum = student.fives * 5 + student.tens * 10 + student.twenties * 20
        if sum > max_money:
            max_money = sum
            name = student.name
            same_amount = 1
        elif sum == max_money:
            same_amount += 1
    if same_amount == len(students):
        return 'all'
    return name


def clever(students):
    total = []
    for student in students:
        total.append((student.fives * 5) + (student.tens * 10) + (student.twenties * 20))

    if min(total) == max(total) and len(students) > 1:
        return "all"
    else:
        return students[total.index(max(total))].name


phil = Student("Phil", 2, 2, 1)
cam = Student("Cameron", 2, 2, 0)
geoff = Student("Geoff", 0, 3, 0)

print((most_money([cam, geoff, phil])))
print((most_money([cam, geoff])))
