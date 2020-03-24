# Binary with 0 and 1 is good, but binary with only 0 is even better! Originally, this is a concept designed by Chuck Norris to send so called unary messages.
# Can you write a program that can send and receive this messages?
# Rules
# The input message consists of ASCII characters between 32 and 127 (7-bit)
# The encoded output message consists of blocks of 0
# A block is separated from another block by a space
# Two consecutive blocks are used to produce a series of same value bits (only 1 or 0 values):
# First block is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
# The number of 0 in the second block is the number of bits in the series
# Example
# Let’s take a simple example with a message which consists of only one character (Letter 'C').
# 'C' in binary is represented as 1000011, so with Chuck Norris’ technique this gives:
# 0 0 - the first series consists of only a single 1
# 00 0000 - the second series consists of four 0
# 0 00 - the third consists of two 1
# So 'C' is coded as: 0 0 00 0000 0 00

from re import compile

REGEX1 = compile(r"0+|1+").findall
REGEX2 = compile(r"(0+) (0+)").findall
binary = "{:07b}".format

def send(s):
    temp = ''.join(binary(ord(c)) for c in s)
    return ' '.join("0 " + '0'*len(x) if x[0] == '1' else "00 " + x for x in REGEX1(temp))

def receive(s):
    temp = ''.join(y if x == '00' else '1'*len(y) for x,y in REGEX2(s))
    return ''.join(chr(int(temp[i:i+7], 2)) for i in range(0, len(temp), 7))

print(send(':)'))
print(receive("00 0 0 000 00 0 0 0 00 00 0 0 00 0 0 0 00 00 0 0"))
