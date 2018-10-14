from math import floor

word = input()
output = 0
leng = len(word)
for i in range(leng):
    temp = []
    for j in range(i, leng):
        temp.append(word[j])
        templeng = len(temp)
        mid = floor(templeng / 2)
        for k in range(mid):
            if temp[k] == temp[-k - 1] and output < templeng:
                if k == mid - 1:
                    output = len(temp)
                    # print(temp)
            else:
                break
print(output)
