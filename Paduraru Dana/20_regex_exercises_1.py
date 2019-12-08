# Learning regex in Python - Exercises Part 1 (20 exercises)
import re


# 1. Write a Python program to check that a string contains only a certain set of characters (in this case a-z,
# A-Z and 0-9).


def is_allowed_characters_set(string):
    char_re = re.compile(r'[^a-zA-Z0-9.]')
    string = char_re.search(string)
    return not bool(string)


print(is_allowed_characters_set("ABCDEFabcdef123450"))  # True
print(is_allowed_characters_set("*&%@#!}{"))  # False


# 2. Write a Python program that matches a string that has an a followed by zero or more b's

def a_followed_by_bs(string):
    pattern = '^[A-Z][a-z]+'
    if re.search(pattern, string):
        return True
    return False


print(a_followed_by_bs("accb"))  # True
print(a_followed_by_bs("abbcc"))  # True
"""
3. Write a Python program that matches a string that has an a followed by one or more b's
---> same as the one below but the pattern is:  'ab+?'

4. Write a Python program that matches a string that has an a followed by zero or one 'b'.
---> change pattern to: 'ab?'

5. Write a Python program that matches a string that has an a followed by three 'b'.
---> pattern = 'ab{3}'

6. Write a Python program that matches a string that has an a followed by two to three 'b'.
---> pattern = 'ab{2,3}'

7. Write a Python program to find sequences of lowercase letters joined with a underscore

pattern = '[a-z]+_[a-z]+$'

8. Write a Python program to find sequences of one upper case letter followed by lower case letters

pattern = '^[A-Z][a-z]+'

9. Write a Python program that matches a string that has an 'a' followed by anything, ending in 'b'.

pattern = '^a.*?b$'

10. Write a Python program that matches a word at the beginning of a string.

pattern = '^\w+'

11. Write a Python program that matches a word at end of string, with optional punctuation
???
pattern = '\w+\S*$'

print(text_match("The quick brown fox jumps over the lazy dog.")) # Found a match!                                                                                                
print(text_match("The quick brown fox jumps over the lazy dog. ")) # Not matched!                                                                                                  
print(text_match("The quick brown fox jumps over the lazy dog ")) # Not matched!                                                                                                  

12. Write a Python program that matches a word containing 'z'.

pattern = '\w*z.\w*'
pattern = '\w*z\w*' merge si asta?


13. Write a Python program that matches a word containing 'z', not start or end of the word.
\b \B ?? https://www.regular-expressions.info/wordboundaries.html
pattern = '\Bz\B'

14. Write a Python program to match a string that contains only upper and lowercase letters, numbers, and underscores.

pattern = '^[a-zA-Z0-9_]*$'

15. Write a Python program where a string will start with a specific number.

pattern = '^2'

16. Write a Python program to remove leading zeros from an IP address

ip = "216.08.094.196"
string = re.sub('\.[0]*', '.', ip)

17. Write a Python program to check for a number at the end of a string.
pattern = '.*[0-9]$'
"""

"""
18. Write a Python program to search the numbers (0-9) of length between 1 to 3 in a given string.
"Exercises number 1, 12, 13, and 345 are important"
"""
results = re.finditer(r"([0-9]{1,3})", "Exercises number 1, 12, 13, and 345 are important")
print("Number of length 1 to 3")
for n in results:
    print(n.group(0))

"""
19.  Write a Python program to search some literals strings in a string. Go to the editor
Sample text : 'The quick brown fox jumps over the lazy dog.'
Searched words : 'fox', 'dog', 'horse'
"""
print()
patterns = ['fox', 'dog', 'horse']
text = 'The quick brown fox jumps over the lazy dog.'
for pattern in patterns:
    print('Searching for "%s" in "%s" ->' % (pattern, text), )
    if re.search(pattern, text):
        print('Matched!')
    else:
        print('Not Matched!')

"""
20. Write a Python program to search a literals string in a string and also find the location within the original string where the pattern occurs. 
Sample text : 'The quick brown fox jumps over the lazy dog.'
Searched words : 'fox'
"""
print()
pattern = 'fox'
text = 'The quick brown fox jumps over the lazy dog.'
match = re.search(pattern, text)
s = match.start()
e = match.end()
print('Found "%s" in "%s" from %d to %d ' % \
      (match.re.pattern, match.string, s, e))
