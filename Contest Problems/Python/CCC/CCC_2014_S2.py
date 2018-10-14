n = int(input())
partners = {}
line1 = input().split()
line2 = input().split()
output = 'good'

for i in range(n):
    if line1[i] == line2[i]:
        output = 'bad'
        break
    if line1[i] not in partners and line2[i] not in partners:
        partners[line1[i]] = line2[i]
    else:
        if partners[line2[i]] != line1[i]:
            output = 'bad'
            break
print(output)
