n, m = [int(x) for x in input().split()]
board = [[0] * n for x in range(n)]

for i in range(m):
    x, y = [int(x) - 1 for x in input().split()]
    xydiff = x - y
    xygap = xydiff
    for row in range(n):
        if row == x:
            board[row] = [1] * n
            continue
        for col in range(n):
            dist = min(abs(x - row), abs(y - col))
            if col == y:
                board[row][col] = 1
                continue
            if (x + dist == row and y + dist == col) or (x - dist == row and y + dist == col) or (
                    x + dist == row and y - dist == col) or (x - dist == row and y - dist == col):
                board[row][col] = 1

output = 0
for row in board:
    for val in row:
        if val == 0:
            output += 1
print(output)
