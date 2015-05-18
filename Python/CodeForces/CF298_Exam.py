__author__ = 'emcenrue'

n = int(input())

if(n == 1):
    print(1,end=' ')
    print(1)
elif(n == 2):
    print(1,end=' ')
    print(1)
elif(n==3):
    print(1, end=' ')
    print(3)
else:
    print(n)
    for i in range(1, n+1):
        if(i%2 == 0):
            print(i, end=' ')
    for i in range(1, n+1):
        if(i%2 == 1):
            print(i,end=' ')

