x = int(input())
m = int(input())
output = "No such integer exists."

for i in range(m):
    if x * i % m == 1:
        output = i

print(output)
