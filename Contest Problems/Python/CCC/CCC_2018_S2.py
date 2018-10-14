def pt(t):
    for i in range(n):
        for j in range(n):
            print(t[i][j], '', end="")
        print()


n = int(input())
t = []
turns = 0  # how many cc turns
for i in range(n):
    t.append(list(map(int, input().split())))

if t[0][1] > t[0][0] < t[1][0]:
    pt(t)
else:
    if t[0][1] < t[0][0] < t[1][0]:
        turns = 3
    elif t[0][0] > t[0][1] and t[0][0] > t[1][0]:
        turns = 2
    else:
        turns = 1

    for i in range(turns):
        nt = []
        for j in range(n):
            row = []
            for k in range(n):
                row.append(t[n - k - 1][j])
            nt.append(row)
        t = nt
    pt(nt)
