# https://www.codewars.com/kata/tribonacci-sequence/train/python
def tribonacci(signature, n):
    while len(signature) < n:
        signature.append(signature[-1] + signature[-2] + signature[-3])
    return signature[0:n]
