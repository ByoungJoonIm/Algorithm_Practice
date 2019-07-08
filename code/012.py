for test_case in range(1, 11):
    nums = int(input())
    ls = [int(k) for k in map(int, input().split())]
    amount = 0
    for i in range(2, len(ls)-2, 1):
        if ls[i] < ls[i+2] or ls[i] < ls[i+1]:
            continue 
        sub_sum = ls[i] - max(ls[i-2], ls[i-1], ls[i+1], ls[i+2])
        if sub_sum > 0 :
            amount = amount + sub_sum
    print("#{0} {1}".format(test_case, amount))
