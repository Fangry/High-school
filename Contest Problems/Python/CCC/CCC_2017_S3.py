n = int(input())
boards = list(map(int, input().split()))
buckets = []
sums = []
maxSum = 0
countMax= 0

for i in range(2001):
    buckets.append(0)
    sums.append(0)

for i in range(2001, 4001):
    sums.append(0)

for l in boards:
    buckets[l] += 1

for i in range(1, 2001):
    if buckets[i]:
        for j in range(i, 2001):
            if i == j:
                sums[i + j] += buckets[i] >> 1
            elif buckets[j]:
                sums[i + j] += min(buckets[i], buckets[j])


for i in range(1, 4001):
    if sums[i] > maxSum:
        maxSum = sums[i]
        countMax = 1
    elif sums[i] == maxSum:
        countMax += 1

print(maxSum, countMax)