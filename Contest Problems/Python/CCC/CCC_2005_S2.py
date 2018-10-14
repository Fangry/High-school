dimensions = list(map(int, input().split()))
x, y = 0, 0

while True:
    line = list(map(int, input().split()))
    if line[0] == 0 and line[1] == 0:
        break
    result_x = x + line[0]
    result_y = y + line[1]

    if 0 <= result_x <= dimensions[0]:
        x += line[0]
    else:
        if result_x < 0:
            x = 0
        else:
            x = dimensions[0]

    if 0 <= result_y <= dimensions[1]:
        y += line[1]
    else:
        if result_y < 0:
            y = 0
        else:
            y = dimensions[1]
    print(x, y)
