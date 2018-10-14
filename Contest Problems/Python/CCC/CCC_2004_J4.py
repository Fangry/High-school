key = input()
message = input().replace(' ', '')
block = []
alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'

counter = 0
row = []
for i in range(len(message)):
    if message[i] not in '!@#$%^&*()_+-=,.;?':
        row.append(message[i])
        counter += 1
        if counter >= len(key):
            block.append(row)
            row = []
            counter = 0
    if i == len(message) - 1:
        block.append(row)
# print(block)

for i in range(len(block)):
    for j in range(len(block[i])):
        print(alpha[(alpha.index(block[i][j]) + alpha.index(key[j])) % 26], end='')
