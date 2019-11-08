def parts_sums(ls):
    array_sum = sum(ls)
    sum_list = [array_sum]
    for number in ls:
        sum_list.append(array_sum - number)
        array_sum -= number
    return sum_list


'''
Too costly on time
    return [sum(ls[i:]) for i in range(len(ls) + 1)]
'''
