# https://www.codewars.com/kata/playing-with-passphrases/train/python

alph = 'abcdefghijklmnopqrstuvwxyz'


def play_pass(s, n):
    # shift each letter by a given number but the transformed letter must be a letter (circular shift)
    new_s = []
    for ch in s.lower():
        if ch in alph:  # if the char is not a space ""
            new_s.append(alph[(alph.index(ch) + n) % 26])
        elif ch.isdigit():
            # replace each digit by its complement to 9
            new_s.append(str(9 - int(ch)))
        else:
            new_s.append(ch)  # if space the simply append it to data
    shifted = ''.join(new_s)
    # downcase each letter in odd position, upcase each letter in even position
    new_s = []
    index = 0
    for ch in shifted:
        if index % 2 == 0:
            new_s.append(ch.upper())
        else:
            new_s.append(ch)
        index += 1

    # reverse the whole thing
    return (''.join(new_s))[::-1]


print(play_pass("I LOVE YOU!!!", 1))
print(play_pass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2))


def pretty_version(s, n):
    # Step 1, 2, 3
    shift_text = ""
    for char in s:
        if char.isdigit():
            shift_text += str(9 - int(char))
        elif char.isalpha():
            shifted = ord(char.lower()) + n
            shift_text += chr(shifted) if shifted <= ord('z') else chr(shifted - 26)
        else:
            shift_text += char

    # Step 4
    case_text = ""
    for i in range(len(shift_text)):
        case_text += shift_text[i].upper() if i % 2 == 0 else shift_text[i].lower()

    # Step 5
    return case_text[::-1]
