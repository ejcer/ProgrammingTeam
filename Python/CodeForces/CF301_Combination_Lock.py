__author__ = 'emcenrue'
from math import floor
#only 10 slots to possibly be used

n = int(input())
s1 = list(map(int, input()))
s2 = list(map(int, input()))

ans = 0
for i in range(n):

    diff = abs(s1[i] - s2[i])
    ans += min(diff, 10-diff)

print(ans)

