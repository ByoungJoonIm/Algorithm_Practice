T = int(input())

for test_case in range(1, T + 1):
    n, hex = map(str, input().split())
    buf = ''
    for a in hex:
        if a <= '9' and a >= '0' :
            tar = ord(a) - ord('0')
        else:
            tar = ord(a) - ord('A') + 10
            
        for i in range(3,-1,-1):
            if (tar & (1 << i)):
                buf += '1'
            else:
                buf += '0'
                
    print("#{0} {1}".format(test_case, buf))
