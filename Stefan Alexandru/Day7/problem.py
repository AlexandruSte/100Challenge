# https://www.codewars.com/kata/human-readable-duration-format/train/python
def format_duration(seconds):
    periods = {'year': 0, 'day': 0, 'hour': 0, 'minute': 0, 'second': 0}
    values = 0
    days = int(seconds / 86400)
    seconds -= days * 86400
    periods['year'] = int(days / 365)
    periods['day'] = days % 365
    periods['hour'] = int(seconds / 3600)
    seconds -= periods['hour'] * 3600
    periods['minute'] = int(seconds / 60)
    periods['second'] = seconds - periods['minute'] * 60
    s = ''
    for key in periods:
        if periods[key]:
            values += 1
    for key in periods:
        if periods[key]:
            s += str(periods[key]) + ' ' + key
            s += 's' if periods[key] > 1 else ''
            s += ' and ' if values == 2 else '' if values == 1 else ', '
            values -= 1
    return 'now' if s == '' else s
