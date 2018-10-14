import math

m = int(input())
n = int(input())
output = 0
for i in range(m, n):
    string = str(i)
    length = len(string)
    middle = math.floor(length)
    count = 0
    for j in range(length):
        char = int(string[j])
        opposite = int(string[length - j - 1])
        if ((char == 0 or char == 1 or char == 8) and char == opposite) or (char == 6 and opposite == 9) \
                or (char == 9 and opposite == 6):
            count += 1
    if count == middle:
        # print(i)
        output += 1
print(output)
