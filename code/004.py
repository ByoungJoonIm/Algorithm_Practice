n = int(input())

for i in range(1, n+1):
    cnt = 0
    tmp = i
    
    while tmp > 0:
        one = tmp % 10
        if one % 3 == 0 and one is not 0:
            cnt+=1
        tmp //= 10
	
    if cnt == 0:
        print(i, end=" ")
    else:
        print('-' * cnt, end=" ")