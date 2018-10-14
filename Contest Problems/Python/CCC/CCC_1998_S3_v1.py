n = int(input())

for i in range(n):
    dir = 100  # 100 is up, 101 is right, 100 is left... start at 100 instead of 0 cuz don't want to deal with dir being negative
    dir_name = ''
    xdist, ydist = 0, 0

    while True:
        num = int(input())
        if num == 0:  # exit
            break
        elif num == 1:  # forward
            dist = int(input())
            if dir % 4 == 0:
                ydist += dist
                dir_name = 'up'
            elif (dir - 1) % 4 == 0:
                xdist += dist
                dir_name = 'right'
            elif (dir - 2) % 4 == 0:
                ydist -= dist
                dir_name = 'down'
            else:
                xdist -= dist
                dir_name = 'left'
        elif num == 2:  # turn right
            dir += 1
        elif num == 3:  # turn left
            dir -= 1

    abs_xdist = abs(xdist)
    abs_ydist = abs(ydist)
    commands = []

    if abs_xdist + abs_ydist != 0:
        if xdist > 0 and ydist == 0:
            if dir_name == 'up':
                commands = [3, 1, abs_xdist]
            elif dir_name == 'right':
                commands = [3, 3, 1, abs_xdist]
            elif dir_name == 'down':
                commands = [2, 1, abs_xdist]
            else:
                commands = [1, abs_xdist]
        elif xdist == 0 and ydist > 0:
            if dir_name == 'up':
                commands = [2, 2, 1, abs_ydist]
            elif dir_name == 'right':
                commands = [2, 1, abs_ydist]
            elif dir_name == 'down':
                commands = [1, abs_ydist]
            else:
                commands = [3, 1, abs_ydist]
        elif xdist < 0 and ydist == 0:
            if dir_name == 'up':
                commands = [2, 1, abs_xdist]
            elif dir_name == 'right':
                commands = [1, abs_xdist]
            elif dir_name == 'down':
                commands = [3, 1, abs_xdist]
            else:
                commands = [2, 2, 1, abs_xdist]
        elif xdist == 0 and ydist < 0:
            if dir_name == 'up':
                commands = [1, abs_ydist]
            elif dir_name == 'right':
                commands = [3, 1, abs_ydist]
            elif dir_name == 'down':
                commands = [2, 2, 1, abs_ydist]
            else:
                commands = [2, 1, abs_ydist]
        elif xdist > 0 and ydist > 0:  # Q1
            if dir_name == 'up':
                commands = [3, 1, abs_xdist, 3, 1, abs_ydist]
            elif dir_name == 'right':
                commands = [2, 1, abs_ydist, 2, 1, abs_xdist]
            elif dir_name == 'down':
                commands = [1, abs_ydist, 2, 1, abs_xdist]
            else:
                commands = [1, abs_xdist, 3, 1, abs_ydist]
        elif xdist < 0 < ydist:  # Q2
            if dir_name == 'up':
                commands = [2, 1, abs_xdist, 2, 1, abs_ydist]
            elif dir_name == 'right':
                commands = [3, 1, abs_ydist, 3, 1, abs_xdist]
            elif dir_name == 'down':
                commands = [abs_ydist, 3, 1, abs_xdist]
            else:
                commands = [2, 1, abs_ydist, 3, 1, abs_xdist]
        elif xdist < 0 and ydist < 0:  # Q3
            if dir_name == 'up':
                commands = [1, abs_ydist, 2, 1, abs_xdist]
            elif dir_name == 'right':
                commands = [2, 1, abs_ydist, 2, 1, abs_xdist]
            elif dir_name == 'down':
                commands = [3, 1, abs_xdist, 3, 1, abs_ydist]
            else:
                commands = [abs_xdist, 3, 1, abs_ydist]
        else:  # Q4
            if dir_name == 'up':
                commands = [1, abs_ydist, 3, 1, abs_xdist]
            elif dir_name == 'right':
                commands = [3, 1, abs_ydist, 3, 1, abs_xdist]
            elif dir_name == 'down':
                commands = [2, 1, abs_xdist, 2, 1, abs_ydist]
            else:
                commands = [1, abs_xdist, 2, 1, abs_ydist]

    print('Distance is', (abs_xdist + abs_ydist))
    for x in commands:
        print(x)
    print()
