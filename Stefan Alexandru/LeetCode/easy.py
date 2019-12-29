def romanToInt(s):
    number = 0
    dictt = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    ok = True
    for i in range(len(s)):
        if not ok:
            ok = True
            continue
        if i != len(s) - 1:
            if dictt[s[i]] < dictt[s[i + 1]]:
                number += dictt[s[i + 1]] - dictt[s[i]]
                ok = False
            else:
                number += dictt[s[i]]
        else:
            if dictt[s[i]] <= dictt[s[i - 1]]:
                number += dictt[s[i]]
    return number


# print(romanToInt('III'))


# https://leetcode.com/problems/valid-parentheses/
def isValid(s: str) -> bool:
    dic = {'(': 0, '{': 0, '[': 0}
    oppose = {')': '(', '}': '{', ']': '['}
    last_open = []
    for paranthesis in s:
        if paranthesis not in dic:
            if dic[oppose[paranthesis]] == 0 or last_open[-1] != oppose[paranthesis]:
                return False
            del last_open[-1]
            dic[oppose[paranthesis]] -= 1
        else:
            dic[paranthesis] += 1
            last_open.append(paranthesis)
    return True if not sum([dic[key] for key in dic]) else False


print(isValid("([])"))


# https://leetcode.com/problems/min-stack/submissions/
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.vect = []

    def push(self, x: int) -> None:
        self.vect.append(x)

    def pop(self) -> None:
        del self.vect[-1]

    def top(self) -> int:
        return self.vect[-1]

    def getMin(self) -> int:
        return min(self.vect)


# https://leetcode.com/problems/merge-two-sorted-lists/
# https://leetcode.com/problems/linked-list-cycle/submissions/
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def mergeTwoLists(self, l1, l2):
        final = ListNode(0)
        copy = final
        while l1 and l2:
            if l1.val > l2.val:
                final.next = ListNode(l2.val)
                l2 = l2.next
            else:
                final.next = ListNode(l1.val)
                l1 = l1.next
            final = final.next
        if l1:
            final.next = l1
        else:
            final.next = l2
        return copy.next

    def hasCycle(self, head):
        first, second = head, head
        while first and first.next:
            first, second = first.next.next, second.next
            if first is second:
                return True
        return False


# https://leetcode.com/problems/majority-element/submissions/
def majorityElement(nums):
    summ = len(nums) / 2
    for elem in set(nums):
        if nums.count(elem) > summ:
            return elem


# https://leetcode.com/problems/happy-number/submissions/
def isHappy(n):
    nrs = []
    while n not in nrs:
        nrs.append(n)
        n_str = sum([int(digit) ** 2 for digit in str(n)])
        if n_str == 1:
            return True
        n = ''.join(str(n_str))
    return False


# https://leetcode.com/problems/valid-anagram/submissions/
def isAnagram(self, s, t):
    """
    :type s: str
    :type t: str
    :rtype: bool
    """
    letters = {}
    for letter in s:
        if letter not in letters:
            letters[letter] = 1
        else:
            letters[letter] += 1

    for letter in t:
        if letter not in letters:
            return False
        else:
            letters[letter] -= 1

    for letter in letters:
        if letters[letter] != 0:
            return False

    return True


# https://leetcode.com/problems/merge-sorted-array/submissions/
def merge(nums1, m, nums2, n):
    """
    Do not return anything, modify nums1 in-place instead.
    """
    last, i, j = m + n - 1, m - 1, n - 1

    while i >= 0 and j >= 0:
        if nums1[i] > nums2[j]:
            nums1[last] = nums1[i]
            last, i = last - 1, i - 1
        else:
            nums1[last] = nums2[j]
            last, j = last - 1, j - 1

    while j >= 0:
        nums1[last] = nums2[j]
        last, j = last - 1, j - 1


# https://leetcode.com/problems/rotate-array/submissions/
def rotate(nums, k):
    """
    Do not return anything, modify nums in-place instead.
    """
    a = [0] * len(nums)
    for i in range(0, len(nums)):
        a[(i + k) % len(nums)] = nums[i]
    for i in range(0, len(nums)):
        nums[i] = a[i]


# https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def sortedArrayToBST(self, num):
        return self.sortedArrayToBSTRecu(num, 0, len(num))

    def sortedArrayToBSTRecu(self, num, start, end):
        if start == end:
            return None
        mid = start + (end - start) / 2
        node = TreeNode(num[mid])
        node.left = self.sortedArrayToBSTRecu(num, start, mid)
        node.right = self.sortedArrayToBSTRecu(num, mid + 1, end)
        return node


# https://leetcode.com/problems/count-primes/
from math import sqrt


def countPrimes(n):
    """
    :type n: int
    :rtype: int
    """
    if n <= 2:
        return 0

    is_prime = [True] * n
    sqr = sqrt(n - 1)

    num = 0
    for i in xrange(2, n):
        if is_prime[i]:
            num += 1
            for j in xrange(i + i, n, i):
                is_prime[j] = False

    return num
