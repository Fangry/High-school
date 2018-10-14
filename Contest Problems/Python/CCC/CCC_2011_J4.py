cave = {}
x, y = -1, -5

for i in range(-200, 201):
    for j in range(-1, -201, -1):
        cave[i, j] = False
cave[0, -1] = True
cave[0, -2] = True
cave[0, -3] = True
cave[1, -3] = True
cave[2, -3] = True
cave[3, -3] = True
cave[3, -4] = True
cave[3, -5] = True
cave[4, -5] = True
cave[5, -5] = True
cave[5, -4] = True
cave[5, -3] = True
cave[6, -3] = True
cave[7, -3] = True
cave[7, -4] = True
cave[7, -5] = True
cave[7, -6] = True
cave[7, -7] = True
cave[6, -7] = True
cave[5, -7] = True
cave[4, -7] = True
cave[3, -7] = True
cave[2, -7] = True
cave[1, -7] = True
cave[0, -7] = True
cave[-1, -7] = True
cave[-1, -6] = True
cave[-1, -5] = True

while True:
    line = input().split()
    dir = line[0]
    dist = int(line[1])
    ver = 0
    hor = 0
    output = 'safe'

    if dir == 'q':
        break
    elif dir == 'u':
        ver = 1
    elif dir == 'r':
        hor = 1
    elif dir == 'd':
        ver = -1
    elif dir == 'l':
        hor = -1

    while dist > 0:
        x += hor
        y += ver
        if cave[x, y]:
            output = 'DANGER'
        else:
            cave[x, y] = True
        dist -= 1
    print(x, y, output)
