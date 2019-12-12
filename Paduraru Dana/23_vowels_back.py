# https://www.codewars.com/kata/vowels-back/train/python

"""
You need to play around with the provided string (s).

Move consonants forward 9 places through the alphabet. If they pass 'z', start again at 'a'.

Move vowels back 5 places through the alphabet. If they pass 'a', start again at 'z'. For our Polish friends this kata does not count 'y' as a vowel.

Exceptions:

If the character is 'c' or 'o', move it back 1 place. For 'd' move it back 3, and for 'e', move it back 4.

If a moved letter becomes 'c', 'o', 'd' or 'e', revert it back to it's original value.

Provided string will always be lower case, won't be empty and will have no special characters.

"""


def vowel_back(s):
    new_s = []
    for ch in s:
        if ch in ['c', 'o']:
            # move it back 1 place
            new_s.append(chr(ord(ch) - 1))
        elif ch in ['d', 'e']:
            # move it back 3 for d and 4 for e => they both become 'a'
            new_s.append('a')
        else:
            if ch in ['a', 'e', 'i', 'o', 'u']:
                # Move vowels back 5 places through the alphabet. If they pass 'a', start again at 'z'.
                shifted = ord(ch.lower()) - 5
                new_ch = chr(shifted) if shifted >= ord('a') else chr(shifted + 26)
            else:
                # Move consonants forward 9 places through the alphabet. If they pass 'z', start again at 'a'.
                shifted = ord(ch.lower()) + 9
                new_ch = chr(shifted) if shifted <= ord('z') else chr((shifted - 26))
            # If a moved letter becomes 'c', 'o', 'd' or 'e', revert it back to it's original value.
            if new_ch in ['c', 'o', 'd', 'e']:
                new_s.append(ch)
            else:
                new_s.append(new_ch)
    return ''.join(new_s)


print(vowel_back('testcase'))
print(vowel_back('codewars'))
print(vowel_back('exampletesthere'))