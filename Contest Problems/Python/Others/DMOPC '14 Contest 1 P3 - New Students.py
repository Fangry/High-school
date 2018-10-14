o = int(input())
old = []
for i in range(o):
    old.append(int(input()))
old_sum = sum(old)

n = int(input())
for i in range(n):
    old_sum += int(input())
    print(round(old_sum / (o + i + 1), 3))
