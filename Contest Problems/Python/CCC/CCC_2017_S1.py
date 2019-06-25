n = int(input())
lst1 = list(map(int, input().split()))
lst2 = list(map(int, input().split()))
s1, s2 = 0, 0
k = 0

for i in range(n):
    s1 += lst1[i]
    s2 += lst2[i]
    if s1 == s2:
        k = i+1

print(k)
