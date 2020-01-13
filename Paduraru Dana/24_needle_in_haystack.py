"""
https://leetcode.com/problems/implement-strstr/

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
"""


def strstr(haystack, needle):
    if not haystack:
        return -1
    if not needle:
        return 0
    if len(needle) > len(haystack):
        return -1
    if haystack == needle:
        return -1
    len_needle = len(needle)
    for index in range(0, len(haystack) - len_needle + 1):
        substring = haystack[index: len_needle + index]
        if substring == needle:
            return index
    return -1


print(strstr("hello", ""))
print(strstr("hello", "bcb"))
print(strstr("hello", "ll"))
print(strstr("hello", "o"))
print(strstr("hellow", "hello"))
print(strstr("hello", "hello"))
