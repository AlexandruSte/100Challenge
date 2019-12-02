# https://www.codewars.com/kata/meeting/train/python


def meeting(s):
    s = s.upper()
    names = []
    for full_name in s.split(';'):
        name = full_name.split(':')
        names.append('(' + name[1] + ', ' + name[0] + ')')
    names.sort()
    output = ''
    for name in names:
        output += name
    return output


string = 'Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill'
meeting(string)
string = 'Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern' \
         ';Megan:Stan;Alex:Korn '
meeting(string)
# should equal '(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ,
# VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)'
