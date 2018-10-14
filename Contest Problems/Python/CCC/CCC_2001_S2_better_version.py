from math import *

x=int(input())
y=int(input())

diff = y - x + 1
width = floor(sqrt(diff))

extraCol = 0
if diff - width**2 > width:
    extraCol = 1

extraRow = 0
if diff - width ** 2 > 0:
    extraRow = 1

lstSpiral = []
for i in range(0, width + extraRow):  # i = 0 to width+extraRow-1
    lstSpiral.append([0] * (width + extraCol))

currentNum = y
direction = "right"
row = 0
col = 0

# if odd then start at bottom left
if width%2 == 1:
    if extraCol == 0 and extraRow == 0:
        row = width
        col = 0
        direction = "up"
    elif extraRow == 1 and extraCol == 0:
        row = width + extraRow - 1
        col = (diff - width**2)
        direction = "left"
        for i in range(col, width):
            lstSpiral[row][i] = -1
    else:
        row = width - (diff - width**2 - width)
        col = width + extraCol - 1
        direction = "down"
        for i in range(0, row+1):
            lstSpiral[i][col] = -1
# if even then start at top right
else:
    if extraCol == 0 and extraRow == 0:
        row = -1
        col = width - 1
        direction = "down"

    elif extraRow == 1 and extraCol == 0:
        row = 0
        col = width - (diff - width**2) - 1
        direction = "right"
        for i in range(0, col+1):
            lstSpiral[0][i] = -1
    else:
        row = diff - width**2 - width + 1
        col = 0
        direction = "up"
        for i in range(row, width+extraRow):
            lstSpiral[i][0] = -1

currentNum += 1
count = 0
while currentNum > x:
    count += 1
    if count == 100:
        break
    # print(lstSpiral,direction,currentNum,row,col)
    if direction == "right":
        if col + 1 < width and lstSpiral[row][col + 1] == 0:
            currentNum -= 1
            col += 1
        else:
            direction = "down"
            continue
    if direction == "down":
        if row + 1 < width + extraRow and lstSpiral[row + 1][col] == 0:
            currentNum -= 1
            row += 1
        else:
            direction = "left"
            continue
    if direction == "left":
        if col - 1 >= 0 and lstSpiral[row][col - 1] == 0:
            currentNum -= 1
            col -= 1
        else:
            direction = "up"
            continue
    if direction == "up":
        if row - 1 >= 0 and lstSpiral[row - 1][col] == 0:
            currentNum -= 1
            row -= 1
        else:
            direction = "right"
            continue
    lstSpiral[row][col] = currentNum

for i in range(width+extraRow):
    for j in range(width+extraCol):
        if lstSpiral[i][j] == -1:
            print("  ", end=" ")
        else:
            if lstSpiral[i][j] < 10:
                print(' ' + str(lstSpiral[i][j]), end=" ")
            else:
                print(lstSpiral[i][j], end=" ")
    print()