__author__ = 'emcenrue'
from math import pow
from math import ceil
n, k = list(map(int, input().split()))

tot = 0
if k <= ceil(pow(n, 2)/2):
    print("YES")
    for i in range(n):
        for j in range(n):
            if(tot < k):
                if(k%2 == 1):
                    if i%2 == 0 and j%2 == 0:
                        print("L", end='')
                        tot+=1
                    elif i%2 == 0 and j%2 == 1:
                        print("S", end='')
                    elif i%2 == 1 and j%2 == 0:
                        print("S", end='')
                    elif i%2 == 1 and j%2 == 1:
                        print("L", end='')
                        tot+=1
                else:
                    if i%2 == 0 and j%2 == 0:
                        print("S", end='')
                    elif i%2 == 0 and j%2 == 1:
                        print("L", end='')
                        tot+=1
                    elif i%2 == 1 and j%2 == 0:
                        print("L", end='')
                        tot+=1
                    elif i%2 == 1 and j%2 == 1:
                        print("S", end='')
            else:
                if i%2 == 0 and j%2 == 0:
                    print("S", end='')
                elif i%2 == 0 and j%2 == 1:
                    print("S", end='')
                elif i%2 == 1 and j%2 == 0:
                    print("S", end='')
                elif i%2 == 1 and j%2 == 1:
                    print("S", end='')
        print()
else:
    print("NO")
