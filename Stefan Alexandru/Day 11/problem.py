# https://www.codewars.com/kata/statistics-for-an-athletic-association/train/python
import re


def reformat(seconds):
    hours = int(seconds / 3600)
    seconds = seconds - hours * 3600
    minutes = int(seconds / 60)
    seconds = seconds - minutes * 60
    s = '' + ('0' + str(hours) if hours < 10 else str(hours)) + '|'
    s += ('0' + str(minutes) if minutes < 10 else str(minutes)) + '|'
    s += '0' + str(seconds) if seconds < 10 else str(seconds)
    return s


def stat(strg):
    results = re.findall('[0-9|]+', strg)
    if len(results) == 0:
        return ''
    new = []
    for result in results:
        translation = 0
        for index, number in enumerate(re.findall('[0-9]+', result), 0):
            translation += int(number) * (60 ** (2 - int(index)))
        new.append(translation)
    results = new
    range = max(results) - min(results)
    average = int(sum(results) / len(results))
    results = sorted(results)
    if len(results) % 2 == 1:
        median = results[int(len(results) / 2)]
    else:
        median = int((results[int(len(results) / 2)] + results[int(len(results) / 2 - 1)]) / 2)
    return 'Range: {} Average: {} Median: {}'.format(reformat(range), reformat(average), reformat(median))
