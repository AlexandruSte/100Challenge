# https://www.codewars.com/kata/help-the-bookseller/train/python
def stock_list(listOfArt, listOfCat):
    if not len(listOfArt):
        return ''
    dictt = dict(zip(listOfCat, [0] * len(listOfCat)))
    for book in listOfArt:
        for category in listOfCat:
            if category == book.split(' ')[0][0]:
                if category not in dictt:
                    dictt[category] = 0
                dictt[category] += int(book.split(' ')[1])
    s = ' '.join(['({} : {}) -'.format(key, value) for (key, value) in dictt.items()])
    return s[:len(s) - 2]
