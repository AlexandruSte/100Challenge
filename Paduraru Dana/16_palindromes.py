# https://www.codewars.com/kata/58ba6fece3614ba7c200017f


def is_palindrome_1(number):
    if type(number) != int or number < 0:
        return 'Not valid'
    return str(number) == (str(number))[::-1]
    # return str(num) == str(num)[::-1] if type(num) == int and num > 0 else "Not valid"


# print(is_palindrome('5'))
# print(is_palindrome(5))
# print(is_palindrome(53))
# print(is_palindrome(535))

# https://www.codewars.com/kata/numerical-palindrome-number-1-dot-5

# For this kata, single digit numbers will not be considered numerical palindromes

def palindrome_seq(num, k):
    if type(num) != int or type(k) != int or num < 0 or k < 0:
        return 'Not valid'
    palindromes = []
    number = max(num, 11)
    while k > 0:
        if str(number) == (str(number))[::-1]:
            palindromes.append(number)
            k -= 1
        number += 1
    return palindromes


print(palindrome_seq(6, 4))
print(palindrome_seq(59, 3))
print(palindrome_seq(1221, "8"))


