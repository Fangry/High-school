import math

t = int(input())
s = int(input())
h = int(input())
trident = []
width = 3 + s * 2
mid = math.ceil((3 + s * 2) / 2)
height = t + 1 + h

for i in range(height):
    if i < t:
        trident.append(['*', ' ' * s, '*', ' ' * s, '*'])
    elif i == t:
        trident.append(['*' * width])
    else:
        trident.append([' ' * (s + 1), '*', ' ' * (s + 1)])

for i in range(height):
    for j in range(len(trident[i])):
        print(trident[i][j], end="")
    print()
