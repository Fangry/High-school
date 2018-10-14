# (x,y,left-right) -> (x,y)
states = {
    (0, 1, 2): (1, 0),
    (0, -1, 2): (-1, 0),
    (1, 0, 2): (0, -1),
    (-1, 0, 2): (0, 1),
    (0, 1, 3): (-1, 0),
    (0, -1, 3): (1, 0),
    (1, 0, 3): (0, 1),
    (-1, 0, 3): (0, -1)
}

N = int(input())

for n in range(N):
    x_dir = 0
    y_dir = 1
    x_pos = 0
    y_pos = 0

    dir = -1
    while dir != 0:
        dir = int(input())
        if dir == 0:
            print('Distance is', str(abs(x_pos) + abs(y_pos)))
            while True:
                if x_pos == 0 and y_pos == 0:
                    break
                elif x_dir * abs(x_pos) + x_pos == 0 and x_pos != 0:
                    print(1)
                    print(abs(x_pos))
                    x_pos = 0
                    continue
                elif y_dir * abs(y_pos) + y_pos == 0 and y_pos != 0:
                    print(1)
                    print(abs(y_pos))
                    y_pos = 0
                    continue
                else:
                    for times in range(1, 3):
                        # try going left
                        newState = states[(x_dir, y_dir, 3)]
                        if times == 2:
                            newState = states[(x_dir, y_dir, 3)]
                        x_dir = newState[0]
                        y_dir = newState[1]
                        if x_dir * abs(x_pos) + x_pos == 0 and x_pos != 0:
                            print(3)
                            print(1)
                            print(abs(x_pos))
                            x_pos = 0
                            continue
                        elif y_dir * abs(y_pos) + y_pos == 0 and y_pos != 0:
                            print(3)
                            print(1)
                            print(abs(y_pos))
                            y_pos = 0
                            continue
                        else:
                            # revert back
                            newState = states[(x_dir, y_dir, 2)]
                            if times == 2:
                                newState = states[(x_dir, y_dir, 2)]
                            x_dir = newState[0]
                            y_dir = newState[1]

                        # try going right
                        newState = states[(x_dir, y_dir, 2)]
                        x_dir = newState[0]
                        y_dir = newState[1]
                        if x_dir * abs(x_pos) + x_pos == 0 and x_pos != 0:
                            print(2)
                            print(1)
                            print(abs(x_pos))
                            x_pos = 0
                            continue
                        elif y_dir * abs(y_pos) + y_pos == 0 and y_pos != 0:
                            print(2)
                            print(1)
                            print(abs(y_pos))
                            y_pos = 0
                            continue
                        else:
                            # revert back
                            newState = states[(x_dir, y_dir, 3)]
                            if times == 2:
                                newState = states[(x_dir, y_dir, 3)]
                            x_dir = newState[0]
                            y_dir = newState[1]

            print()
            break

        if dir == 2 or dir == 3:
            newState = states[(x_dir, y_dir, dir)]
            x_dir = newState[0]
            y_dir = newState[1]

        if dir == 1:
            move = int(input())
            x_pos += move * x_dir
            y_pos += move * y_dir
