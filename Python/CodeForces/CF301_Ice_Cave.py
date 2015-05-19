__author__ = 'emcenrue'
import queue
#TODO replace with deque


class Position(object):
    def __init__(self, row, column):
        self.row = row
        self.column = column

    def __eq__(self, other):
        if(self.row == other.row and self.column == other.column):
            return True
        else:
            return False

n, m = list(map(int, input().split()))
startMatrix = [list(input()) for x in range(n)] #startMatrix[row][column]
startRow, startColumn = list(map(int, input().split()))
startPos = Position(startRow-1, startColumn-1)
endRow, endColumn = list(map(int, input().split()))
endPos = Position(endRow-1, endColumn-1)


def create_state(stateMatrix, position):
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
        for row in range(len(self.curMatrix)):
            for col in range(len(self.curMatrix[0])):
                if(self.curMatrix[row][col] == 'X'):
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
    def get_adjacent_states(self):
        #calculate a new matrix from curMatrix based on horizontal and vertical position movements
        #curMatrix & curPosition
        adjStates = list()
        if(self.curPosition.column > 0):
            # Subtract one from the column of the current position
            leftPos = Position(self.curPosition.row, self.curPosition.column - 1)
            if(self.curMatrix[leftPos.row][leftPos.column] == '.' or leftPos.__eq__(endPos)):
                adjStates.append(create_state(self.curMatrix, leftPos))

        if(self.curPosition.column < len(self.curMatrix[0]) - 1):
            # Add one to the column of the current position
            rightPos = Position(self.curPosition.row, self.curPosition.column + 1)
            if(self.curMatrix[rightPos.row][rightPos.column] == '.' or rightPos.__eq__(endPos)):
                adjStates.append(create_state(self.curMatrix, rightPos))

        if(self.curPosition.row > 0):
            # Subtract one from the current position's row
            downPos = Position(self.curPosition.row-1, self.curPosition.column)
            if(self.curMatrix[downPos.row][downPos.column] == '.' or downPos.__eq__(endPos)):
                adjStates.append(create_state(self.curMatrix, downPos))

        if(self.curPosition.row < len(self.curMatrix) - 1
           and not(self.curMatrix[self.curPosition.row + 1][self.curPosition.column] == 'X')):
            # Add one to the row of the current position
            upPos = Position(self.curPosition.row + 1, self.curPosition.column)

            if(self.curMatrix[upPos.row][upPos.column] == '.' or upPos.__eq__(endPos)):
                adjStates.append(create_state(self.curMatrix, upPos))
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





initialState = create_state(startMatrix, startPos)

testAdj = initialState.get_adjacent_states()
for adj in testAdj:
    adj.__repr__()
    print()



def is_final_state(curState):
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

        for i, row in enumerate(curState.curMatrix):
            for j, col in enumerate(curState.curMatrix[i]):
                print(curState.curMatrix[i][j], end='')
            print()
        print("above this shit")

        #check to see if it's the final state, if so flag, break, and print
        if(is_final_state(curState)):
            bfsCompleteFlag = 1
            break

        #get the curState's neighbors, and queue them up if they haven't been visited yet
        for adj in curState.get_adjacent_states():
            if not(knownSet[adj.__hash__()] == 1):
                toBeVisited.put(adj)


matrixBFS(initialState)
if(bfsCompleteFlag):
    print("YES")
else:
    print("NO")






