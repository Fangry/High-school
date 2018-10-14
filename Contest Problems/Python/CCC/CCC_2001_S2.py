from math import *

x=int(input())
y=int(input())

diff = y - x + 1
width = floor(sqrt(diff))

extraRow = 0
if diff - width ** 2 > 0:
    extraRow = 1

lstSpiral = []
for i in range(0, width + extraRow):  # i = 0 to width+extraRow-1
    lstSpiral.append([0] * width)

currentNum = y
direction = "right"
row = 0;
remainder = diff - width ** 2
col = width - remainder

for i in range(0, col):
    lstSpiral[0][i] = -1
lstSpiral[row][col] = currentNum

while currentNum > x:
    print(lstSpiral,direction,currentNum,row,col)
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
    for j in range(width):
        if lstSpiral[i][j] == -1:
            print("  ", end=" ")
        else:
            print(lstSpiral[i][j], end=" ")
    print()