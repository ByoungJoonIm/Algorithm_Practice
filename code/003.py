cnt = int(input())
for i in range(0, cnt):
    s=0
    n = int(input())    
    a_ls = [int(k) for k in map(int, input().split())]
    max_val_index = -1
    for j in range(0, n-1):
        if max_val_index < j:
            max_val_index = j
            for d in range(j, n):
                if a_ls[d] > a_ls[max_val_index]:
                    max_val_index = d
        sub_s = a_ls[max_val_index] - a_ls[j]
        if sub_s > 0:
            s += sub_s
    print("#{0} {1}".format(i+1, s))
