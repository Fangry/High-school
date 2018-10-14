nj = int(input())
na = int(input())
j = []
a = []
count = 0
for i in range(nj):
    line = input()
    if line == 'L':
        line = 3
    elif line == 'M':
        line = 2
    else:
        line = 1
    j.append(line)
for i in range(na):
    line = input().split()
    size = line[0]
    if size == 'L':
        line[0] = 3
    elif size == 'M':
        line[0] = 2
    else:
        line[0] = 1
    a.append(line)
# print(j, a)
for i in range(na):
    for k in range(nj):
        # print(a[i][0], j[k], a[i][1], k + 1)
        if a[i][0] <= j[k] and int(a[i][1]) == k + 1:
            count += 1
            j[k] = -1
            continue
# print(j, a)
print(count)
