def XOR(grid, r):
    for c in range(len(grid[0])):
        if (grid[r][c] == 0 and grid[r+1][c] == 1) or (grid[r][c] == 1 and grid[r+1][c] == 0):
            grid[r][c] = 1
        else:
            grid[r][c] = 0


def lst_copy(lst):
    temp = []
    for ele in lst:
        temp.append(ele[:])
    return temp


row = int(input())
col = int(input())
grid = []

for i in range(row):
    grid = [list(map(int, input().split()))] + grid
bot_row_combo = [grid[0][:]]

# figure out each diff combo & keep track
for y in range(0, row-1):
    
    grid_copy = lst_copy(grid)
    for x in range(y, -1, -1):
        # print("BEFORE XOR y=",y," x=",x,"grid[x]=",grid_copy[x])
        XOR(grid_copy, x)
        # print("AFTER XOR y=",y," x=",x,"grid[x]=",grid_copy[x])
    
    bot_row = grid_copy[0][:]
    if bot_row[:] not in bot_row_combo:
        bot_row_combo.append(bot_row)


print(len(bot_row_combo))
# print(bot_row_combo)
