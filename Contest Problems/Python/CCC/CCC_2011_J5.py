n = int(input())
ways = [1] * 7
for i in range(1, n):
    y = int(input())
    ways[y] *= (1 + ways[i])

print(ways[n])
