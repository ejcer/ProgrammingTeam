__author__ = 'emcenrue'
from string import ascii_lowercase
#
dict = dict()

for c in ascii_lowercase:
    dict[c] = 0

k = int(input())
q = input()
list = list()
ans = 0
i = 0
for c in q:
    if dict[c] == 0 and ans < k:
        ans+=1
        dict[c] = 1
        list.append(i)
    i+=1


if ans >= k:
    print("YES")
    if len(list) == 1:
        print(q[list[0]:len(q)])
    for i in range(len(list)-1):
        print(q[list[i]:list[i+1]])
        if i == len(list) - 2:
            print(q[list[i+1]:len(q)])
else:
    print("NO")
