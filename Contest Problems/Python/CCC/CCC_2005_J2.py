start = int(input())
end = int(input())
totalRSA = 0

for i in range(start, end + 1):
    factors = 0
    for j in range(2, (i // 2) + 1):
        if i % j == 0:
            factors += 1
            # print(i, j)
        if factors > 2:
            break
    if factors == 2:
        # print(i)
        totalRSA += 1

print("The number of RSA numbers between", start, "and", end, "is", totalRSA)
