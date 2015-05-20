__author__ = 'emcenrue'
from queue import Queue

class Position(object):
    def __init__(self, row, column):
        self.row = row
        self.column = column

    def __eq__(self, other):
        if self.row == other.row and self.column == other.column:
            return True
        else:
            return False

n, m = list(map(int, input().split()))
startMatrix = [list(input()) for x in range(n)] #startMatrix[row][column]
startRow, startColumn = list(map(int, input().split()))
startPos = Position(startRow-1, startColumn-1)
endRow, endColumn = list(map(int, input().split()))
endPos = Position(endRow-1, endColumn-1)

end_was_x = 0
if startMatrix[endPos.row][endPos.column] == 'X':
    end_was_x = 1
#print("end_was_x",end_was_x)


def create_state(stateMatrix, position, visit_end):
    newMatrix = [list(row) for row in stateMatrix]
    newMatrix[position.row][position.column] = 'X'
    return State(newMatrix, position, visit_end)

class State(object):

    def __init__(self, matrix, curPosition, _visited_end):
        self.curMatrix = matrix
        self.curPosition = curPosition
        self._visited_end = _visited_end

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
        if self.curPosition.column > 0:
            # Subtract one from the column of the current position
            leftPos = Position(self.curPosition.row, self.curPosition.column - 1)
            if self.curMatrix[leftPos.row][leftPos.column] == '.' or leftPos.__eq__(endPos):
                adjStates.append(create_state(self.curMatrix, leftPos, self._visited_end))

        if self.curPosition.column < len(self.curMatrix[0]) - 1:
            # Add one to the column of the current position
            rightPos = Position(self.curPosition.row, self.curPosition.column + 1)
            if self.curMatrix[rightPos.row][rightPos.column] == '.' or rightPos.__eq__(endPos):
                adjStates.append(create_state(self.curMatrix, rightPos, self._visited_end))

        if self.curPosition.row > 0:
            # Subtract one from the current position's row
            downPos = Position(self.curPosition.row-1, self.curPosition.column)
            if self.curMatrix[downPos.row][downPos.column] == '.' or downPos.__eq__(endPos):
                adjStates.append(create_state(self.curMatrix, downPos, self._visited_end))

        if self.curPosition.row < len(self.curMatrix) - 1:
            # Add one to the row of the current position
            upPos = Position(self.curPosition.row + 1, self.curPosition.column)

            if(self.curMatrix[upPos.row][upPos.column] == '.' or upPos.__eq__(endPos)):
                adjStates.append(create_state(self.curMatrix, upPos, self._visited_end))
        #print()
        return adjStates

        #for i, row in enumerate(self.curMatrix):
        #    for j, col in enumerate(self.curMatrix[i]):
        #        print(self.curMatrix[i][j], end='')
        #    print()
        #print("above this")



    def __repr__(self):
        for i, row in enumerate(self.curMatrix):
            for j, col in enumerate(self.curMatrix[i]):
                print(self.curMatrix[i][j], end='')
            print()
        global endPos
        if self.curPosition.__eq__(endPos):
            print("at end position///////////////////////////////")
        else:
            print("not at end position")
        print("testing _visited_end: ",self._visited_end)





initialState = create_state(startMatrix, startPos, 0)

#testAdj = initialState.get_adjacent_states()
#for adj in testAdj:
#    adj.__repr__()
#    print()

count = 0
#print(endPos.row, endPos.column)
def is_final_state(curState):
    if(curState.curPosition.row == endPos.row and curState.curPosition.column == endPos.column and not(count == 1)):
        curState._visited_end += 1
        global end_was_x
        if (end_was_x == 0 and curState._visited_end == 2) or (end_was_x == 1 and curState._visited_end == 1):
            return True
        else:
            return False
    else:
        return False



bfs_complete_flag = 0

def matrix_bfs(initialState):
    # initialize datastructures
    knownSet = dict()
    toBeVisited = Queue()


    # give the algorithm initial parameters
    knownSet[initialState.__hash__()] = 1
    toBeVisited._put(initialState)

    while not(toBeVisited.empty()):
        global count
        count += 1
        #remove a state from the front of the queue
        curState = toBeVisited.get()
        global endPos
        if not(curState.curPosition.__eq__(endPos)):
            knownSet[curState.__hash__()] = 1



        #check to see if it's the final state, if so flag, break, and print
        if(is_final_state(curState)):
            global bfs_complete_flag
            bfs_complete_flag = 1
            break

        #curState.__repr__()
        #print(curState.curPosition.row, curState.curPosition.column)
        #print()

        #get the curState's neighbors, and queue them up if they haven't been visited yet
        for adj in curState.get_adjacent_states():
            if not(adj.__hash__ in knownSet):
                toBeVisited.put(adj)


matrix_bfs(initialState)

if bfs_complete_flag == 1 and not(count == 1 and endPos.__eq__(startPos)):
    print("YES")
else:
    print("NO")






