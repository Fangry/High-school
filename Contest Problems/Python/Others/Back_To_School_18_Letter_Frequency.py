from sys import stdin

sentence = stdin.readline()
lines = int(stdin.readline())
for i in range(lines):
    query = stdin.readline().split()
    count = 0
    for j in range(int(query[0]) - 1, int(query[1])):
        if sentence[j] == query[2]:
            count += 1
    print(count)
