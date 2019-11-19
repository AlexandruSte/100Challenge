# https://www.codewars.com/kata/525f50e3b73515a6db000b83/train/python
def create_phone_number(n):
    phone_number = '(' + ''.join([str(digit) for digit in n[0:3]]) + ') '
    phone_number += ''.join([str(digit) for digit in n[3:6]]) + '-'
    phone_number += ''.join([str(digit) for digit in n[6:10]])
    return phone_number


'''
Outsmarted me
return "({}{}{}) {}{}{}-{}{}{}{}".format(*n)
'''
