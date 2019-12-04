# https://www.codewars.com/kata/holiday-i-temperature-in-bali/train/python
def bareable(heat, humidity):
    if humidity > 0.5 or heat > 35:
        return False
    if heat > 25 and humidity > 0.4:
        return False
    return True
