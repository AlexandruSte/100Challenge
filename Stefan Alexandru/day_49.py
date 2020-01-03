#https://www.codewars.com/kata/sum-of-digits-slash-digital-root/train/python
def digital_root(n):
    sum = 0
    first_run = True
    while sum > 10 or first_run:
        sum = 0
        first_run = False
        while n:
            sum += n % 10
            n = int(n/10)
        n = sum
    return n
