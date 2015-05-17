__author__ = 'emcenrue'

n, m = list(map(int, input().split()))

matrix = [list(input()) for x in range(n)]

startX, startY = list(map(int, input().split()))
endX, endY = list(map(int, input().split()))

def hashMatrix(matrix):
    hash = 0
    for row in range(len(matrix)):
        for col in range(len(matrix[0])):
            if(matrix[row][col] == 'X'):
                hash += 2 * (row + len(matrix[0]) * col)
            else:
                hash += 1 * (row + len(matrix[0]) * col)
    return hash

#need to hash the matrix & add it to dictionary
#need to traverse the matrix using BFS
    # check to see if neighboring moves are in dictionary
    # if not, add it to the queue


print(hashMatrix(matrix))



