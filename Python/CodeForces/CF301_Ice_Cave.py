__author__ = 'emcenrue'
import queue

class Position(object):
    def __init__(self, row, column):
        self.row = row
        self.column = column


def createState(stateMatrix, position):
    newMatrix = list()
    newMatrix = [stateMatrix[row] for row in range(len(stateMatrix))]
    newMatrix[position.row][position.column] = 'X'
    return State(newMatrix, position)

class State(object):

    def __init__(self, matrix, curPosition):
        self.curMatrix = matrix
        self.curPosition = curPosition

    def __hash__(self):
        hash = 0
        mult = 1
        for row in range(len(self.matrix)):
            for col in range(len(self.matrix[0])):
                if(self.matrix[row][col] == 'X'):
                    hash += mult * 1
                mult*=2
        return hash

    def __eq__(self, other):
        for i, row in enumerate(other.curMatrix):
            for j, col in enumerate(other.curMatrix[0]):
                if not(self.curMatrix[i][j] == other.curMatrix[i][j]):
                    return False
        return True


    #adjacentStates
    def getAdjacentStates(self):
        #calculate a new matrix from curMatrix based on horizontal and vertical position movements
        #curMatrix & curPosition
        adjStates = list()
        if(self.curPosition.column > 0
           and not(self.curMatrix[self.curPosition.row][self.curPosition.column - 1])):
            # Subtract one from the column of the current position
            leftPos = Position(self.curPosition.row, self.curPosition.column - 1)
            adjStates.append(createState(self.curMatrix, leftPos))

        if(self.curPosition.column < len(self.curMatrix[0]) - 1
           and not(self.curMatrix[self.curPosition.row][self.curPosition.column + 1] == 'X')):
            # Add one to the column of the current position
            rightPos = Position(self.curPosition.row, self.curPosition.column + 1)
            adjStates.append(createState(self.curMatrix, rightPos))

        if(self.curPosition.row > 0
           and not(self.curMatrix[self.curPosition.row - 1][self.curPosition.column] == 'X')):
            # Subtract one from the current position's row
            downPos = Position(self.curPosition.row-1, self.curPosition.column)
            adjStates.append(createState(self.curMatrix, downPos))

        if(self.curPosition.row < len(self.curMatrix) - 1
           and not(self.curMatrix[self.curPosition.row + 1][self.curPosition.column] == 'X')):
            # Add one to the row of the current position
            upPos = Position(self.curPosition.row + 1, self.curPosition.column)
            adjStates.append(createState(self.curMatrix, upPos))
        #print()
        return adjStates

        #for i, row in enumerate(self.curMatrix):
        #    for j, col in enumerate(self.curMatrix[i]):
        #        print(self.curMatrix[i][j], end='')
        #    print()
        #print("above this shit")



    def __repr__(self):
        for i, row in enumerate(self.curMatrix):
            for j, col in enumerate(self.curMatrix[i]):
                print(self.curMatrix[i][j], end='')
            print()



n, m = list(map(int, input().split()))
startMatrix = [list(input()) for x in range(n)] #startMatrix[row][column]
startRow, startColumn = list(map(int, input().split()))
startPos = Position(startRow-1, startColumn-1)
endRow, endColumn = list(map(int, input().split()))
endPos = Position(endRow-1, endColumn-1)

initialState = createState(startMatrix, startPos)

testAdj = initialState.getAdjacentStates()
for adj in testAdj:
    adj.__repr__()
    print()

def isFinalState(curState):
    if(curState.curPosition.row == endPos.row and curState.curPosition.column == endPos.column):
        return True
    else:
        return False


bfsCompleteFlag = 0
def matrixBFS(initialState):
    # initialize datastructures
    knownSet = dict()
    toBeVisited = queue()

    # give the algorithm initial parameters
    knownSet[initialState.__hash__()] = 1
    toBeVisited.put(initialState)

    while not(toBeVisited.empty):
        #remove a state from the front of the queue
        curState = toBeVisited.get()
        knownSet[curState.initialState.__hash__()] = 1

        #check to see if it's the final state, if so flag, break, and print
        if(isFinalState(curState)):
            bfsCompleteFlag = 1
            break

        #get the curState's neighbors, and queue them up if they haven't been visited yet
        for adj in curState.getAdjacentStates():
            if not(knownSet[adj.__hash__()] == 1):
                toBeVisited.put(adj)



if(bfsCompleteFlag):
    print("YES")
else:
    print("NO")





