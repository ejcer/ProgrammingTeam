__author__ = 'emcenrue'

n=int(input())
s=1
i=2
while n>=s:
   n-=s
   s+=i
   i+=1
print(i-2)