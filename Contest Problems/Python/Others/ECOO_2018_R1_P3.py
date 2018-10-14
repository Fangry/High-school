for i in range(10):
    nxyz = list(map(int, input().split()))
    codes = []
    answers = []
    fails = []

    for j in range(nxyz[0]):
        codes.append(input())
    ans = input()
    for k in range(nxyz[0]):
        answers.append(input())
    end = input()

    for x in range(nxyz[0]):
        new = []
        for k in range(len(codes[x])):
            num = int(codes[x][k])
            if num == 0:
                new.append(str(nxyz[3]))
            elif num % 2 == 0:
                new.append(str(num + nxyz[1]))
            else:
                if num - nxyz[2] < 0:
                    new.append('0')
                else:
                    new.append(str(num - nxyz[2]))
        if ''.join(new) != answers[x]:
            fails.append(str(x + 1))

    if fails:
        print('FAIL:', ','.join(fails))
    else:
        print('MATCH')
