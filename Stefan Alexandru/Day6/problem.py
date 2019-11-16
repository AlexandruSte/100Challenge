# https://www.codewars.com/kata/who-has-the-most-money/train/python
def most_money(students):
    if len(students) == 1:
        return students[0].name
    money = [5 * student.fives + 10 * student.tens + 20 * student.twenties for student in students]
    return 'all' if money[1:] == money[:-1] else students[money.index(max(money))].name
