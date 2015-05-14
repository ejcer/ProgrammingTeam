__author__ = 'emcenrue'

#n, k, p, x, y
#n: total tests to write
#k: total tests he has already written
#p: max score for a test
#x: max total points; if his total score is greater, then -1
#y: minimum median; if median is lower than this then -1

n, k, p, x, y = map(int, input().split())
totScore = 0
atMed = 0
belowMed = 0
scoresToPrint = list()

curScores = list(map(int, input().split()))
for score in curScores:
    if score >= y:
        atMed += 1
    else:
        belowMed += 1

while len(curScores) < n:
    if belowMed >= atMed:
        curScores.append(y)
        scoresToPrint.append(y)
        atMed += 1
    else:
        curScores.append(1)
        scoresToPrint.append(1)
        belowMed += 1



# alternate test scores between median and 1 (store these in a list)
curScores.sort()
if sum(curScores) > x or curScores[int(((n+1)/2)-1)] < y:
    print("-1")
else:
    print(' '.join(map(str, scoresToPrint)))

#print(sum(curScores))
#print(scoresToPrint)

# if the total is > x then -1
# sort the list, if the median < y then -1
# otherwise print out the list of your own stuff