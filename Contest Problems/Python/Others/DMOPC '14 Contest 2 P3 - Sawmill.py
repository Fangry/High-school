n = int(input())
ene = list(map(int, input().split()))
log = list(map(int, input().split()))
ene.sort()
log.sort(reverse=True)
sum = 0
for i in range(n):
    sum += ene[i] * log[i]

print(sum)